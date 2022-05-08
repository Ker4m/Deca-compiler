package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.OPP;

/**
 * @author gl09
 * @date 01/01/2022
 */
public class UnaryMinus extends AbstractUnaryExpr {

    public UnaryMinus(AbstractExpr operand) {
        super(operand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {
        Type operandType = this.getOperand().verifyExpr(compiler, localEnv, currentClass);

        if (!operandType.isFloat() && !operandType.isInt()) {
            throw new ContextualError("Invalid argument for unary minus operation. Arg should be type of " +
                    "[int, float] : " + operandType.getName().getName() + " given.", getLocation());
        }

        this.setType(operandType);

        return this.getType();
    }


    @Override
    protected String getOperatorName() {
        return "-";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        this.getOperand().codeGenInst(compiler, n); // execute l'expression en argument
        compiler.addInstruction(new OPP(Register.getR(n), Register.getR(n))); // prend l'opposé
    }

}
