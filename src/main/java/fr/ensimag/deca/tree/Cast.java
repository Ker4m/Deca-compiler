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

public class Cast extends AbstractExpr {
    private final AbstractExpr expression;
    private final AbstractIdentifier type;

    public Cast(AbstractExpr expression, AbstractIdentifier type) {
        Validate.notNull(expression);
        Validate.notNull(type);
        this.expression = expression;
        this.type = type;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {

        Type expType = this.expression.verifyExpr(compiler, localEnv, currentClass);

        Type castType = this.type.verifyType(compiler);
        if ((expType.isInt() && castType.isFloat())) {
            this.setType(castType);
            return castType;
        } else if ((expType.isFloat() && castType.isInt())) {
            this.setType(castType);
            return castType;
        } else if (!expType.isClass() && expType.sameType(castType)) {
            this.setType(castType);
            return castType;
        } else if (expType.isClass() && castType.isClass() &&
                (((ClassType) expType).isSubClassOf((ClassType) castType) || ((ClassType) castType).isSubClassOf((ClassType) expType))) {
            this.setType(castType);
            return castType;
        } else {
            throw new ContextualError(
                    "Impossible to cast " + expType.getName().getName() + " to " + castType.getName().getName(),
                    this.getLocation()
            );
        }
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("(");
        this.type.decompile(s);
        s.print(") (");
        this.expression.decompile(s);
        s.print(")");
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.type.prettyPrint(s, prefix, false);
        this.expression.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.type.iter(f);
        this.expression.iter(f);
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        Type typeToCast = type.getType();
        Type typeOfVar = expression.getType();
        if (typeToCast.isInt() && typeOfVar.isFloat()) {
            expression.codeGenInst(compiler, n);
            compiler.addInstruction(new INT(Register.getR(n), Register.getR(n)));
        } else if (typeToCast.isFloat() && typeOfVar.isInt()) {
            expression.codeGenInst(compiler, n);
            compiler.addInstruction(new FLOAT(Register.getR(n), Register.getR(n)));
        } else if (typeToCast.isClass() && typeOfVar.isClassOrNull()) {

            InstanceOf testCmpClass = new InstanceOf(expression, type);
            testCmpClass.setLocation(this.getLocation());

            Label cast = new Label("cast_" + compiler.getCodeGen().getCastLabel());
            testCmpClass.codeGenJump(compiler, true, cast, n);
            compiler.addLabel(cast);
            expression.codeGenInst(compiler, n);

            compiler.getStackMan().incrementPile(1);
            if (n == compiler.getCodeGen().getRmax()) {
                compiler.addInstruction(new PUSH(Register.getR(n)));
                compiler.addInstruction(new LEA(this.type.getClassDefinition().getOperand(), Register.getR(n)));
                compiler.addInstruction(new LOAD(Register.getR(n), Register.R0));
                compiler.addInstruction(new POP(Register.getR(n)));
                compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(0, Register.getR(n))));
            } else {
                compiler.addInstruction(new LEA(this.type.getClassDefinition().getOperand(), Register.getR(n + 1)));
                compiler.addInstruction(new STORE(Register.getR(n + 1), new RegisterOffset(0, Register.getR(n))));
            }
            compiler.getStackMan().decrementPile(1);

        }

    }

}
