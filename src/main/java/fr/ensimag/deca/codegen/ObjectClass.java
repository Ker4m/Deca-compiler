package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.tree.Location;
import fr.ensimag.ima.pseudocode.*;
import fr.ensimag.ima.pseudocode.instructions.*;

public class ObjectClass {

    static Label objectEquals = new Label("code.Object.equals");

    public static void codeGenInitObjectVtable(DecacCompiler compiler) {
        try {
            ClassDefinition objectClassDef = compiler.getEnvType().getType(compiler.getSymbols().create("Object")).asClassDefinition("definition can't be cast to ClassDefinition", Location.BUILTIN);
            objectClassDef.setOperand(new RegisterOffset(1, Register.GB));
            objectClassDef.setNumberOfFields(0);
            objectClassDef.setNumberOfMethods(1);
        } catch (ContextualError e) {
            e.printStackTrace();
        }

        compiler.addComment("Construction de la table des methodes de Object");
        compiler.addInstruction(new LOAD(new NullOperand(), Register.R0));
        compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(1, Register.GB)));
        compiler.addInstruction(new LOAD(new LabelOperand(objectEquals), Register.R0));
        compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(2, Register.GB)));

    }


    public static void codeGenEqualsMethod(DecacCompiler compiler) {
        compiler.addComment("");
        compiler.addComment("====================================================");
        compiler.addComment("                 CLASS : OBJECT                    |");
        compiler.addComment("====================================================");
        compiler.addComment("");
        compiler.addComment("~~~~~~~~~~~~~~~~ Method : equals() ~~~~~~~~~~~~~~~~~~");
        compiler.addLabel(objectEquals);

        // Sauvegarde des registres
        compiler.addInstruction(new PUSH(Register.getR(2)));
        compiler.addInstruction(new PUSH(Register.getR(3)));
        // On récupère les objets à comparer
        compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.getR(2))); // this
        compiler.addInstruction(new LOAD(new RegisterOffset(-3, Register.LB), Register.getR(3))); // the param
        // Et on les compare
        compiler.addInstruction(new CMP(Register.getR(2), Register.getR(3)));
        compiler.addInstruction(new SEQ(Register.R0));

        // Restoration des registres
        compiler.addInstruction(new POP(Register.getR(2)));
        compiler.addInstruction(new POP(Register.getR(3)));
        compiler.addInstruction(new RTS());
    }

}
