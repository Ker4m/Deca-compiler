package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.deca.context.*;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.*;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class DeclMatrix extends AbstractDeclVar {

    private final AbstractIdentifier type;
    private final ListExpr size;
    private final AbstractIdentifier name;
    private final AbstractInitialization initialization;

    public DeclMatrix(AbstractIdentifier type, ListExpr size, AbstractIdentifier name, AbstractInitialization init) {
        Validate.notNull(type);
        Validate.notNull(size);
        Validate.notNull(name);
        Validate.notNull(init);
        this.type = type;
        this.size = size;
        this.name = name;
        this.initialization = init;
    }


    @Override
    public void decompile(IndentPrintStream s) {
        this.type.decompile(s);
        s.print("[");
        this.size.decompile(s);
        s.print("]");
        this.name.decompile(s);
    }

    @Override
    String prettyPrintNode() {
        return "DeclMatrix";
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.type.prettyPrint(s, prefix, false);
        this.size.prettyPrintChildren(s, prefix);
        this.name.prettyPrint(s, prefix, false);
        this.initialization.prettyPrint(s, prefix, true);

    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.size.iterChildren(f);
    }

    @Override
    protected void verifyDeclVar(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass) throws ContextualError {
        Type matrixType = this.type.verifyType(compiler);
        if (!matrixType.isIntMatrix() && !matrixType.isFloatMatrix()) {
            throw new ContextualError("Wrong type, expecting int or float matrix, given: " + matrixType, getLocation());
        }

        if (this.size.size() > 2) {
            throw new ContextualError("Too much arguments to declare a matrix, expected 1 or 2, given: " +
                    this.size.size(), getLocation());
        }

        for (AbstractExpr expr : this.size.getList()) {
            Type exprType = expr.verifyExpr(compiler, localEnv, currentClass);
            if (!exprType.isInt()) {
                throw new ContextualError("Trying to declare a matrix with size of type " + exprType.getName() +
                        ", int required", getLocation());
            }
        }

        MatrixDefinition matrixDef = new MatrixDefinition(matrixType, this.name.getLocation(), this.size, 0, false);
        this.name.setDefinition(matrixDef);

        try {
            localEnv.declare(compiler.getSymbols().create(this.name.getName().getName()), matrixDef);
        } catch (EnvironmentExp.DoubleDefException e) {
            throw new ContextualError("DeclMatrix " + this.type.getName().getName() + " already exists", this.getLocation());
        }

        this.name.verifyExpr(compiler, localEnv, currentClass);

        IntType intType = new IntType(compiler.getSymbols().create("int"));

        FieldDefinition widthDef = new FieldDefinition(intType, this.getLocation(), Visibility.PUBLIC, currentClass, 0);
        try {
            SymbolTable.Symbol widthSymbol = compiler.getSymbols().create("width");
            localEnv.declare(widthSymbol, widthDef);
        } catch (EnvironmentExp.DoubleDefException ignored) {

        }

        if (size.size() == 2) {
            FieldDefinition lengthDef = new FieldDefinition(intType, this.getLocation(), Visibility.PUBLIC, currentClass, 1);
            try {
                SymbolTable.Symbol lengthSymbol = compiler.getSymbols().create("length");
                localEnv.declare(lengthSymbol, lengthDef);
            } catch (EnvironmentExp.DoubleDefException ignored) {

            }
        }

        this.initialization.verifyInitialization(compiler, matrixType, localEnv, currentClass);
    }

    @Override
    protected void codeGenDeclVar(DecacCompiler compiler) {
        DAddr addr = new RegisterOffset(compiler.getCodeGen().getIndexGB(), Register.GB);
        compiler.getCodeGen().incrIndexGB();
        // Set the address of the new var
        name.getExpDefinition().setOperand(addr);

        size.getList().get(0).codeGenInst(compiler, 2);
        if (size.getList().size() == 2) {
            size.getList().get(1).codeGenInst(compiler, 3);
            compiler.addInstruction(new LOAD(Register.getR(3), Register.getR(5)));
            compiler.addInstruction(new MUL(Register.getR(2), Register.getR(5)));
            compiler.addInstruction(new ADD(new ImmediateInteger(2), Register.getR(5)));
            compiler.addInstruction(new NEW(Register.getR(5), Register.getR(4)));
            AssError.addErrorTasPlein(compiler);
            compiler.addInstruction(new STORE(Register.getR(4), addr));
            compiler.addInstruction(new STORE(Register.getR(2), new RegisterOffset(0, Register.getR(4))));
            compiler.addInstruction(new LEA(new RegisterOffset(1, Register.getR(4)), Register.getR(4)));
            compiler.addInstruction(new STORE(Register.getR(3), new RegisterOffset(0, Register.getR(4))));
            compiler.addInstruction(new SUB(new ImmediateInteger(2), Register.getR(5)));
        } else {
            compiler.addInstruction(new LOAD(new ImmediateInteger(1), Register.getR(3)));
            compiler.addInstruction(new LOAD(Register.getR(2), Register.getR(5)));
            compiler.addInstruction(new ADD(new ImmediateInteger(2), Register.getR(5)));
            compiler.addInstruction(new NEW(Register.getR(5), Register.getR(4)));
            AssError.addErrorTasPlein(compiler);
            compiler.addInstruction(new STORE(Register.getR(4), addr));
            compiler.addInstruction(new STORE(Register.getR(2), new RegisterOffset(0, Register.getR(4))));
            compiler.addInstruction(new LEA(new RegisterOffset(1, Register.getR(4)), Register.getR(4)));
            compiler.addInstruction(new STORE(Register.getR(3), new RegisterOffset(0, Register.getR(4))));
            compiler.addInstruction(new SUB(new ImmediateInteger(2), Register.getR(5)));
        }


        this.initialization.codeGenInitTab(compiler, type.getType());

        compiler.getStackMan().incrementPile(3);
        compiler.getStackMan().decrementPile(3);

    }

    @Override
    public void codeGenMethodVar(DecacCompiler compiler) {
        DAddr addr = new RegisterOffset(compiler.getCodeGen().getIndexLB(), Register.LB);
        name.getExpDefinition().setOperand(addr);
        compiler.getCodeGen().incrIndexLB();

        size.getList().get(0).codeGenInst(compiler, 2);
        if (size.getList().size() == 2) {
            size.getList().get(1).codeGenInst(compiler, 3);
            compiler.addInstruction(new LOAD(Register.getR(3), Register.getR(5)));
            compiler.addInstruction(new MUL(Register.getR(2), Register.getR(5)));
            compiler.addInstruction(new ADD(new ImmediateInteger(2), Register.getR(5)));
            compiler.addInstruction(new NEW(Register.getR(5), Register.getR(4)));
            AssError.addErrorTasPlein(compiler);
            compiler.addInstruction(new STORE(Register.getR(4), addr));
            compiler.addInstruction(new STORE(Register.getR(2), new RegisterOffset(0, Register.getR(4))));
            compiler.addInstruction(new LEA(new RegisterOffset(1, Register.getR(4)), Register.getR(4)));
            compiler.addInstruction(new STORE(Register.getR(3), new RegisterOffset(0, Register.getR(4))));
            compiler.addInstruction(new SUB(new ImmediateInteger(2), Register.getR(5)));
        } else {
            compiler.addInstruction(new LOAD(new ImmediateInteger(1), Register.getR(3)));
            compiler.addInstruction(new LOAD(Register.getR(2), Register.getR(5)));
            compiler.addInstruction(new ADD(new ImmediateInteger(2), Register.getR(5)));
            compiler.addInstruction(new NEW(Register.getR(5), Register.getR(4)));
            AssError.addErrorTasPlein(compiler);
            compiler.addInstruction(new STORE(Register.getR(4), addr));
            compiler.addInstruction(new STORE(Register.getR(2), new RegisterOffset(0, Register.getR(4))));
            compiler.addInstruction(new LEA(new RegisterOffset(1, Register.getR(4)), Register.getR(4)));
            compiler.addInstruction(new STORE(Register.getR(3), new RegisterOffset(0, Register.getR(4))));
            compiler.addInstruction(new SUB(new ImmediateInteger(2), Register.getR(5)));
        }


        this.initialization.codeGenInitTab(compiler, type.getType());

        compiler.getStackMan().incrementPile(3);
        compiler.getStackMan().decrementPile(3);
    }
}
