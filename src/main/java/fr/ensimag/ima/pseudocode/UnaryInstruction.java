package fr.ensimag.ima.pseudocode;

import org.apache.commons.lang.Validate;

import java.io.PrintStream;

/**
 * Instruction with a single operand.
 *
 * @author Ensimag
 * @date 01/01/2022
 */
public abstract class UnaryInstruction extends Instruction {
    private final Operand operand;

    protected UnaryInstruction(Operand operand) {
        Validate.notNull(operand);
        this.operand = operand;
    }

    @Override
    void displayOperands(PrintStream s) {
        s.print(" ");
        s.print(operand);
    }

    public Operand getOperand() {
        return operand;
    }

}
