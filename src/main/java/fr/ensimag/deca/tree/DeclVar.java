package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.*;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

/**
 * @author gl09
 * @date 01/01/2022
 */
public class DeclVar extends AbstractDeclVar {

    final private AbstractIdentifier type;
    final private AbstractIdentifier varName;
    final private AbstractInitialization initialization;

    public DeclVar(AbstractIdentifier type, AbstractIdentifier varName, AbstractInitialization initialization) {
        Validate.notNull(type);
        Validate.notNull(varName);
        Validate.notNull(initialization);
        this.type = type;
        this.varName = varName;
        this.initialization = initialization;
    }

    /* Getter pour les attributs de DeclVar */

    @Override
    protected void verifyDeclVar(DecacCompiler compiler,
                                 EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        Type type = this.type.verifyType(compiler);
        if (type.isVoid()) {
            throw new ContextualError("Variable can not be of type void", this.getLocation());
        }

        VariableDefinition definition = new VariableDefinition(type, this.varName.getLocation());
        this.varName.setDefinition(definition);
        try {
            localEnv.declare(compiler.getSymbols().create(this.varName.getName().getName()), definition);
        } catch (DoubleDefException e) {
            throw new ContextualError("Variable " + this.varName.getName().getName() +
                    " is already declared.", this.getLocation());
        }
        this.varName.verifyExpr(compiler, localEnv, currentClass);

        this.initialization.verifyInitialization(compiler, type, localEnv, currentClass);
    }


    @Override
    public void decompile(IndentPrintStream s) {
        s.print(type.getName().getName() + " " + varName.getName().getName());
        initialization.decompile(s);
        s.println(";");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        type.iter(f);
        varName.iter(f);
        initialization.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        varName.prettyPrint(s, prefix, false);
        initialization.prettyPrint(s, prefix, true);
    }

    @Override
    protected void codeGenDeclVar(DecacCompiler compiler) {
        DAddr addr = new RegisterOffset(compiler.getCodeGen().getIndexGB(), Register.GB);

        // Set the address of the new var
        varName.getExpDefinition().setOperand(addr);

        this.initialization.codeGenInit(addr, compiler, varName.getType());

        compiler.getCodeGen().incrIndexGB();
    }


    @Override
    public void codeGenMethodVar(DecacCompiler compiler) {
        DAddr addr = new RegisterOffset(compiler.getCodeGen().getIndexLB(), Register.LB);
        varName.getExpDefinition().setOperand(addr);
        compiler.getCodeGen().incrIndexLB();
        this.initialization.codeGenInit(addr, compiler, varName.getType());

    }
}
