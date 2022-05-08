package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.DecacInternalError;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Label;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

/**
 * Expression, i.e. anything that has a value.
 *
 * @author gl09
 * @date 01/01/2022
 */
public abstract class AbstractExpr extends AbstractInst {
    private Type type;

    /**
     * Get the type decoration associated to this expression (i.e. the type computed by contextual verification).
     */
    public Type getType() {
        return type;
    }

    protected void setType(Type type) {
        Validate.notNull(type);
        this.type = type;
    }

    @Override
    protected void checkDecoration() {
        if (getType() == null) {
            throw new DecacInternalError("Expression " + decompile() + " has no Type decoration");
        }
    }

    /**
     * Verify the expression for contextual error.
     * <p>
     * implements non-terminals "expr" and "lvalue"
     * of [SyntaxeContextuelle] in pass 3
     *
     * @param compiler     (contains the "env_types" attribute)
     * @param localEnv     Environment in which the expression should be checked
     *                     (corresponds to the "env_exp" attribute)
     * @param currentClass Definition of the class containing the expression
     *                     (corresponds to the "class" attribute)
     *                     is null in the main bloc.
     * @return the Type of the expression
     * (corresponds to the "type" attribute)
     */
    public abstract Type verifyExpr(DecacCompiler compiler,
                                    EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError;

    /**
     * Verify the expression in right hand-side of (implicit) assignments
     * <p>
     * implements non-terminal "rvalue" of [SyntaxeContextuelle] in pass 3
     *
     * @param compiler     contains the "env_types" attribute
     * @param localEnv     corresponds to the "env_exp" attribute
     * @param currentClass corresponds to the "class" attribute
     * @param expectedType corresponds to the "type1" attribute
     * @return this with an additional ConvFloat if needed...
     */
    public AbstractExpr verifyRValue(DecacCompiler compiler,
                                     EnvironmentExp localEnv, ClassDefinition currentClass,
                                     Type expectedType)
            throws ContextualError {
        Type viewedType = this.verifyExpr(compiler, localEnv, currentClass);

        if (!viewedType.sameType(expectedType)) {
            if (viewedType.isInt() && expectedType.isFloat()) {
                ConvFloat floatExpr = new ConvFloat(this);
                floatExpr.verifyExpr(compiler, localEnv, currentClass);
                return floatExpr;
            } else {
                throw new ContextualError(
                        "Can't assign " + viewedType.getName().getName() +
                                " to " + expectedType.getName().getName(),
                        this.getLocation()
                );
            }
        }
        return this;
    }


    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv,
                              ClassDefinition currentClass, Type returnType)
            throws ContextualError {
        this.verifyExpr(compiler, localEnv, currentClass);
    }

    /**
     * Verify the expression as a condition, i.e. check that the type is
     * boolean.
     *
     * @param localEnv     Environment in which the condition should be checked.
     * @param currentClass Definition of the class containing the expression, or null in
     *                     the main program.
     */
    void verifyCondition(DecacCompiler compiler, EnvironmentExp localEnv,
                         ClassDefinition currentClass) throws ContextualError {

        Type conditionType = this.verifyExpr(compiler, localEnv, currentClass);

        if (!conditionType.isBoolean()) {
            throw new ContextualError("Condition must be boolean : " + conditionType.getName().getName() +
                    " given.", getLocation());
        }
    }

    /**
     * Generate code to print the expression
     *
     * @param compiler contains the "env_types" attribute
     * @param hex      true if should be printed in hexadecimal
     * @param nReg     number of the register
     */
    protected void codeGenPrint(DecacCompiler compiler, boolean hex, int nReg) {
        throw new UnsupportedOperationException("This method shouldn't be called here");
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        throw new UnsupportedOperationException("This method shouldn't be called here");
    }

    protected void codeGenJump(DecacCompiler compiler, boolean jumpOnEval, Label label, int nReg) {
        throw new UnsupportedOperationException("This method shouldn't be called here");
    }

    @Override
    protected void decompileInst(IndentPrintStream s) {
        decompile(s);
        s.print(";");
    }

    @Override
    protected void prettyPrintType(PrintStream s, String prefix) {
        Type t = getType();
        if (t != null) {
            s.print(prefix);
            s.print("type: ");
            s.print(t);
            s.println();
        }
    }
}
