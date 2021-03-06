package fr.ensimag.deca.context;

import fr.ensimag.deca.tools.SymbolTable.Symbol;

import java.util.HashMap;

/**
 * Dictionary associating identifier's ExpDefinition to their names.
 * <p>
 * This is actually a linked list of dictionaries: each EnvironmentExp has a
 * pointer to a parentEnvironment, corresponding to superblock (eg superclass).
 * <p>
 * The dictionary at the head of this list thus corresponds to the "current"
 * block (eg class).
 * <p>
 * Searching a definition (through method get) is done in the "current"
 * dictionary and in the parentEnvironment if it fails.
 * <p>
 * Insertion (through method declare) is always done in the "current" dictionary.
 *
 * @author gl09
 * @date 01/01/2022
 */
public class EnvironmentExp {
    EnvironmentExp parentEnvironment;
    HashMap<Symbol, ExpDefinition> symbolDefinitionDict;

    public EnvironmentExp(EnvironmentExp parentEnvironment) {
        this.parentEnvironment = parentEnvironment;
        this.symbolDefinitionDict = new HashMap<>();
    }

    public HashMap<Symbol, ExpDefinition> getDict() {
        return symbolDefinitionDict;
    }

    /**
     * Return the definition of the symbol in the environment, or null if the
     * symbol is undefined.
     */
    public ExpDefinition get(Symbol key) {
        ExpDefinition def = this.symbolDefinitionDict.get(key);
        if (def == null && this.parentEnvironment != null) {
            def = this.parentEnvironment.get(key);
        }
        return def;
    }

    /**
     * Add the definition def associated to the symbol name in the environment.
     * <p>
     * Adding a symbol which is already defined in the environment,
     * - throws DoubleDefException if the symbol is in the "current" dictionary
     * - or, hides the previous declaration otherwise.
     *
     * @param name Name of the symbol to define
     * @param def  Definition of the symbol
     * @throws DoubleDefException if the symbol is already defined at the "current" dictionary
     */
    public void declare(Symbol name, ExpDefinition def) throws DoubleDefException {
        // Checks if the symbol is in the "current" dictionary
        if (this.symbolDefinitionDict.containsKey(name)) {
            throw new DoubleDefException();
        } else {
            this.symbolDefinitionDict.put(name, def);
        }
    }

    public static class DoubleDefException extends Exception {
        private static final long serialVersionUID = -2733379901827316441L;
    }

}
