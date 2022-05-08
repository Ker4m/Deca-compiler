package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.*;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.*;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class InstanceOf extends AbstractExpr {

    private final AbstractExpr object;
    private final AbstractIdentifier type;

    public InstanceOf(AbstractExpr object, AbstractIdentifier type) {
        Validate.notNull(object);
        Validate.notNull(type);
        this.object = object;
        this.type = type;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {

        Type objType = this.object.verifyExpr(compiler, localEnv, currentClass);
        Type classType = this.type.verifyType(compiler);

        if (!objType.isClass()) {
            throw new ContextualError(objType.getName().getName() + " doesn't exist", this.getLocation());
        }
        if (!classType.isClass()) {
            throw new ContextualError(classType.getName().getName() + " isn't a type", this.getLocation());
        }
        Type bool = compiler.getEnvType().getType(compiler.getSymbols().create("boolean")).getType();
        this.setType(bool);
        return bool;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        this.object.decompile(s);
        s.print(" instanceof ");
        this.type.decompile(s);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.object.prettyPrint(s, prefix, false);
        this.type.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.object.iter(f);
        this.type.iter(f);
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        int labelNumber = compiler.getCodeGen().getEndInstanceOfLabel();
        Label endInstanceOf = new Label("InstanceOf_" + labelNumber);
        Label notInstanceOf = new Label("NotInstanceOf_" + labelNumber);
        this.codeGenJump(compiler, false, notInstanceOf, n);
        compiler.addInstruction(new LOAD(1, Register.getR(n)));
        compiler.addInstruction(new BRA(endInstanceOf));
        compiler.addLabel(notInstanceOf);
        compiler.addInstruction(new LOAD(0, Register.getR(n)));
        compiler.addLabel(endInstanceOf);
    }

    @Override
    protected void codeGenJump(DecacCompiler compiler, boolean jumpOnEval, Label label, int nReg) {
        Label endInstanceOf = new Label("InstanceOf_" + compiler.getCodeGen().getEndInstanceOfLabel());

        object.codeGenInst(compiler, nReg);
        compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(nReg)), Register.getR(nReg)));

        compiler.addInstruction(new LEA(this.type.getClassDefinition().getOperand(), Register.R0));
        compiler.addInstruction(new CMP(Register.R0, Register.getR(nReg)));
        if (jumpOnEval) {
            compiler.addInstruction(new BEQ(label));
        } else {
            compiler.addInstruction(new BEQ(endInstanceOf));
        }
        ClassDefinition current = null;

        ClassType classType = (ClassType) this.object.getType(); // Cast forcément valide car vérifier dans l'étape B

        current = classType.getDefinition().getSuperClass();

        while (current != null) {
            compiler.addInstruction(new LEA(current.getOperand(), Register.R0));
            compiler.addInstruction(new CMP(Register.R0, Register.getR(nReg)));
            if (jumpOnEval) {
                compiler.addInstruction(new BEQ(label));
            } else {
                compiler.addInstruction(new BEQ(endInstanceOf));
            }
            current = current.getSuperClass();
        }
        if (!jumpOnEval) {
            compiler.addInstruction(new BRA(label));
        }
        compiler.addLabel(endInstanceOf);
    }

}
