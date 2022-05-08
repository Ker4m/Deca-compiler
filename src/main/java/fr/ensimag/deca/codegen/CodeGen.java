package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.tree.AbstractDeclClass;
import fr.ensimag.deca.tree.DeclClass;
import fr.ensimag.deca.tree.DeclMethod;
import fr.ensimag.deca.tree.ListDeclClass;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;


public class CodeGen {

    private final DecacCompiler compiler;
    private int indexGB;
    private int indexLB;
    private int rmax;
    private DeclClass currentClass;
    private DeclMethod currentMethod;


    private int fiLabelCounter;
    private int elseLabelCounter;
    private int startWhileLabelCounter;
    private int endWhileLabelCounter;
    private int endAndLabelCounter;
    private int endOrLabelCounter;
    private int tabLabelCounter;
    private int castLabelCounter;
    private int endInstanceOfLabelCounter;

    public CodeGen(DecacCompiler compiler) {
        this.indexGB = 3; // les 2 premiers sont pour la classe Object et la methode equals()
        this.indexLB = -3;
        this.rmax = 15;
        this.compiler = compiler;

        this.fiLabelCounter = -1;
        this.elseLabelCounter = -1;
        this.startWhileLabelCounter = -1;
        this.endWhileLabelCounter = -1;
        this.endAndLabelCounter = -1;
        this.endOrLabelCounter = -1;
        this.castLabelCounter = -1;
        this.endInstanceOfLabelCounter = -1;
        this.tabLabelCounter = 0;
    }

    public int getIndexGB() {
        return this.indexGB;
    }

    public void incrIndexGB() {
        indexGB++;
    }

    public int getIndexLB() {
        return this.indexLB;
    }

    public void setIndexLB(int i) {
        this.indexLB = i;
    }

    public void decrIndexLB() {
        indexLB--;
    }

    public void incrIndexLB() {
        indexLB++;
    }

    public int getRmax() {
        return this.rmax;
    }

    public void setRmax(int X) {
        this.rmax = X - 1;
    }

    public int getFreeFiLabel() {
        this.fiLabelCounter++;
        return this.fiLabelCounter;
    }

    public int getFreeElseLabel() {
        this.elseLabelCounter++;
        return this.elseLabelCounter;
    }

    public int getStartWhileLabel() {
        this.startWhileLabelCounter++;
        return this.startWhileLabelCounter;
    }

    public int getEndWhileLabel() {
        this.endWhileLabelCounter++;
        return this.endWhileLabelCounter;
    }

    public int getEndAndLabel() {
        this.endAndLabelCounter++;
        return this.endAndLabelCounter;
    }

    public int getEndOrLabel() {
        this.endOrLabelCounter++;
        return this.endOrLabelCounter;
    }

    public void incrTabLabelCounter() {
        this.tabLabelCounter++;
    }

    public int getTabLabelCounter() {
        return this.tabLabelCounter;
    }

    public int getCastLabel() {
        this.castLabelCounter++;
        return this.castLabelCounter;
    }

    public int getEndInstanceOfLabel() {
        this.endInstanceOfLabelCounter++;
        return this.endInstanceOfLabelCounter;
    }

    public void initTableMethods(DecacCompiler compiler, ListDeclClass classes) {
        compiler.addComment("");
        compiler.addComment("====================================================");
        compiler.addComment("                      VTABLES                      |");
        compiler.addComment("====================================================");

        ObjectClass.codeGenInitObjectVtable(compiler);

        for (AbstractDeclClass abstractClass : classes.getList()) {
            abstractClass.codeGenMethodTable(compiler);
        }
    }

    public void pushRegs(int n) {
        for (int i = 2; i <= n && i <= rmax; i++) {
            compiler.addInstruction(new PUSH(Register.getR(i)));
        }
    }

    public void pushRegsAtIndex(int n, int index) {
        n = Integer.min(n, rmax);
        for (int i = n; i >= 2; i--) {
            compiler.addInstructionAtIndex(new PUSH(Register.getR(i)), index);
        }
    }

    public void popRegs(int n) {
        n = Integer.min(n, rmax);
        for (int i = n; i >= 2; i--) {
            compiler.addInstruction(new POP(Register.getR(i)));
        }
    }

    public DeclClass getCurClass() {
        return this.currentClass;
    }

    public void setCurClass(DeclClass classe) {
        this.currentClass = classe;
    }

    public DeclMethod getCurMethod() {
        return this.currentMethod;
    }

    public void setCurMethod(DeclMethod method) {
        this.currentMethod = method;
    }

}
