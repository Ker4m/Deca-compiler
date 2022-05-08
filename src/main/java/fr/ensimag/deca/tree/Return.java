package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.BRA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class Return extends AbstractInst {

    private final AbstractExpr value;

    public Return(AbstractExpr value) {
        Validate.notNull(value);
        this.value = value;
    }

    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass,
                              Type returnType) throws ContextualError {
        Type valueType = this.value.verifyExpr(compiler, localEnv, currentClass);
        returnType = compiler.getEnvType().getType(compiler.getSymbols().create(returnType.getName().getName())).getType();
        valueType = compiler.getEnvType().getType(compiler.getSymbols().create(valueType.getName().getName())).getType();
        if (valueType != returnType) {
            throw new ContextualError("Invalid argument to condition in return statement. Return type does" +
                    "not match with type provided : " + valueType.getName().getName() + " given, " +
                    returnType.getName().getName() + " expected.", getLocation());
        }
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        value.codeGenInst(compiler, n);
        compiler.addInstruction(new LOAD(Register.getR(n), Register.R0));
        String className = compiler.getCodeGen().getCurClass().getIdClass().getName().getName();
        String methodName = compiler.getCodeGen().getCurMethod().getIdMethod().getName().getName();
        compiler.addInstruction(new BRA(new Label("fin." + className + "." + methodName)));

    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("return ");
        value.decompile(s);
        s.println(";");
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        value.prettyPrint(s, prefix, false);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        value.iterChildren(f);
    }

}
