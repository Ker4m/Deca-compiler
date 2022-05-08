package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.instructions.REM;

/**
 * @author gl09
 * @date 01/01/2022
 */
public class Modulo extends AbstractOpArith {

    public Modulo(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {
        Type leftOperandType = this.getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type rightOperandType = this.getRightOperand().verifyExpr(compiler, localEnv, currentClass);


        if (!leftOperandType.isInt() || !rightOperandType.isInt()) {
            throw new ContextualError("Invalid argument for modulo operation. Both args should be int. " +
                    leftOperandType.getName().getName() + " and " + rightOperandType.getName().getName() +
                    " given.", getLocation());
        }

        this.setType(leftOperandType);

        return this.getType();
    }


    @Override
    protected String getOperatorName() {
        return "%";
    }

    @Override
    protected Instruction mnemo(DVal leftOperand, GPRegister rightOperand) {
        return new REM(leftOperand, rightOperand);
    }

}
