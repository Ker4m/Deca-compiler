package fr.ensimag.deca.context;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.tree.AbstractExpr;
import fr.ensimag.deca.tree.ConvFloat;
import fr.ensimag.deca.tree.UnaryMinus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 * Test for the Minus node using mockito, using @Mock and @Before annotations.
 */
public class TestUnaryMinus {

    final Type INT = new IntType(null);
    final Type FLOAT = new FloatType(null);

    @Mock
    AbstractExpr intexpr;
    @Mock
    AbstractExpr floatexpr;

    DecacCompiler compiler;
    
    @BeforeEach
    public void setup() throws ContextualError {
        MockitoAnnotations.initMocks(this);
        compiler = new DecacCompiler(null, null);
        when(intexpr.verifyExpr(compiler, null, null)).thenReturn(INT);
        when(floatexpr.verifyExpr(compiler, null, null)).thenReturn(FLOAT);
    }

    @Test
    public void testInt() throws ContextualError {
        UnaryMinus t = new UnaryMinus(intexpr);
        // check the result
        assertTrue(t.verifyExpr(compiler, null, null).isInt());
        // check that the mocks have been called properly.
        verify(intexpr).verifyExpr(compiler, null, null);
    }

    @Test
    public void testFloat() throws ContextualError {
        UnaryMinus t = new UnaryMinus(floatexpr);
        // check the result
        assertTrue(t.verifyExpr(compiler, null, null).isFloat());
        assertFalse(t.getOperand() instanceof ConvFloat);
        // check that the mocks have been called properly.
        verify(floatexpr).verifyExpr(compiler, null, null);
    }
}