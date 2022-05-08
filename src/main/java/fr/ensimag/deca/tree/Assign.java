package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.STORE;

/**
 * Assignment, i.e. lvalue = expr.
 *
 * @author gl09
 * @date 01/01/2022
 */
public class Assign extends AbstractBinaryExpr {

    public Assign(AbstractLValue leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public AbstractLValue getLeftOperand() {
        // The cast succeeds by construction, as the leftOperand has been set
        // as an AbstractLValue by the constructor.
        return (AbstractLValue) super.getLeftOperand();
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {
        Type leftType = this.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);

        AbstractExpr rightOperandWithConvFloat = this.getRightOperand().verifyRValue(compiler, localEnv, currentClass, leftType);

        this.setRightOperand(rightOperandWithConvFloat);

        this.setType(leftType);

        return this.getType();
    }


    @Override
    protected String getOperatorName() {
        return "=";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        AbstractExpr rightExpr = this.getRightOperand();

        AbstractLValue var = getLeftOperand();
        DAddr addrVar;

        if (var.getDefinition().isField() && !var.getDefinition().isMatrix()) {
            compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.getR(n)));
            compiler.getStackMan().incrementPile(1);
            if (n == compiler.getCodeGen().getRmax()) {
                compiler.addInstruction(new PUSH(Register.getR(n)));
                rightExpr.codeGenInst(compiler, n);
                compiler.addInstruction(new LOAD(Register.getR(n), Register.R0));
                compiler.addInstruction(new POP(Register.getR(n)));
                compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(var.getFieldDefinition().getIndex() + 1, Register.getR(n))));
            } else {
                rightExpr.codeGenInst(compiler, n + 1);
                compiler.addInstruction(new STORE(Register.getR(n + 1), new RegisterOffset(var.getFieldDefinition().getIndex() + 1, Register.getR(n))));
            }
            compiler.getStackMan().decrementPile(1);

        } else if (var.getDefinition().isMatrix() || var.getType().isIntMatrix() || var.getType().isFloatMatrix()) {
            compiler.getStackMan().incrementPile(1);
            rightExpr.codeGenInst(compiler, n);
            if (n == compiler.getCodeGen().getRmax()) {
                compiler.addInstruction(new PUSH(Register.getR(n)));
                var.codeGenInst(compiler, n);
                compiler.addInstruction(new LOAD(Register.getR(n), Register.R0));
                compiler.addInstruction(new POP(Register.getR(n)));
            } else {
                var.codeGenInst(compiler, n + 1);
            }
            compiler.addInstruction(new STORE(Register.getR(n), new RegisterOffset(0, Register.R1)));
            compiler.getStackMan().decrementPile(1);
        } else {
            rightExpr.codeGenInst(compiler, n);
            addrVar = var.getExpDefinition().getOperand();
            compiler.addInstruction(new STORE(Register.getR(n), addrVar));
        }
    }

    @Override
    protected void codeGenJump(DecacCompiler compiler, boolean jumpOnEval, Label label, int nReg) {
        AbstractExpr rightExpr = this.getRightOperand();

        AbstractLValue var = getLeftOperand();
        DAddr addrVar;

        rightExpr.codeGenInst(compiler, nReg);
        addrVar = var.getExpDefinition().getOperand();
        compiler.addInstruction(new STORE(Register.getR(nReg), addrVar));
        rightExpr.codeGenJump(compiler, jumpOnEval, label, nReg);
    }
}
