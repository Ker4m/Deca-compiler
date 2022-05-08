package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

/**
 * Binary expressions.
 *
 * @author gl09
 * @date 01/01/2022
 */
public abstract class AbstractBinaryExpr extends AbstractExpr {

    private AbstractExpr leftOperand;
    private AbstractExpr rightOperand;

    public AbstractBinaryExpr(AbstractExpr leftOperand,
                              AbstractExpr rightOperand) {
        Validate.notNull(leftOperand, "left operand cannot be null");
        Validate.notNull(rightOperand, "right operand cannot be null");
        Validate.isTrue(leftOperand != rightOperand, "Sharing subtrees is forbidden");
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public AbstractExpr getLeftOperand() {
        return leftOperand;
    }

    protected void setLeftOperand(AbstractExpr leftOperand) {
        Validate.notNull(leftOperand);
        this.leftOperand = leftOperand;
    }

    public AbstractExpr getRightOperand() {
        return rightOperand;
    }

    protected void setRightOperand(AbstractExpr rightOperand) {
        Validate.notNull(rightOperand);
        this.rightOperand = rightOperand;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("(");
        getLeftOperand().decompile(s);
        s.print(" " + getOperatorName() + " ");
        getRightOperand().decompile(s);
        s.print(")");
    }

    abstract protected String getOperatorName();

    @Override
    protected void iterChildren(TreeFunction f) {
        leftOperand.iter(f);
        rightOperand.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        leftOperand.prettyPrint(s, prefix, false);
        rightOperand.prettyPrint(s, prefix, true);
    }

    protected Instruction mnemo(DVal leftOperand, GPRegister rightOperand) {
        throw new UnsupportedOperationException("This method shouldn't be called here");
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        AbstractExpr leftExpr = this.getLeftOperand();
        AbstractExpr rightExpr = this.getRightOperand();
        leftExpr.codeGenInst(compiler, n);
        if (n == compiler.getCodeGen().getRmax()) {
            compiler.addInstruction(new PUSH(Register.getR(n)));
            compiler.getStackMan().incrementPile(1);
            rightExpr.codeGenInst(compiler, n);
            compiler.addInstruction(new LOAD(Register.getR(n), Register.R0));
            compiler.addInstruction(new POP(Register.getR(n)));
            compiler.getStackMan().decrementPile(1);
            compiler.addInstruction(this.mnemo(Register.R0, Register.getR(n)));

        } else {
            compiler.getStackMan().incrementPile(1);
            rightExpr.codeGenInst(compiler, n + 1);
            compiler.addInstruction(this.mnemo(Register.getR(n + 1), Register.getR(n)));
            compiler.getStackMan().decrementPile(1);
        }

        if (this.getOperatorName().equals("/") || this.getOperatorName().equals("%")) {
            AssError.addErrorDivZero(compiler);
        }

        if (leftOperand.getType().isFloat() && rightOperand.getType().isFloat() && this.getOperatorName().equals("*")) {
            AssError.addErrorDebordementArith(compiler);
        }
    }


}
