package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

public abstract class AbstractDeclField extends Tree {

    public abstract void codeGenDeclField(DecacCompiler compiler);

    public abstract void verifyFieldMembers(DecacCompiler compiler,
                                            ClassDefinition currentClass, int i) throws ContextualError;

    public abstract void verifyFieldBody(DecacCompiler compiler, EnvironmentExp localEnv,
                                         ClassDefinition currentClass) throws ContextualError;

    public abstract AbstractIdentifier getIdField();
}
