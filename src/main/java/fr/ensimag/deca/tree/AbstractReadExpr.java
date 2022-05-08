package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.AssError;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.LOAD;

/**
 * read...() statement.
 *
 * @author gl09
 * @date 01/01/2022
 */
public abstract class AbstractReadExpr extends AbstractExpr {

    public AbstractReadExpr() {
        super();
    }

    protected abstract Instruction mnemo();

    @Override
    public void codeGenInst(DecacCompiler compiler, int n) {
        compiler.addInstruction(this.mnemo());

        AssError.addErrorInput(compiler);

        compiler.addInstruction(new LOAD(Register.R1, Register.getR(n)));
    }


}
