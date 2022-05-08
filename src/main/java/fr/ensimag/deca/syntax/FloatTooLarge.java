package fr.ensimag.deca.syntax;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Syntax error for an expression that should be an lvalue (ie that can be
 * assigned), but is not.
 *
 * @author gl09
 * @date 01/01/2022
 */
public class FloatTooLarge extends DecaRecognitionException {

    private static final long serialVersionUID = 4670163376041273741L;

    public FloatTooLarge(DecaParser recognizer, ParserRuleContext ctx) {
        super(recognizer, ctx);
    }

    @Override
    public String getMessage() {
        return "float is too large";
    }
}
