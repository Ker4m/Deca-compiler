package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.NullType;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.LOAD;

import java.io.PrintStream;

public class Null extends AbstractExpr {

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass) {
        this.setType(new NullType(compiler.getSymbols().create("null")));

        return this.getType();
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("null");

    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // // leaf node => nothing to do

    }

    @Override
    protected void iterChildren(TreeFunction f) {
        // leaf node => nothing to do

    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        compiler.addInstruction(new LOAD(new NullOperand(), Register.getR(n)));
    }
}
