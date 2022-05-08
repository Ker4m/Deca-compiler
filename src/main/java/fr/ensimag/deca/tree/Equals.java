package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.BNE;
import fr.ensimag.ima.pseudocode.instructions.SEQ;

/**
 * @author gl09
 * @date 01/01/2022
 */
public class Equals extends AbstractOpExactCmp {

    public Equals(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "==";
    }


    @Override
    protected Instruction mnemoUnary(GPRegister register) {
        return new SEQ(register);
    }

    @Override
    protected void addInstructionJump(DecacCompiler compiler, Label label) {
        compiler.addInstruction(new BEQ(label));
    }

    @Override
    protected void addInstructionNotJump(DecacCompiler compiler, Label label) {
        compiler.addInstruction(new BNE(label));
    }

}
