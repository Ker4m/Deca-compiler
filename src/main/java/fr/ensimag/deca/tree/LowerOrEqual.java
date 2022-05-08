package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.BGT;
import fr.ensimag.ima.pseudocode.instructions.BLE;
import fr.ensimag.ima.pseudocode.instructions.SLE;


/**
 * @author gl09
 * @date 01/01/2022
 */
public class LowerOrEqual extends AbstractOpIneq {
    public LowerOrEqual(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "<=";
    }


    @Override
    protected Instruction mnemoUnary(GPRegister register) {
        return new SLE(register);
    }

    @Override
    protected void addInstructionJump(DecacCompiler compiler, Label label) {
        compiler.addInstruction(new BLE(label));
    }

    @Override
    protected void addInstructionNotJump(DecacCompiler compiler, Label label) {
        compiler.addInstruction(new BGT(label));
    }

}
