package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.InlinePortion;

import java.io.PrintStream;

public class AsmMethodBody extends AbstractMethodBody {
    private final StringLiteral code;

    public AsmMethodBody(StringLiteral code) {
        this.code = code;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print(" asm(");
        this.code.decompile(s);
        s.println(");");
    }

    @Override
    public void verifyMethodBody(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass, Type returnType) {
        this.code.verifyExpr(compiler, localEnv, currentClass);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        this.code.prettyPrint(s, prefix, true);

    }

    @Override
    protected void iterChildren(TreeFunction f) {
        this.code.iterChildren(f);
    }

    @Override
    public void codeGenBody(DecacCompiler compiler) {
        compiler.add(new InlinePortion(code.getValue()));
    }

}
