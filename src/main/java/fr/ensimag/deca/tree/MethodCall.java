package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.deca.context.*;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.*;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;
import java.util.Iterator;

public class MethodCall extends AbstractExpr {

    private final AbstractIdentifier method;
    private final ListExpr args;
    private final AbstractExpr object;

    public MethodCall(AbstractIdentifier method, ListExpr args, AbstractExpr object) {
        Validate.notNull(method);
        Validate.notNull(args);
        this.method = method;
        this.args = args;
        this.object = object;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {

        Iterator<AbstractExpr> argsIterator = this.args.iterator();
        Signature argSignature = new Signature();
        while (argsIterator.hasNext()) {
            argSignature.add(argsIterator.next().verifyExpr(compiler, localEnv, currentClass));
        }

        EnvironmentExp newLocalEnv = localEnv; // Patch pour que les méthodes marchent si il n'y a pas d'objet --> surement quelques cas ou ça marche pas

        if (this.object != null) {
            Type objectType = this.object.verifyExpr(compiler, localEnv, currentClass);
            if (!objectType.isClass()) {
                throw new ContextualError("Cannot apply method to something that is not a class : " +
                        objectType + " given.", getLocation());
            }

            newLocalEnv = compiler.getEnvType().getType(
                    compiler.getSymbols().create(
                            this.object.getType().getName().getName())).asClassDefinition(
                    "Definition can't be converted to ClassDefinition",
                    this.getLocation()
            ).getMembers();
        } else if (currentClass == null) {
            throw new ContextualError("Method not declared : " + this.method.getName(), getLocation());
        }

        Type methodType = this.method.verifyExpr(compiler, newLocalEnv, currentClass);

        Signature expectedSignature = this.method.getMethodDefinition().getSignature();

        if (expectedSignature.isNotCompatible(argSignature)) {
            throw new ContextualError("Incompatible arguments to method " + this.method.getName().getName() + ": given " + argSignature +
                    ", expected: " + expectedSignature, this.getLocation());
        }

        this.setType(methodType);

        return methodType;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        if (this.object != null) {
            this.object.decompile(s);
            s.print(".");
        }
        this.method.decompile(s);
        s.print("(");
        this.args.decompile();
        s.print(")");
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        if (this.object != null) {
            this.object.prettyPrint(s, prefix, false);
        }
        this.method.prettyPrint(s, prefix, false);
        this.args.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        if (this.object != null) {
            this.object.iter(f);
        }
        this.method.iter(f);
        this.args.iter(f);
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        compiler.addInstruction(new ADDSP(args.size() + 1));

        if (this.object != null) {
            object.codeGenInst(compiler, n);
        } else {
            compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.getR(n)));
        }

        compiler.addInstruction(new STORE(Register.getR(n), new RegisterOffset(0, Register.SP)));

        int i = -1;
        for (AbstractExpr arg : args.getList()) {
            arg.codeGenInst(compiler, n);
            compiler.addInstruction(new STORE(Register.getR(n), new RegisterOffset(i, Register.SP)));
            i--;
        }

        // Test si le paramètre implicite est différent de null
        compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.SP), Register.getR(n)));
        if (!compiler.getCompilerOptions().getNoCheck()) {
            compiler.addInstruction(new CMP(new NullOperand(), Register.getR(n)));
        }
        AssError.addErrorNullDeref(compiler);


        compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(n)), Register.getR(n)));
        compiler.getStackMan().incrementPile(2);
        compiler.addInstruction(new BSR(new RegisterOffset(method.getMethodDefinition().getIndex() + 1, Register.getR(n)))); // offset avec la method equals presente par defaut
        compiler.getStackMan().decrementPile(2);
        compiler.addInstruction(new SUBSP(args.size() + 1));
        compiler.addInstruction(new LOAD(Register.R0, Register.getR(n)));
    }


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

    protected void codeGenJump(DecacCompiler compiler, boolean jumpOnEval, Label label, int nReg) {
        this.codeGenInst(compiler, nReg);
        if (jumpOnEval) {
            compiler.addInstruction(new CMP(1, Register.getR(nReg)));
            compiler.addInstruction(new BEQ(label));
        } else {
            compiler.addInstruction(new CMP(0, Register.getR(nReg)));
            compiler.addInstruction(new BEQ(label));
        }
    }


}
