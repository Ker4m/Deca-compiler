package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.*;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.RTS;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class DeclMethod extends AbstractDeclMethod {

    private final AbstractIdentifier type;
    private final AbstractIdentifier ident;
    private final ListDeclParam params;
    private final AbstractMethodBody body;

    public DeclMethod(AbstractIdentifier type, AbstractIdentifier ident, ListDeclParam params, AbstractMethodBody body) {
        Validate.notNull(type);
        Validate.notNull(ident);
        Validate.notNull(params);
        Validate.notNull(body);
        this.type = type;
        this.ident = ident;
        this.params = params;
        this.body = body;
    }

    public AbstractIdentifier getIdMethod() {
        return this.ident;
    }

    public AbstractIdentifier getReturnType() {
        return this.type;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        this.type.decompile(s);
        s.print(" ");
        this.ident.decompile(s);
        s.print("(");
        this.params.decompile(s);
        s.print(")");
        this.body.decompile(s);
    }

    @Override
    public void verifyMethodMembers(DecacCompiler compiler,
                                    ClassDefinition currentClass, int index) throws ContextualError {
        Type methodType = this.type.verifyType(compiler);
        Signature methodSignature = new Signature();
        MethodDefinition methodDef = new MethodDefinition(methodType, this.getLocation(), methodSignature, index);

        this.params.verifyListParamMembers(compiler);
        for (AbstractDeclParam param : this.params.getList()) {
            methodDef.getSignature().add(((DeclParam) param).getType());
        }

        this.ident.setType(methodType);
        this.ident.setDefinition(methodDef);

        ExpDefinition superDef = currentClass.getSuperClass().getMembers().get(
                compiler.getSymbols().create(this.ident.getName().getName())
        );

        if (superDef == null) {
            try {
                Symbol s = compiler.getSymbols().create(this.ident.getName().getName());
                currentClass.getMembers().declare(s, methodDef);
            } catch (DoubleDefException e) {
                throw new ContextualError("Method " + this.ident.getName().getName() + " already exists", this.getLocation());
            }
        } else if (!superDef.isMethod()) {
            throw new ContextualError("Trying to override a field and not a method: " + this.ident.getName().getName(), this.getLocation());
        } else {
            MethodDefinition superMethodDef = superDef.asMethodDefinition("This is a field and not a method", this.getLocation());
            if (!superMethodDef.getType().sameType(methodDef.getType())) {
                throw new ContextualError("Override impossible: return type is not the same", this.getLocation());
            } else if (superMethodDef.getSignature().isNotCompatible(methodDef.getSignature())) {
                throw new ContextualError("Override impossible: Signature is not the same", this.getLocation());
            } else {
                try {
                    Symbol s = compiler.getSymbols().create(this.ident.getName().getName());
                    currentClass.getMembers().declare(s, methodDef);
                } catch (DoubleDefException e) {
                    throw new ContextualError("Method " + this.ident.getName().getName() + " already exists", this.getLocation());
                }
            }
        }
    }

    @Override
    public void verifyMethodBody(DecacCompiler compiler,
                                 ClassDefinition currentClass) throws ContextualError {
        Type methodType = this.type.verifyType(compiler);
        EnvironmentExp methodEnv = new EnvironmentExp(currentClass.getMembers());
        this.params.verifyListParamBody(compiler, methodEnv, currentClass);
        this.body.verifyMethodBody(compiler, methodEnv, currentClass, methodType);

    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.type.prettyPrint(s, prefix, false);
        this.ident.prettyPrint(s, prefix, false);
        this.params.prettyPrint(s, prefix, false);
        this.body.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.type.iter(f);
        this.ident.iter(f);
        this.params.iter(f);
        this.body.iter(f);
    }

    @Override
    public void codeGenDeclMethod(DecacCompiler compiler) {
        compiler.getCodeGen().setCurMethod(this);
        compiler.getStackMan().resetPile();
        compiler.getCodeGen().setIndexLB(-3); //reset index LB for param
        String nameClass = compiler.getCodeGen().getCurClass().getIdClass().getName().getName();

        compiler.addLabel(new Label("code." + nameClass + "." + ident.getName().getName()));
        int instrIndex = compiler.getLastInstructionIndex();

        params.codeGenListParam(compiler);

        compiler.getCodeGen().setIndexLB(1); //reset index LB for local var
        body.codeGenBody(compiler);

        compiler.addLabel(new Label("fin." + nameClass + "." + ident.getName().getName()));

        int nbOfUsedRegs = compiler.getStackMan().getMaxPile();
        compiler.getCodeGen().pushRegsAtIndex(nbOfUsedRegs + 1, instrIndex);
        compiler.getStackMan().addblocStackMan(instrIndex);


        compiler.getCodeGen().popRegs(nbOfUsedRegs + 1);
        compiler.addInstruction(new RTS());
    }

}
