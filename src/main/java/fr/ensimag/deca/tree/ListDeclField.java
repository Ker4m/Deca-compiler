package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.*;

import java.util.HashSet;
import java.util.Set;

public class ListDeclField extends TreeList<AbstractDeclField> {

    @Override
    public void decompile(IndentPrintStream s) {
        for (AbstractDeclField c : getList()) {
            c.decompile(s);
        }
    }

    private AbstractDeclField getDeclField(DecacCompiler compiler, Symbol key) {
        for (AbstractDeclField c : getList()) {
            if (compiler.getSymbols().create(c.getIdField().getName().getName()) == compiler.getSymbols().create(key.getName())) {
                return c;
            }
        }
        return null;
    }

    public void verifyListFieldMembers(DecacCompiler compiler, EnvironmentExp localEnv,
                                       ClassDefinition currentClass) throws ContextualError {
        int nbNewFields = getList().size();
        Set<Integer> usedIndexes = new HashSet<Integer>();
        ClassDefinition parentClass = currentClass.getSuperClass();
        if (parentClass.getSuperClass() != null) {
            for (Symbol key : parentClass.getMembers().getDict().keySet()) {
                boolean seen = false;
                for (AbstractDeclField c : getList()) {
                    if (compiler.getSymbols().create(key.getName()) == compiler.getSymbols().create(c.getIdField().getName().getName())) {
                        seen = true;
                    }
                }
                if (!seen && parentClass.getMembers().getDict().get(key).getNature() == "field") {
                    DeclField parentField = (DeclField) parentClass.getDeclClass().getListDeclField().getDeclField(compiler, key);
                    if (!(parentField == null)) {
                        usedIndexes.add(parentField.getIdField().getFieldDefinition().getIndex());
                        this.add(parentField);
                    }
                }
            }
        }
        int index = 0;
        int currentIndex = 0;
        for (AbstractDeclField c : getList()) {
            if (index < nbNewFields) {
                while (usedIndexes.contains(currentIndex)) {
                    currentIndex++;
                }
                c.verifyFieldMembers(compiler, currentClass, currentIndex);
                currentIndex++;
            }
            index++;
            currentClass.incNumberOfFields();
        }
    }

    public void verifyListFieldBody(DecacCompiler compiler, EnvironmentExp localEnv,
                                    ClassDefinition currentClass) throws ContextualError {
        for (AbstractDeclField c : getList()) {
            c.verifyFieldBody(compiler, localEnv, currentClass);
        }
    }

    public void codeGenListDeclFields(DecacCompiler compiler) {
        AbstractIdentifier abIdSuper = compiler.getCodeGen().getCurClass().getIdSuperClass();
        String nameSuper = abIdSuper.getName().getName();

        if (!nameSuper.equals("Object")) { // On suppose que l'on ne peut pas redéfinir la class Object
            compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.R0));
            compiler.addInstruction(new PUSH(Register.R0));
            compiler.getStackMan().incrementPile(2);
            compiler.addInstruction(new BSR(new Label("init." + nameSuper)));
            compiler.getStackMan().decrementPile(2);
            compiler.addInstruction(new SUBSP(1));
        }
        compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.R1));
        for (AbstractDeclField abstractField : this.getList()) {
            if (abstractField.getIdField().getDefinition().isMatrix()) {
                DeclMatrixField dmf = (DeclMatrixField) abstractField;
                dmf.codeGenDeclField(compiler);
            } else {
                abstractField.codeGenDeclField(compiler);
            }
        }
        compiler.addInstruction(new RTS());
    }

}
