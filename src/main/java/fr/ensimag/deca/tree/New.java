package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.*;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class New extends AbstractExpr {
    private final AbstractIdentifier identifier;

    public New(AbstractIdentifier ident) {
        Validate.notNull(ident);
        this.identifier = ident;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        Type type = this.identifier.verifyType(compiler);
        this.setType(type);
        if (!this.getType().isClass()) {
            throw new ContextualError("new can't be used to declare type: " + type.getName().getName(), this.getLocation());
        }
        return type;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("new ");
        this.identifier.decompile(s);
        s.print("()");
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.identifier.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.identifier.iter(f);
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        compiler.addInstruction(new NEW(identifier.getClassDefinition().getTotalNumberOfFields() + 1, Register.getR(n)));
        AssError.addErrorTasPlein(compiler);

        compiler.addInstruction(new LEA(identifier.getClassDefinition().getOperand(), Register.R0));
        compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(0, Register.getR(n))));
        if (!identifier.getName().getName().equals("Object")) {
            compiler.getStackMan().incrementPile(3);
            compiler.addInstruction(new PUSH(Register.getR(n)));
            compiler.addInstruction(new BSR(new Label("init." + identifier.getName().getName())));
            compiler.addInstruction(new POP(Register.getR(n)));
            compiler.getStackMan().incrementPile(3);

        }

    }
}
