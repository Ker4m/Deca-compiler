package fr.ensimag.ima.pseudocode;

import org.apache.commons.lang.Validate;

/**
 * Label used as operand
 *
 * @author Ensimag
 * @date 01/01/2022
 */
public class LabelOperand extends DVal {
    private final Label label;

    public LabelOperand(Label label) {
        super();
        Validate.notNull(label);
        this.label = label;
    }

    public Label getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label.toString();
    }

}
