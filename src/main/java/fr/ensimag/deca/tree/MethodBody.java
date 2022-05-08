package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.BRA;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

public class MethodBody extends AbstractMethodBody {
    private final ListDeclVar vars;
    private final ListInst insts;

    public MethodBody(ListDeclVar vars, ListInst insts) {
        Validate.notNull(vars);
        Validate.notNull(insts);
        this.vars = vars;
        this.insts = insts;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.println(" {");
        s.indent();
        this.vars.decompile(s);
        this.insts.decompile(s);
        s.unindent();
        s.println("}");
    }

    @Override
    public void verifyMethodBody(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass, Type returnType) throws ContextualError {
        this.vars.verifyListDeclVariable(compiler, localEnv, currentClass);
        this.insts.verifyListInst(compiler, localEnv, currentClass, returnType);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.vars.prettyPrint(s, prefix, false);
        this.insts.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.vars.iter(f);
        this.insts.iter(f);
    }

    @Override
    public void codeGenBody(DecacCompiler compiler) {
        vars.codeGenListDeclVar(compiler, true); // to test
        insts.codeGenListInst(compiler);
        if (!compiler.getCodeGen().getCurMethod().getReturnType().getType().isVoid()) {
            AssError.addErrorNoReturn(compiler);
        } else {
            String className = compiler.getCodeGen().getCurClass().getIdClass().getName().getName();
            String methodName = compiler.getCodeGen().getCurMethod().getIdMethod().getName().getName();
            compiler.addInstruction(new BRA(new Label("fin." + className + "." + methodName)));
        }
    }

}
