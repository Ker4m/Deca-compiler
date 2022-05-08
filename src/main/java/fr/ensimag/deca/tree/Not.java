package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.SNE;

/**
 * @author gl09
 * @date 01/01/2022
 */
public class Not extends AbstractUnaryExpr {

    public Not(AbstractExpr operand) {
        super(operand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) throws ContextualError {
        Type operandType = this.getOperand().verifyExpr(compiler, localEnv, currentClass);

        if (!operandType.isBoolean()) {
            throw new ContextualError("Invalid argument for not operation. Arg should be of type [boolean].", getLocation());
        }
        this.setType(operandType);
        return operandType;
    }


    @Override
    protected String getOperatorName() {
        return "!";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        this.getOperand().codeGenInst(compiler, n);
        compiler.addInstruction(new CMP(1, Register.getR(n)));
        compiler.addInstruction(new SNE(Register.getR(n)));
    }

    @Override
    protected void codeGenJump(DecacCompiler compiler, boolean jumpOnEval, Label label, int nReg) {
        getOperand().codeGenJump(compiler, !jumpOnEval, label, nReg);
    }

}
