package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.*;

/**
 * @author gl09
 * @date 01/01/2022
 */
public abstract class AbstractOpBool extends AbstractBinaryExpr {

    public AbstractOpBool(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {

        Type leftOperandType = this.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type rightOperandType = this.getRightOperand().verifyExpr(compiler, localEnv, currentClass);

        if (!leftOperandType.isBoolean() || !rightOperandType.isBoolean()) {
            throw new ContextualError("Invalid argument for boolean operation. Args should be boolean : " +
                    leftOperandType.getName().getName() + " and " + rightOperandType.getName().getName() +
                    " given.", getLocation());
        }

        this.setType(new BooleanType(compiler.getSymbols().create("boolean")));

        return this.getType();
    }


}
