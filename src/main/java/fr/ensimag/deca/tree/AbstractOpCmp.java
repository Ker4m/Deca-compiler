package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.deca.context.*;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;

/**
 * @author gl09
 * @date 01/01/2022
 */
public abstract class AbstractOpCmp extends AbstractBinaryExpr {

    public AbstractOpCmp(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {
        Type leftOperandType = this.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type rightOperandType = this.getRightOperand().verifyExpr(compiler, localEnv, currentClass);

        if ((!leftOperandType.isFloat() && !leftOperandType.isInt()) || (!rightOperandType.isFloat() && !rightOperandType.isInt())) {
            throw new ContextualError("Invalid argument for comparison operation. Args should be of type " +
                    "[int, float] : " + leftOperandType.getName().getName() + " and " +
                    rightOperandType.getName().getName() + " given.", getLocation());
        }

        if (leftOperandType.isInt() && rightOperandType.isFloat()) {
            AbstractExpr newLeftOperand = new ConvFloat(this.getLeftOperand());
            if (!newLeftOperand.verifyExpr(compiler, localEnv, currentClass).isFloat()) {
                throw new ContextualError("Failed to convert the left Operand to Float", this.getLocation());
            }
            this.setLeftOperand(newLeftOperand);
        }

        if (leftOperandType.isFloat() && rightOperandType.isInt()) {
            AbstractExpr newRightOperand = new ConvFloat(this.getRightOperand());
            if (!newRightOperand.verifyExpr(compiler, localEnv, currentClass).isFloat()) {
                throw new ContextualError("Failed to convert the right Operand to Float", this.getLocation());
            }
            this.setRightOperand(newRightOperand);
        }

        this.setType(new BooleanType(compiler.getSymbols().create("boolean")));

        return this.getType();
    }

    protected Instruction mnemoUnary(GPRegister register) {
        throw new UnsupportedOperationException("This method shouldn't be called here");
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        AbstractExpr leftExpr = this.getLeftOperand();
        AbstractExpr rightExpr = this.getRightOperand();
        leftExpr.codeGenInst(compiler, n);
        if (n == compiler.getCodeGen().getRmax()) {
            compiler.addInstruction(new PUSH(Register.getR(n)));
            rightExpr.codeGenInst(compiler, n);
            compiler.addInstruction(new LOAD(Register.getR(n), Register.R0));
            compiler.addInstruction(new POP(Register.getR(n)));
            compiler.addInstruction(new CMP(Register.R0, Register.getR(n)));
            compiler.addInstruction(this.mnemoUnary(Register.getR(n)));

        } else {
            compiler.getStackMan().incrementPile(1);
            rightExpr.codeGenInst(compiler, n + 1);
            compiler.addInstruction(new CMP(Register.getR(n + 1), Register.getR(n)));
            compiler.addInstruction(this.mnemoUnary(Register.getR(n)));
            compiler.getStackMan().decrementPile(1);
        }

        if (this.getOperatorName().equals("/") || this.getOperatorName().equals("%")) {
            AssError.addErrorDivZero(compiler);
        }
    }

    @Override
    protected void codeGenJump(DecacCompiler compiler, boolean jumpOnEval, Label label, int nReg) {
        AbstractExpr leftOp = this.getLeftOperand();
        AbstractExpr rightOp = this.getRightOperand();
        leftOp.codeGenInst(compiler, nReg);
        if (nReg == compiler.getCodeGen().getRmax()) {
            compiler.addInstruction(new PUSH(Register.getR(nReg)));
            compiler.getStackMan().incrementPile(1);
            rightOp.codeGenInst(compiler, nReg);
            compiler.addInstruction(new LOAD(Register.getR(nReg), Register.R0));
            compiler.addInstruction(new POP(Register.getR(nReg)));
            compiler.getStackMan().decrementPile(1);
            compiler.addInstruction(new CMP(Register.R0, Register.getR(nReg)));
        } else {
            compiler.getStackMan().incrementPile(1);
            rightOp.codeGenInst(compiler, nReg + 1);
            compiler.getStackMan().decrementPile(1);
            compiler.addInstruction(new CMP(Register.getR(nReg + 1), Register.getR(nReg)));
        }

        if (jumpOnEval) {
            this.addInstructionJump(compiler, label);
        } else {
            this.addInstructionNotJump(compiler, label);
        }
    }

    protected abstract void addInstructionJump(DecacCompiler compiler, Label label);

    protected abstract void addInstructionNotJump(DecacCompiler compiler, Label label);

}
