package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.*;

public class AssError {

    private static final Label pile_pleine = new Label("pile_pleine");
    private static final Label input_error = new Label("input_error");
    private static final Label divisionByZero = new Label("Division_by_zero");
    private static final Label impossible_type_conversion = new Label("impossible_type_conversion");
    private static final Label no_return = new Label("no_return");
    private static final Label null_deref = new Label("dereferencement_de_null");
    private static final Label tas_plein = new Label("tas_plein");
    private static final Label arith_overflow = new Label("arith_overflow");
    private static boolean b_pile_pleine = false;
    private static boolean b_input_err = false;
    private static boolean b_zero_div = false;
    private static boolean b_type_conversion = false;
    private static boolean b_no_return = false;
    private static boolean b_null_deref = false;
    private static boolean b_tas_plein = false;
    private static boolean b_arith_overflow = false;


    public static void addFirstErrorPilePleine(DecacCompiler compiler, int d) {
        if (!(compiler.getCompilerOptions().getNoCheck())) {
            compiler.addFirst(new BOV(pile_pleine));
            compiler.addFirst(new TSTO(d));
            b_pile_pleine = true;
        }
    }

    public static void addErrorPilePleine(DecacCompiler compiler) {
        if (!(compiler.getCompilerOptions().getNoCheck())) {
            compiler.addInstruction(new BOV(pile_pleine));
            b_pile_pleine = true;
        }
    }

    public static void addErrorPilePleineAtIndex(DecacCompiler compiler, int d, int index) {
        if (!(compiler.getCompilerOptions().getNoCheck())) {
            compiler.addInstructionAtIndex(new BOV(pile_pleine), index);
            compiler.addInstructionAtIndex(new TSTO(d), index);
            b_pile_pleine = true;
        }
    }

    public static void addErrorInput(DecacCompiler compiler) {
        if (!(compiler.getCompilerOptions().getNoCheck())) {
            compiler.addInstruction(new BOV(input_error));
            b_input_err = true;
        }
    }

    public static void addErrorTypeConv(DecacCompiler compiler) {
        if (!(compiler.getCompilerOptions().getNoCheck())) {
            compiler.addInstruction(new BOV(impossible_type_conversion));
            b_type_conversion = true;
        }
    }

    public static void addErrorDivZero(DecacCompiler compiler) {
        if (!(compiler.getCompilerOptions().getNoCheck())) {
            compiler.addInstruction(new BOV(divisionByZero));
            b_zero_div = true;
        }
    }

    public static void addErrorNoReturn(DecacCompiler compiler) {
        if (!(compiler.getCompilerOptions().getNoCheck())) {
            compiler.addInstruction(new BRA(no_return));
            b_no_return = true;
        }
    }

    public static void addErrorNullDeref(DecacCompiler compiler) {
        if (!(compiler.getCompilerOptions().getNoCheck())) {
            compiler.addInstruction(new BEQ(null_deref));
            b_null_deref = true;
        }
    }

    public static void addErrorTasPlein(DecacCompiler compiler) {
        if (!(compiler.getCompilerOptions().getNoCheck())) {
            compiler.addInstruction(new BOV(tas_plein));
            b_tas_plein = true;
        }
    }

    public static void addErrorDebordementArith(DecacCompiler compiler) {
        if (!(compiler.getCompilerOptions().getNoCheck())) {
            compiler.addInstruction(new BOV(arith_overflow));
            b_arith_overflow = true;
        }
    }

    public static void addErrorAtEndOfFile(DecacCompiler compiler) {

        if (b_pile_pleine || b_input_err || b_zero_div || b_no_return || b_type_conversion || b_null_deref || b_tas_plein || b_arith_overflow) {
            compiler.addComment("====================================================");
            compiler.addComment("                       ERRORS                      |");
            compiler.addComment("====================================================");
        }

        if (b_pile_pleine) {
            compiler.addLabel(pile_pleine);
            compiler.addInstruction(new WSTR("Error: stack overflow."));
            compiler.addInstruction(new WNL());
            compiler.addInstruction(new ERROR());
        }


        if (b_input_err) {
            compiler.addLabel(input_error);
            compiler.addInstruction(new WSTR("Error : wrong type given in input"));
            compiler.addInstruction(new WNL());
            compiler.addInstruction(new ERROR());
        }

        if (b_zero_div) {
            compiler.addLabel(divisionByZero);
            compiler.addInstruction(new WSTR("Error : division by zero"));
            compiler.addInstruction(new WNL());
            compiler.addInstruction(new ERROR());
        }

        if (b_no_return) {
            compiler.addLabel(no_return);
            compiler.addInstruction(new WSTR("Error : no return after executing a method"));
            compiler.addInstruction(new WNL());
            compiler.addInstruction(new ERROR());
        }

        if (b_type_conversion) {
            compiler.addLabel(impossible_type_conversion);
            compiler.addInstruction(new WSTR("Error : impossible conversion type"));
            compiler.addInstruction(new WNL());
            compiler.addInstruction(new ERROR());
        }

        if (b_null_deref) {
            compiler.addLabel(null_deref);
            compiler.addInstruction(new WSTR("Error : dereferencing of null"));
            compiler.addInstruction(new WNL());
            compiler.addInstruction(new ERROR());
        }

        if (b_tas_plein) {
            compiler.addLabel(tas_plein);
            compiler.addInstruction(new WSTR("Error: heap full"));
            compiler.addInstruction(new WNL());
            compiler.addInstruction(new ERROR());
        }

        if (b_arith_overflow) {
            compiler.addLabel(arith_overflow);
            compiler.addInstruction(new WSTR("Error: arithmetique overflow"));
            compiler.addInstruction(new WNL());
            compiler.addInstruction(new ERROR());
        }
    }


}
