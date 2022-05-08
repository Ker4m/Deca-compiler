package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.*;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class DeclField extends AbstractDeclField {
    private final Visibility visibility;
    private final AbstractIdentifier type;
    private final AbstractIdentifier ident;
    private final AbstractInitialization initialization;

    public DeclField(Visibility v, AbstractIdentifier type, AbstractIdentifier ident, AbstractInitialization initialization) {
        Validate.notNull(v);
        Validate.notNull(type);
        Validate.notNull(ident);
        Validate.notNull(initialization);
        this.visibility = v;
        this.type = type;
        this.ident = ident;
        this.initialization = initialization;

    }

    @Override
    public void decompile(IndentPrintStream s) {
        if (visibility.equals(Visibility.PROTECTED)) {
            s.print("protected ");
        }
        this.type.decompile(s);
        s.print(" ");
        this.ident.decompile(s);
        this.initialization.decompile(s);
        s.println(";");
    }

    @Override
    public void verifyFieldMembers(DecacCompiler compiler,
                                   ClassDefinition currentClass, int i) throws ContextualError {

        Type fieldType = this.type.verifyType(compiler);
        if (fieldType.isVoid()) {
            throw new ContextualError("Type cannot be void", getLocation());
        }
        FieldDefinition fieldDef = new FieldDefinition(fieldType, this.getLocation(), this.visibility, currentClass, i);
        try {
            Symbol s = compiler.getSymbols().create(this.ident.getName().getName());
            currentClass.getMembers().declare(s, fieldDef);
        } catch (DoubleDefException e) {
            throw new ContextualError("Field " + this.ident.getName().getName() + " already exists", this.getLocation());
        }
        this.ident.verifyExpr(compiler, currentClass.getMembers(), currentClass);

    }

    @Override
    public void verifyFieldBody(DecacCompiler compiler, EnvironmentExp localEnv,
                                ClassDefinition currentClass) throws ContextualError {
        Type identType = this.type.verifyType(compiler);
        this.initialization.verifyInitialization(compiler, identType, localEnv, currentClass);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.type.prettyPrint(s, prefix, false);
        this.ident.prettyPrint(s, prefix, false);
        this.initialization.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.type.iter(f);
        this.ident.iter(f);
        this.initialization.iter(f);
    }

    @Override
    public void codeGenDeclField(DecacCompiler compiler) {
        initialization.codeGenInitField(ident.getFieldDefinition().getIndex() + 1, compiler, ident.getType());
    }

    @Override
    public AbstractIdentifier getIdField() {
        return this.ident;
    }

}
