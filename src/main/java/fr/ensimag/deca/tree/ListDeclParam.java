package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;

public class ListDeclParam extends TreeList<AbstractDeclParam> {

    @Override
    public void decompile(IndentPrintStream s) {
        int i = 0;
        for (AbstractDeclParam c : getList()) {
            c.decompile(s);
            if (i < this.size() - 1) {
                s.print(", ");
            }
            i++;
        }
    }

    public void verifyListParamMembers(DecacCompiler compiler) throws ContextualError {
        for (AbstractDeclParam c : getList()) {
            c.verifyParamMembers(compiler);
        }
    }

    public void verifyListParamBody(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass) throws ContextualError {
        for (AbstractDeclParam c : getList()) {
            c.verifyParamBody(compiler, localEnv);
        }
    }

    public void codeGenListParam(DecacCompiler compiler) {
        for (AbstractDeclParam p : getList()) {
            p.codeGenParam(compiler.getCodeGen().getIndexLB());
            compiler.getCodeGen().decrIndexLB();
        }
    }

}
