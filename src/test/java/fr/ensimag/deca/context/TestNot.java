package fr.ensimag.deca.context;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.tree.AbstractExpr;
import fr.ensimag.deca.tree.Not;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 * Test for the Not node using mockito, using @Mock and @Before annotations.
 */
public class TestNot {

    final Type BOOL = new BooleanType(null);

    @Mock
    AbstractExpr boolexpr;

    DecacCompiler compiler;
    
    @BeforeEach
    public void setup() throws ContextualError {
        MockitoAnnotations.initMocks(this);
        compiler = new DecacCompiler(null, null);
        when(boolexpr.verifyExpr(compiler, null, null)).thenReturn(BOOL);
    }

    @Test
    public void test() throws ContextualError {
        Not t = new Not(boolexpr);
        // check the result
        assertTrue(t.verifyExpr(compiler, null, null).isBoolean());
        // check that the mocks have been called properly.
        verify(boolexpr).verifyExpr(compiler, null, null);
    }
}