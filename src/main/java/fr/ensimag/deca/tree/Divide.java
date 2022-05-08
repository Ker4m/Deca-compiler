package fr.ensimag.deca.tree;

import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.instructions.DIV;
import fr.ensimag.ima.pseudocode.instructions.QUO;


/**
 * @author gl09
 * @date 01/01/2022
 */
public class Divide extends AbstractOpArith {
    public Divide(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "/";
    }


    @Override
    protected Instruction mnemo(DVal leftOperand, GPRegister rightOperand) {
        if (this.getType().isFloat()) {
            return new DIV(leftOperand, rightOperand);
        } else {
            return new QUO(leftOperand, rightOperand);
        }
    }

}
