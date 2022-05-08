package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

public abstract class AbstractDeclParam extends Tree {

    public abstract void verifyParamMembers(DecacCompiler compiler) throws ContextualError;

    public abstract void verifyParamBody(DecacCompiler compiler, EnvironmentExp localEnv) throws ContextualError;

    public abstract void codeGenParam(int index);
}
