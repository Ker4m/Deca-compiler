package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

/**
 * Print statement (print, println, ...).
 *
 * @author gl09
 * @date 01/01/2022
 */
public abstract class AbstractPrint extends AbstractInst {

    private final boolean printHex;
    private final ListExpr arguments;

    public AbstractPrint(boolean printHex, ListExpr arguments) {
        Validate.notNull(arguments);
        this.arguments = arguments;
        this.printHex = printHex;
    }

    abstract String getSuffix();

    public ListExpr getArguments() {
        return arguments;
    }

    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv,
                              ClassDefinition currentClass, Type returnType)
            throws ContextualError {
        for (AbstractExpr expr : this.arguments.getList()) {
            Type exprType = expr.verifyExpr(compiler, localEnv, currentClass);
            if (!(exprType.isInt() || exprType.isFloat() || exprType.isString())) {
                throw new ContextualError("Invalid argument to function print(ln). Args should be of type " +
                        "[int, float, String, Tab]: " + exprType.getName().getName() + " given.", getLocation());
            }
        }
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        for (AbstractExpr a : getArguments().getList()) {
            a.codeGenPrint(compiler, printHex, n);
        }
    }

    private boolean getPrintHex() {
        return printHex;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("print" + getSuffix());
        if (getPrintHex()) {
            s.print("x");
        }
        s.print("(");
        arguments.decompile(s);
        s.print(");");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        arguments.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        arguments.prettyPrint(s, prefix, true);
    }

}
