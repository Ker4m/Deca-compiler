package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;

public class ListDeclMethod extends TreeList<AbstractDeclMethod> {

    @Override
    public void decompile(IndentPrintStream s) {
        for (AbstractDeclMethod c : getList()) {
            c.decompile(s);
        }
    }

    private AbstractDeclMethod getDeclMethod(DecacCompiler compiler, Symbol key) {
        for (AbstractDeclMethod c : getList()) {
            if (compiler.getSymbols().create(c.getIdMethod().getName().getName()) == compiler.getSymbols().create(key.getName())) {
                return c;
            }
        }
        return null;
    }

    public void verifyListMethodMembers(DecacCompiler compiler, EnvironmentExp localEnv,
                                        ClassDefinition currentClass) throws ContextualError {
        ClassDefinition parentClass = currentClass.getSuperClass();
        if (parentClass.getSuperClass() != null) {
            for (Symbol key : parentClass.getMembers().getDict().keySet()) {
                boolean seen = false;
                for (AbstractDeclMethod c : getList()) {
                    if (compiler.getSymbols().create(key.getName()) == compiler.getSymbols().create(c.getIdMethod().getName().getName())) {
                        seen = true;
                    }
                }
                if (!seen && parentClass.getMembers().getDict().get(key).getNature() == "method") {
                    DeclMethod parentMethod = (DeclMethod) parentClass.getDeclClass().getListDeclMethod().getDeclMethod(compiler, key);
                    if (!(parentMethod == null)) {
                        this.add(parentMethod);
                    }
                }
            }
        }
        for (AbstractDeclMethod c : getList()) {
            c.verifyMethodMembers(compiler, currentClass, currentClass.incNumberOfMethods());
        }
    }


    public void verifyListMethodBody(DecacCompiler compiler, EnvironmentExp localEnv,
                                     ClassDefinition currentClass) throws ContextualError {
        for (AbstractDeclMethod c : getList()) {
            c.verifyMethodBody(compiler, currentClass);
        }
    }

    public void codeGenListDeclMethods(DecacCompiler compiler) {
        for (AbstractDeclMethod abstractMethod : this.getList()) {
            abstractMethod.codeGenDeclMethod(compiler);
        }
    }

}
