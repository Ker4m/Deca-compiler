package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.*;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.*;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class MatrixCall extends AbstractLValue {

    private final AbstractIdentifier matrix;
    private final ListExpr args;

    public MatrixCall(AbstractIdentifier matrix, ListExpr args) {
        Validate.notNull(matrix);
        Validate.notNull(args);
        this.args = args;
        this.matrix = matrix;
    }

    public ListExpr getArgs() {
        return this.args;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass) throws ContextualError {
        Type matrixType = this.matrix.verifyExpr(compiler, localEnv, currentClass);

        if (!matrixType.isIntMatrix() && !matrixType.isFloatMatrix()) {
            throw new ContextualError("Wrong type, expecting int or float matrix, given: " + matrixType, getLocation());
        }

        if (matrixType.isIntMatrix()) {
            this.setType(compiler.getEnvType().getType(compiler.getSymbols().create("int")).getType());
        } else {
            this.setType(compiler.getEnvType().getType(compiler.getSymbols().create("float")).getType());

        }

        if (this.args.size() > 2) {
            throw new ContextualError("Too much arguments to access a matrix, expected 1 or 2, given: " +
                    this.args.size(), getLocation());
        }

        for (AbstractExpr expr : this.args.getList()) {
            Type exprType = expr.verifyExpr(compiler, localEnv, currentClass);
            if (!exprType.isInt()) {
                throw new ContextualError("Trying to access a matrix with index of type " + exprType.getName() +
                        ", int required", getLocation());
            }
        }

        ExpDefinition expDef = localEnv.get(compiler.getSymbols().create(this.matrix.getName().getName()));

        if (expDef.isMatrix() && !expDef.isParam()) {

            MatrixDefinition matrixDef = expDef.asMatrixDefinition("Cannot access matrix definition", getLocation());
            ListExpr size = matrixDef.getSize();
            if (size.size() != this.args.size()) {
                if (size.size() == 1) {
                    throw new ContextualError("Cannot access one dimensional array with two args", getLocation());
                } else {
                    throw new ContextualError("Cannot access two dimensional matrix with one arg", getLocation());
                }
            }
        }

        return this.getType();
    }

    @Override
    public void decompile(IndentPrintStream s) {
        this.matrix.decompile(s);
        s.print("[");
        this.args.decompile(s);
        s.print("]");
    }

    @Override
    protected String prettyPrintNode() {
        return "MatrixCall (" + this.matrix.getName() + ")";
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.args.prettyPrintChildren(s, prefix);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.matrix.iter(f);
        this.args.iter(f);
    }

    @Override
    public Definition getDefinition() {
        return this.matrix.getDefinition();
    }

    @Override
    public ExpDefinition getExpDefinition() {
        return this.matrix.getExpDefinition();
    }

    @Override
    public FieldDefinition getFieldDefinition() {
        return this.matrix.getFieldDefinition();
    }

    @Override
    public MatrixDefinition getMatrixDefinition() {
        return this.matrix.getMatrixDefinition();
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        if (matrix.getExpDefinition().isField()) {
            compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.getR(n)));
            compiler.addInstruction(new LOAD(new RegisterOffset(matrix.getMatrixDefinition().getIndex() + 1, Register.getR(n)), Register.getR(n)));
        } else {
            compiler.addInstruction(new LOAD(matrix.getExpDefinition().getOperand(), Register.getR(n)));
        }

        compiler.addInstruction(new LOAD(new RegisterOffset(1, Register.getR(n)), Register.getR(n)));

        args.getList().get(0).codeGenInst(compiler, 0);
        if (args.getList().size() == 2) {
            compiler.addInstruction(new MUL(Register.getR(n), Register.getR(0)));
            args.getList().get(1).codeGenInst(compiler, 1);
            compiler.addInstruction(new ADD(Register.getR(1), Register.getR(0)));
        }

        if (matrix.getExpDefinition().isField()) {
            compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.getR(n)));
            compiler.addInstruction(new LOAD(new RegisterOffset(matrix.getMatrixDefinition().getIndex() + 1, Register.getR(n)), Register.getR(n)));
        } else {
            compiler.addInstruction(new LOAD(matrix.getExpDefinition().getOperand(), Register.getR(n)));
        }
        compiler.addInstruction(new LEA(new RegisterOffset(1, Register.getR(n)), Register.getR(n)));
        compiler.addInstruction(new LEA(new RegisterOffset(1, Register.getR(n)), Register.getR(n)));


        compiler.addLabel(new Label("debut.callTab" + compiler.getCodeGen().getTabLabelCounter()));
        compiler.addInstruction(new CMP(0, Register.getR(0)));
        compiler.addInstruction(new BLE(new Label("fin.callTab" + compiler.getCodeGen().getTabLabelCounter())));
        compiler.addInstruction(new LEA(new RegisterOffset(1, Register.getR(n)), Register.getR(n)));
        compiler.addInstruction(new SUB(new ImmediateInteger(1), Register.getR(0)));
        compiler.addInstruction(new BRA(new Label("debut.callTab" + compiler.getCodeGen().getTabLabelCounter())));
        compiler.addLabel(new Label("fin.callTab" + compiler.getCodeGen().getTabLabelCounter()));
        compiler.getCodeGen().incrTabLabelCounter();

        compiler.addInstruction(new LOAD(Register.getR(n), Register.R1)); // for the assign
        compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(n)), Register.getR(n))); // for the value
    }

    protected void codeGenPrint(DecacCompiler compiler, boolean hex, int nReg) {
        this.codeGenInst(compiler, nReg);
        compiler.addInstruction(new LOAD(Register.getR(nReg), Register.R1));
        if (this.getType().isInt()) {
            compiler.addInstruction(new WINT());
        } else {
            if (hex) {
                compiler.addInstruction(new WFLOATX());
            } else {
                compiler.addInstruction(new WFLOAT());
            }
        }

    }


}
