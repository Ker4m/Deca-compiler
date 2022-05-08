package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.*;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.WFLOAT;
import fr.ensimag.ima.pseudocode.instructions.WFLOATX;
import fr.ensimag.ima.pseudocode.instructions.WINT;

/**
 * Arithmetic binary operations (+, -, /, ...)
 *
 * @author gl09
 * @date 01/01/2022
 */
public abstract class AbstractOpArith extends AbstractBinaryExpr {

    public AbstractOpArith(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {

        Type leftOperandType = this.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type rightOperandType = this.getRightOperand().verifyExpr(compiler, localEnv, currentClass);

        if ((!leftOperandType.isFloat() && !leftOperandType.isInt()) || (!rightOperandType.isFloat() && !rightOperandType.isInt())) {
            throw new ContextualError("Invalid argument for arithmetic operation. Args should be of type " +
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

        // If float is the type of one of the operand, then the result is a float else it is an int
        if (leftOperandType.isFloat() || rightOperandType.isFloat()) {
            this.setType(new FloatType(compiler.getSymbols().create("float")));
        } else {
            this.setType(new IntType(compiler.getSymbols().create("int")));
        }

        return this.getType();
    }

    @Override
    protected void codeGenPrint(DecacCompiler compiler, boolean hex, int nReg) {
        this.codeGenInst(compiler, nReg);
        compiler.addInstruction(new LOAD(Register.getR(nReg), Register.R1));
        if (this.getType().isInt()) {
            compiler.addInstruction(new WINT());
        } else {
            if (hex) {
                compiler.addInstruction(new WFLOATX());
            } else {
                compiler.addInstruction(new WFLOAT());
            }
        }
    }

}
