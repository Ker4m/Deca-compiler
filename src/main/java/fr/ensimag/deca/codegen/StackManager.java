package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;


public class StackManager {
    private final DecacCompiler comp;
    private int taillePile;
    private int tailleMaxPile;


    public StackManager(DecacCompiler compiler) {
        this.comp = compiler;
        this.taillePile = 0;
        this.tailleMaxPile = 0;
    }

    public void incrementPile(int i) {
        taillePile += i;
        if (taillePile > tailleMaxPile) {
            tailleMaxPile = taillePile;
        }
    }

    public void decrementPile(int i) {
        taillePile -= i;
    }

    public void setPile(int i) {
        taillePile = i;
    }

    public int getMaxPile() {
        return tailleMaxPile;
    }

    public void resetPile() {
        taillePile = 0;
        tailleMaxPile = 0;
    }


    public void addMainStackMan() {
        comp.addFirst(new ADDSP(comp.getCodeGen().getIndexGB() - 1));
        AssError.addFirstErrorPilePleine(comp, tailleMaxPile + comp.getCodeGen().getIndexGB() - 1);

    }

    public void addblocStackMan(int index) {
        AssError.addErrorPilePleineAtIndex(comp, tailleMaxPile + comp.getCodeGen().getIndexLB() - 1, index);

    }
}
