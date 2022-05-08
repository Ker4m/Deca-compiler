package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;

public abstract class AbstractDeclMethod extends Tree {

    public abstract AbstractIdentifier getIdMethod();

    public abstract void codeGenDeclMethod(DecacCompiler compiler);

    public abstract void verifyMethodMembers(DecacCompiler compiler,
                                             ClassDefinition currentClass, int index) throws ContextualError;

    public abstract void verifyMethodBody(DecacCompiler compiler,
                                          ClassDefinition currentClass) throws ContextualError;

}
