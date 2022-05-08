package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class For extends AbstractInst {

    private final AbstractIdentifier elementType;
    private final AbstractIdentifier element;
    private final AbstractExpr object;
    private final ListInst body;

    public For(AbstractIdentifier elementType, AbstractIdentifier element, AbstractExpr object, ListInst body) {
        Validate.notNull(elementType);
        Validate.notNull(element);
        Validate.notNull(object);
        this.elementType = elementType;
        this.element = element;
        this.object = object;
        this.body = body;
    }

    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass, Type returnType) throws ContextualError {

    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {

    }

    @Override
    public void decompile(IndentPrintStream s) {

    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {

    }

    @Override
    protected void iterChildren(TreeFunction f) {

    }
}
