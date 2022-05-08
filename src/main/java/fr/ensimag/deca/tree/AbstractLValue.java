package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.ExpDefinition;
import fr.ensimag.deca.context.FieldDefinition;
import fr.ensimag.deca.context.MatrixDefinition;

/**
 * Left-hand side value of an assignment.
 *
 * @author gl09
 * @date 01/01/2022
 */
public abstract class AbstractLValue extends AbstractExpr {

    public abstract Definition getDefinition();

    public abstract ExpDefinition getExpDefinition();

    public abstract FieldDefinition getFieldDefinition();

    public abstract MatrixDefinition getMatrixDefinition();
}
