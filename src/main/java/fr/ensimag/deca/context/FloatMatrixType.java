package fr.ensimag.deca.context;

import fr.ensimag.deca.tools.SymbolTable;

/**
 * @author Ensimag
 */
public class FloatMatrixType extends Type {

    public FloatMatrixType(SymbolTable.Symbol name) {
        super(name);
    }

    @Override
    public boolean isFloatMatrix() {
        return true;
    }

    @Override
    public boolean sameType(Type otherType) {
        return otherType.isFloatMatrix();
    }


}