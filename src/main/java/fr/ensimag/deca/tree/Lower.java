package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.BGE;
import fr.ensimag.ima.pseudocode.instructions.BLT;
import fr.ensimag.ima.pseudocode.instructions.SLT;

/**
 * @author gl09
 * @date 01/01/2022
 */
public class Lower extends AbstractOpIneq {

    public Lower(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "<";
    }


    @Override
    protected Instruction mnemoUnary(GPRegister register) {
        return new SLT(register);
    }

    @Override
    protected void addInstructionJump(DecacCompiler compiler, Label label) {
        compiler.addInstruction(new BLT(label));
    }

    @Override
    protected void addInstructionNotJump(DecacCompiler compiler, Label label) {
        compiler.addInstruction(new BGE(label));
    }

}
