package fr.ensimag.deca.context;

import fr.ensimag.deca.tree.ListExpr;
import fr.ensimag.deca.tree.Location;

public class MatrixDefinition extends ExpDefinition {

    private final ListExpr size;
    private final int index;
    private final boolean isField;

    public MatrixDefinition(Type type, Location location, ListExpr size, int i, boolean isField) {
        super(type, location);
        this.size = size;
        this.index = i;
        this.isField = isField;
    }

    public int getIndex() {
        return index;
    }

    public boolean isField() {
        return isField;
    }

    public ListExpr getSize() {
        return this.size;
    }

    @Override
    public String getNature() {
        return "matrix";
    }

    @Override
    public boolean isExpression() {
        return false;
    }

    @Override
    public boolean isMatrix() {
        return true;
    }


    @Override
    public MatrixDefinition asMatrixDefinition(String errorMessage, Location l) {
        return this;
    }
}
