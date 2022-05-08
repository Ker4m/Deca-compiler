package fr.ensimag.deca.context;

import fr.ensimag.deca.tree.Location;

/**
 * Definition of an identifier.
 *
 * @author gl09
 * @date 01/01/2022
 */
public abstract class Definition {
    private final Type type;
    private Location location;

    public Definition(Type type, Location location) {
        super();
        this.location = location;
        this.type = type;
    }

    @Override
    public String toString() {
        String res;
        res = getNature();
        if (location == Location.BUILTIN) {
            res += " (builtin)";
        } else {
            res += " defined at " + location;
        }
        res += ", type=" + type;
        return res;
    }

    public abstract String getNature();

    public Type getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isField() {
        return false;
    }

    public boolean isMethod() {
        return false;
    }

    public boolean isClass() {
        return false;
    }

    public boolean isParam() {
        return false;
    }

    public boolean isMatrix() {
        return false;
    }

    /**
     * Return the same object, as type MethodDefinition, if possible. Throws
     * ContextualError(errorMessage, l) otherwise.
     */
    public MethodDefinition asMethodDefinition(String errorMessage, Location l)
            throws ContextualError {
        throw new ContextualError(errorMessage, l);
    }

    /**
     * Return the same object, as type FieldDefinition, if possible. Throws
     * ContextualError(errorMessage, l) otherwise.
     */
    public FieldDefinition asFieldDefinition(String errorMessage, Location l)
            throws ContextualError {
        throw new ContextualError(errorMessage, l);
    }

    public ClassDefinition asClassDefinition(String errorMessage, Location l) throws ContextualError {
        throw new ContextualError(errorMessage, l);
    }

    public MatrixDefinition asMatrixDefinition(String errorMessage, Location l) throws ContextualError {
        throw new ContextualError(errorMessage, l);
    }

    public abstract boolean isExpression();

}
