package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.deca.context.*;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.FLOAT;

/**
 * Conversion of an int into a float. Used for implicit conversions.
 *
 * @author gl09
 * @date 01/01/2022
 */
public class ConvFloat extends AbstractUnaryExpr {
    public ConvFloat(AbstractExpr operand) {
        super(operand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {

        Type operandType = this.getOperand().getType();
        if (operandType == null) {
            operandType = this.getOperand().verifyExpr(compiler, localEnv, currentClass);
        }

        if (!operandType.isInt()) {
            throw new ContextualError("Invalid argument for conversion of an int into a float. Arg should " +
                    "be an int: " + operandType.getName().getName() + " given.", getLocation());
        }

        FloatType floatType = new FloatType(compiler.getSymbols().create("float"));

        this.getOperand().setType(floatType);

        this.setType(floatType);

        return this.getType();
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        this.getOperand().codeGenInst(compiler, n);
        compiler.addInstruction(new FLOAT(Register.getR(n), Register.getR(n)));
        AssError.addErrorDebordementArith(compiler);
    }

    @Override
    protected String getOperatorName() {
        return "/* conv float */";
    }

}
