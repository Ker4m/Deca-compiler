package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

/**
 * @author gl09
 * @date 01/01/2022
 */
public class Initialization extends AbstractInitialization {

    private AbstractExpr expression;

    public Initialization(AbstractExpr expression) {
        Validate.notNull(expression);
        this.expression = expression;
    }

    public AbstractExpr getExpression() {
        return expression;
    }

    public void setExpression(AbstractExpr expression) {
        Validate.notNull(expression);
        this.expression = expression;
    }

    @Override
    protected void verifyInitialization(DecacCompiler compiler, Type t,
                                        EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        this.expression = this.expression.verifyRValue(compiler, localEnv, currentClass, t);
    }


    @Override
    public void decompile(IndentPrintStream s) {
        s.print(" = ");
        expression.decompile(s);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        expression.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        expression.prettyPrint(s, prefix, true);
    }

    @Override
    public void codeGenInit(DAddr addr, DecacCompiler comp, Type t) {
        GPRegister reg2 = Register.getR(2);
        expression.codeGenInst(comp, 2);
        comp.addInstruction(new STORE(reg2, addr));
    }

    @Override
    public void codeGenInitField(int index, DecacCompiler comp, Type t) {
        expression.codeGenInst(comp, 0);
        comp.addInstruction(new STORE(Register.R0, new RegisterOffset(index, Register.R1)));
    }

    @Override
    public void codeGenInitTab(DecacCompiler compiler, Type t) {
        // We don't deal with this case at the moment
    }
}
