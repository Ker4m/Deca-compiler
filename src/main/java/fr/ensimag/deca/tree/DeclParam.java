package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.context.ParamDefinition;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class DeclParam extends AbstractDeclParam {
    private final AbstractIdentifier type;
    private final AbstractIdentifier ident;

    public DeclParam(AbstractIdentifier type, AbstractIdentifier ident) {
        Validate.notNull(type);
        Validate.notNull(ident);
        this.type = type;
        this.ident = ident;
    }

    public Type getType() {
        return this.type.getType();
    }

    @Override
    public void decompile(IndentPrintStream s) {
        this.type.decompile(s);
        s.print(" ");
        this.ident.decompile(s);
    }

    @Override
    public void verifyParamMembers(DecacCompiler compiler) throws ContextualError {
        Type t = this.type.verifyType(compiler);
        if (t.isNull() || t.isVoid()) {
            throw new ContextualError("Parameter type can't be null or void", this.getLocation());
        }
        ParamDefinition tDef = new ParamDefinition(t, this.getLocation());
        this.ident.setType(t);
        this.ident.setDefinition(tDef);
    }

    @Override
    public void verifyParamBody(DecacCompiler compiler, EnvironmentExp localEnv) throws ContextualError {
        Symbol s = compiler.getSymbols().create(this.ident.getName().getName());
        try {
            localEnv.declare(s, this.ident.getParamDefinition());
        } catch (DoubleDefException e) {
            throw new ContextualError(this.ident.getName().getName() + " is already defined", this.getLocation());
        }
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.type.prettyPrint(s, prefix, false);
        this.ident.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.type.iter(f);
        this.ident.iter(f);
    }

    @Override
    public void codeGenParam(int index) {
        this.ident.getExpDefinition().setOperand(new RegisterOffset(index, Register.LB));
    }

}
