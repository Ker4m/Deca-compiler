package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.ADD;

/**
 * @author gl09
 * @date 01/01/2022
 */
public class Or extends AbstractOpBool {

    public Or(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected String getOperatorName() {
        return "||";
    }

    @Override
    protected Instruction mnemo(DVal leftOperand, GPRegister rightOperand) {
        return new ADD(leftOperand, rightOperand);
    }

    @Override
    protected void codeGenJump(DecacCompiler compiler, boolean jumpOnEval, Label label, int nReg) {
        Label endOr = new Label("endOr_" + compiler.getCodeGen().getEndOrLabel());
        if (jumpOnEval) {
            this.getLeftOperand().codeGenJump(compiler, true, label, nReg);
            this.getRightOperand().codeGenJump(compiler, true, label, nReg);
        } else {
            this.getLeftOperand().codeGenJump(compiler, true, endOr, nReg);
            this.getRightOperand().codeGenJump(compiler, false, label, nReg);
        }
        compiler.addLabel(endOr);
    }

}
