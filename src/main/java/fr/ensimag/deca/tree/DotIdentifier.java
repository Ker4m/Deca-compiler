package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.deca.context.*;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.*;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;
import java.util.Objects;

public class DotIdentifier extends AbstractLValue {
    private final AbstractExpr object;
    private final AbstractIdentifier ident;
    private ExpDefinition matDef;

    public DotIdentifier(AbstractExpr object, AbstractIdentifier ident) {
        Validate.notNull(object);
        Validate.notNull(ident);
        this.object = object;
        this.ident = ident;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {

        Type objectType = this.object.verifyExpr(compiler, localEnv, currentClass);

        String identName = this.ident.getName().getName();

        if (objectType.isIntMatrix() || objectType.isFloatMatrix()) {
            ExpDefinition expDef = localEnv.get(compiler.getSymbols().create(this.object.decompile()));

            this.ident.verifyExpr(compiler, localEnv, currentClass);
            this.matDef = expDef;

            if (expDef.isMatrix() && !expDef.isParam()) {

                MatrixDefinition matrixDef = expDef.asMatrixDefinition("Cannot access matrix definition", getLocation());


                int size = matrixDef.getSize().size();


                if (size == 1) {
                    if (!Objects.equals(identName, "width")) {
                        throw new ContextualError("Only width can be accessed on an one dimensional array, "
                                + identName + " given", this.getLocation());
                    }
                }
            }
            if (!Objects.equals(identName, "length") && !Objects.equals(identName, "width")) {
                throw new ContextualError("Only width and length can be accessed on a two dimensional" +
                        " matrix, " + identName, this.getLocation());
            }

            this.setType(new IntType(compiler.getSymbols().create("int")));

        } else {

            if (!objectType.isClass()) {
                throw new ContextualError("Cannot apply dot to something that is not a class : " +
                        objectType + " given.", getLocation());
            }

            ident.verifyExpr(compiler, ((ClassType) objectType).getDefinition().getMembers(), currentClass);
            ExpDefinition expD = objectType.asClassType("Type can't be converted to ClassType", this.getLocation()).getDefinition().getMembers().get(compiler.getSymbols().create(this.ident.getName().getName()));
            if (expD == null || !expD.isField()) {
                throw new ContextualError(
                        "Field " + this.ident.getName().getName() + " doesn't exist in class " + this.object.getType().getName().getName(),
                        this.getLocation());
            }

            FieldDefinition fieldD = expD.asFieldDefinition("Definition can't be converted to FieldDefinition", this.getLocation());
            if (
                    fieldD.getVisibility().equals(Visibility.PROTECTED) &&
                            (currentClass == null ||
                                    !(
                                            ((ClassType) objectType).isSubClassOf(currentClass.getType()) ||
                                                    currentClass.getType().isSubClassOf(((ClassType) objectType))
                                    ))
            ) {
                throw new ContextualError("Field " + this.ident.getName().getName() + " is PROTECTED", this.getLocation());
            }
            this.setType(fieldD.getType());
        }

        return this.getType();
    }

    @Override
    public void decompile(IndentPrintStream s) {
        this.object.decompile(s);
        s.print(".");
        this.ident.decompile(s);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.object.prettyPrint(s, prefix, false);
        this.ident.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.object.iter(f);
        this.ident.iter(f);
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {

        String identName = this.ident.getName().getName();

        if (Objects.equals(identName, "length")) {
            compiler.addInstruction(new LOAD(matDef.getOperand(), Register.getR(n)));
            compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(n)), Register.getR(n)));
            compiler.addInstruction(new LOAD(Register.getR(n), Register.R0));
        } else if (Objects.equals(identName, "width")) {
            compiler.addInstruction(new LOAD(matDef.getOperand(), Register.getR(n)));
            compiler.addInstruction(new LOAD(new RegisterOffset(1, Register.getR(n)), Register.getR(n)));
            compiler.addInstruction(new LOAD(Register.getR(n), Register.R0));
        } else {
            if (this.object != null) {
                object.codeGenInst(compiler, n);
            } else {
                compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.getR(n)));
            }
            if (!compiler.getCompilerOptions().getNoCheck()) {
                compiler.addInstruction(new CMP(new NullOperand(), Register.getR(n)));
            }
            AssError.addErrorNullDeref(compiler);

            compiler.addInstruction(new LOAD(new RegisterOffset(ident.getFieldDefinition().getIndex() + 1, Register.getR(n)), Register.getR(n)));
            compiler.addInstruction(new LOAD(Register.getR(n), Register.R0));
        }
    }

    @Override
    protected void codeGenPrint(DecacCompiler compiler, boolean hex, int nReg) {
        this.codeGenInst(compiler, nReg);
        compiler.addInstruction(new LOAD(Register.R0, Register.R1));
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

    @Override
    public Definition getDefinition() {
        return ident.getDefinition();
    }

    @Override
    public ExpDefinition getExpDefinition() {
        return ident.getExpDefinition();
    }

    @Override
    public FieldDefinition getFieldDefinition() {
        return ident.getFieldDefinition();
    }

    @Override
    public MatrixDefinition getMatrixDefinition() {
        return ident.getMatrixDefinition();
    }

}
