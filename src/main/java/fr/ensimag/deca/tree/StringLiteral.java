package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.StringType;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.ImmediateString;
import fr.ensimag.ima.pseudocode.instructions.WSTR;
import org.apache.commons.lang.Validate;

import java.io.PrintStream;

/**
 * String literal
 *
 * @author gl09
 * @date 01/01/2022
 */
public class StringLiteral extends AbstractStringLiteral {

    private final String value;

    public StringLiteral(String value) {
        Validate.notNull(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
                           ClassDefinition currentClass) {
        this.setType(new StringType(compiler.getSymbols().create("String")));
        return this.getType();
    }

    @Override
    protected void codeGenPrint(DecacCompiler compiler, boolean hex, int nReg) {
        String modifiedValue = this.getValue();
        int lastCharPrint = 0;
        for (int i = 0; i < modifiedValue.length() - 1; i++) {
            if (modifiedValue.charAt(i) == '\\' && modifiedValue.charAt(i + 1) == '\\') {
                compiler.addInstruction(new WSTR(modifiedValue.substring(lastCharPrint, i) + '\\'));
                lastCharPrint = i + 2;
                i++;
            }
        }
        if (lastCharPrint < modifiedValue.length()) {
            compiler.addInstruction(new WSTR(new ImmediateString(modifiedValue.substring(lastCharPrint))));
        }
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("\"");
        char[] caracList = new char[value.length()];
        value.getChars(0, value.length(), caracList, 0);
        for (char character : caracList) {
            if (character == '"') {
                s.print("\\\"");
            } else {
                s.print(character);
            }
        }
        s.print("\"");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        // leaf node => nothing to do
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // leaf node => nothing to do
    }

    @Override
    String prettyPrintNode() {
        return "StringLiteral (" + value + ")";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, int n) {
        // Nothing to do => ima doesn't support String type
    }
}
