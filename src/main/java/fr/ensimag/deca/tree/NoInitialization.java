package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.*;
import fr.ensimag.ima.pseudocode.instructions.*;

import java.io.PrintStream;

/**
 * Absence of initialization (e.g. "int x;" as opposed to "int x =
 * 42;").
 *
 * @author gl09
 * @date 01/01/2022
 */
public class NoInitialization extends AbstractInitialization {

    @Override
    protected void verifyInitialization(DecacCompiler compiler, Type t,
                                        EnvironmentExp localEnv, ClassDefinition currentClass) {
        // nothing
    }


    /**
     * Node contains no real information, nothing to check.
     */
    @Override
    protected void checkLocation() {
        // nothing
    }

    @Override
    public void decompile(IndentPrintStream s) {
        // nothing
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        // leaf node => nothing to do
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // leaf node => nothing to do
    }

    @Override
    public void codeGenInit(DAddr addr, DecacCompiler comp, Type t) {
        GPRegister reg2 = Register.getR(2);
        // Pas d'initialisation demandée donc on met les valeurs par defauts
        if (t.isFloat()) {
            comp.addInstruction(new LOAD(new ImmediateFloat(0), reg2));
        } else if (t.isFloatMatrix()) {

        } else if (t.isIntMatrix()) {

        } else { // boolean or int
            comp.addInstruction(new LOAD(new ImmediateInteger(0), reg2));
        }

        // Puis on stocke à la bonne adresse
        comp.addInstruction(new STORE(reg2, addr));

    }


    @Override
    public void codeGenInitField(int index, DecacCompiler comp, Type t) {
        if (t.isFloat()) {
            comp.addInstruction(new LOAD(new ImmediateFloat(0), Register.R0));
        } else { // boolean or int
            comp.addInstruction(new LOAD(new ImmediateInteger(0), Register.R0));
        }
        comp.addInstruction(new STORE(Register.R0, new RegisterOffset(index, Register.R1)));
    }


    @Override
    public void codeGenInitTab(DecacCompiler compiler, Type t) {
        compiler.addLabel(new Label("debut.tab" + compiler.getCodeGen().getTabLabelCounter()));
        compiler.addInstruction(new CMP(0, Register.getR(5)));
        compiler.addInstruction(new BLE(new Label("fin.tab" + compiler.getCodeGen().getTabLabelCounter())));
        compiler.addInstruction(new LEA(new RegisterOffset(1, Register.getR(4)), Register.getR(4)));
        if (t.isIntMatrix()) {
            compiler.addInstruction(new LOAD(new ImmediateInteger(0), Register.R0));
        } else if (t.isFloatMatrix()) {
            compiler.addInstruction(new LOAD(new ImmediateFloat(0), Register.R0));
        }
        compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(0, Register.getR(4))));
        compiler.addInstruction(new SUB(new ImmediateInteger(1), Register.getR(5)));
        compiler.addInstruction(new BRA(new Label("debut.tab" + compiler.getCodeGen().getTabLabelCounter())));
        compiler.addLabel(new Label("fin.tab" + compiler.getCodeGen().getTabLabelCounter()));
        compiler.getCodeGen().incrTabLabelCounter();

    }

}
