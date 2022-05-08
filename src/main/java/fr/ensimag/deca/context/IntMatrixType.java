package fr.ensimag.deca.context;

import fr.ensimag.deca.tools.SymbolTable;

/**
 * @author Ensimag
 */
public class IntMatrixType extends Type {

    public IntMatrixType(SymbolTable.Symbol name) {
        super(name);
    }

    @Override
    public boolean isIntMatrix() {
        return true;
    }

    @Override
    public boolean sameType(Type otherType) {
        return otherType.isIntMatrix();
    }


}