package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;

import java.util.Iterator;

/**
 * List of declarations (e.g. int x; float y,z).
 *
 * @author gl09
 * @date 01/01/2022
 */
public class ListDeclVar extends TreeList<AbstractDeclVar> {

    @Override
    public void decompile(IndentPrintStream s) {
        Iterator<AbstractDeclVar> it = this.iterator();
        while (it.hasNext()) {
            it.next().decompile(s);
        }
    }

    /**
     * Implements non-terminal "list_decl_var" of [SyntaxeContextuelle] in pass 3
     *
     * @param compiler     contains the "env_types" attribute
     * @param localEnv     its "parentEnvironment" corresponds to "env_exp_sup" attribute
     *                     in precondition, its "current" dictionary corresponds to
     *                     the "env_exp" attribute
     *                     in postcondition, its "current" dictionary corresponds to
     *                     the "env_exp_r" attribute
     * @param currentClass corresponds to "class" attribute (null in the main bloc).
     */
    void verifyListDeclVariable(DecacCompiler compiler, EnvironmentExp localEnv,
                                ClassDefinition currentClass) throws ContextualError {
        Iterator<AbstractDeclVar> it = this.iterator();
        while (it.hasNext()) {
            it.next().verifyDeclVar(compiler, localEnv, currentClass);
        }
    }

    protected void codeGenListDeclVar(DecacCompiler compiler, boolean inMethod) {
        for (AbstractDeclVar abstractVar : this.getList()) {
            if (inMethod) {
                abstractVar.codeGenMethodVar(compiler);
            } else {
                abstractVar.codeGenDeclVar(compiler);
            }
        }
    }


}
