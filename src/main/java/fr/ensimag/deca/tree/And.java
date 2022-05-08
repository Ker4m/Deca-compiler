package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.MUL;

/**
 * @author gl09
 * @date 01/01/2022
 */
public class And extends AbstractOpBool {

    public And(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected String getOperatorName() {
        return "&&";
    }

    @Override
    protected Instruction mnemo(DVal leftOperand, GPRegister rightOperand) {
        return new MUL(leftOperand, rightOperand);
    }

    @Override
    protected void codeGenJump(DecacCompiler compiler, boolean jumpOnEval, Label label, int nReg) {
        Label endAnd = new Label("endAnd_" + compiler.getCodeGen().getEndAndLabel());
        if (jumpOnEval) {
            this.getLeftOperand().codeGenJump(compiler, false, endAnd, nReg);
            this.getRightOperand().codeGenJump(compiler, true, label, nReg);
        } else {
            this.getLeftOperand().codeGenJump(compiler, false, label, nReg);
            this.getRightOperand().codeGenJump(compiler, false, label, nReg);
        }
        compiler.addLabel(endAnd);
    }

}
