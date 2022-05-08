package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.LOAD;

import java.io.PrintStream;

public class This extends AbstractExpr {

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {

        if (currentClass == null) {
            throw new ContextualError("Cannot use 'this' in main program", getLocation());
        }

        if (!currentClass.isClass()) {
            throw new ContextualError("This is not in a class declaration", getLocation());
        }

        Type type = currentClass.getType();
        this.setType(type);
        return type;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("this");
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.getR(n)));
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // leaf node => nothing to do

    }

    @Override
    protected void iterChildren(TreeFunction f) {
        // leaf node => nothing to do

    }

}
