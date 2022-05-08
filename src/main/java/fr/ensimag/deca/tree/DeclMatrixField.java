package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.deca.context.*;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.*;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class DeclMatrixField extends AbstractDeclField {

    private final Visibility visibility;
    private final AbstractIdentifier type;
    private final ListExpr size;
    private final AbstractIdentifier name;
    private final AbstractInitialization initialization;

    public DeclMatrixField(AbstractIdentifier type, ListExpr size, AbstractIdentifier name, AbstractInitialization init, Visibility visibility) {
        Validate.notNull(type);
        Validate.notNull(size);
        Validate.notNull(name);
        Validate.notNull(init);
        Validate.notNull(visibility);
        this.type = type;
        this.size = size;
        this.name = name;
        this.initialization = init;
        this.visibility = visibility;
    }

    @Override
    public void codeGenDeclField(DecacCompiler compiler) {

        size.getList().get(0).codeGenInst(compiler, 2);
        if (size.getList().size() == 2) {
            size.getList().get(1).codeGenInst(compiler, 3);
            compiler.addInstruction(new LOAD(Register.getR(3), Register.getR(5)));
            compiler.addInstruction(new MUL(Register.getR(2), Register.getR(5)));
            compiler.addInstruction(new ADD(new ImmediateInteger(2), Register.getR(5)));
            compiler.addInstruction(new NEW(Register.getR(5), Register.getR(4)));
            AssError.addErrorTasPlein(compiler);
            compiler.addInstruction(new STORE(Register.getR(4), new RegisterOffset(name.getMatrixDefinition().getIndex() + 1, Register.R1)));
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
            compiler.addInstruction(new STORE(Register.getR(4), new RegisterOffset(name.getMatrixDefinition().getIndex() + 1, Register.R1)));
            compiler.addInstruction(new STORE(Register.getR(2), new RegisterOffset(0, Register.getR(4))));
            compiler.addInstruction(new LEA(new RegisterOffset(1, Register.getR(4)), Register.getR(4)));
            compiler.addInstruction(new STORE(Register.getR(3), new RegisterOffset(0, Register.getR(4))));
            compiler.addInstruction(new SUB(new ImmediateInteger(2), Register.getR(5)));
        }


        this.initialization.codeGenInitTab(compiler, type.getType());


    }

    @Override
    public void verifyFieldMembers(DecacCompiler compiler, ClassDefinition currentClass, int i) throws ContextualError {
        Type matrixType = this.type.verifyType(compiler);

        EnvironmentExp localEnv = currentClass.getMembers();

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

        MatrixDefinition matrixDef = new MatrixDefinition(matrixType, this.name.getLocation(), this.size, i, true);
        this.name.setDefinition(matrixDef);

        try {
            localEnv.declare(compiler.getSymbols().create(this.name.getName().getName()), matrixDef);
        } catch (EnvironmentExp.DoubleDefException e) {
            throw new ContextualError("DeclMatrix " + this.type.getName().getName() + " already exists", this.getLocation());
        }

        this.name.verifyExpr(compiler, localEnv, currentClass);
    }

    @Override
    public void verifyFieldBody(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass) throws ContextualError {
        Type identType = this.type.verifyType(compiler);
        this.initialization.verifyInitialization(compiler, identType, localEnv, currentClass);
    }

    @Override
    public AbstractIdentifier getIdField() {
        return this.name;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        if (visibility.equals(Visibility.PROTECTED)) {
            s.print("protected ");
        }
        this.type.decompile(s);
        s.print("[");
        this.size.decompile(s);
        s.print("]");
        this.name.decompile(s);
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
}
