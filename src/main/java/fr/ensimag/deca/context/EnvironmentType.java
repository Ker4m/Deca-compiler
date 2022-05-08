package fr.ensimag.deca.context;

import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.tools.SymbolTable;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.deca.tree.Location;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentType {
    private final Map<Symbol, TypeDefinition> envTypes;

    public EnvironmentType(SymbolTable symbolTable) {
        this.envTypes = new HashMap<Symbol, TypeDefinition>();

        NullType nullType = new NullType(symbolTable.create("null"));
        VoidType voidType = new VoidType(symbolTable.create("void"));
        BooleanType booleanType = new BooleanType(symbolTable.create("boolean"));
        IntType intType = new IntType(symbolTable.create("int"));
        FloatType floatType = new FloatType(symbolTable.create("float"));
        StringType stringType = new StringType(symbolTable.create("String"));
        FloatMatrixType floatMatrixType = new FloatMatrixType(symbolTable.create("float[]"));
        IntMatrixType intMatrixType = new IntMatrixType(symbolTable.create("int[]"));
        ClassType classType = new ClassType(symbolTable.create("Object"));

        ClassDefinition objectclass = new ClassDefinition(classType, Location.BUILTIN, null);

        setType(symbolTable.create("null"), new TypeDefinition(nullType, Location.BUILTIN));
        setType(symbolTable.create("void"), new TypeDefinition(voidType, Location.BUILTIN));
        setType(symbolTable.create("boolean"), new TypeDefinition(booleanType, Location.BUILTIN));
        setType(symbolTable.create("int"), new TypeDefinition(intType, Location.BUILTIN));
        setType(symbolTable.create("float"), new TypeDefinition(floatType, Location.BUILTIN));
        setType(symbolTable.create("String"), new TypeDefinition(stringType, Location.BUILTIN));
        setType(symbolTable.create("float[]"), new TypeDefinition(floatMatrixType, Location.BUILTIN));
        setType(symbolTable.create("int[]"), new TypeDefinition(intMatrixType, Location.BUILTIN));
        setType(symbolTable.create("Object"), objectclass);

        Signature equalsSignature = new Signature();
        equalsSignature.add(classType);

        MethodDefinition methodDef = new MethodDefinition(booleanType, Location.BUILTIN, equalsSignature, 0);

        try {
            objectclass.getMembers().declare(symbolTable.create("equals"), methodDef);
        } catch (DoubleDefException e) {
            // This should not happen
        }
    }

    public void setType(Symbol symbol, TypeDefinition typeDef) {
        if (!this.envTypes.containsKey(symbol)) {
            this.envTypes.put(symbol, typeDef);
        }
    }

    public TypeDefinition getType(Symbol symbol) {
        return this.envTypes.get(symbol);
    }

}
