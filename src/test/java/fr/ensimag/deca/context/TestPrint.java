package fr.ensimag.deca.context;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.tree.AbstractExpr;
import fr.ensimag.deca.tree.ListExpr;
import fr.ensimag.deca.tree.Print;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 * Test for the Print node using mockito, using @Mock and @Before annotations.
 */
public class TestPrint {

    final Type CHAR = new StringType(null);
    final Type VOID = new VoidType(null);

    @Mock
    ListExpr args;

    DecacCompiler compiler;
    
    @BeforeEach
    public void setup() throws ContextualError {
        MockitoAnnotations.initMocks(this);
        compiler = new DecacCompiler(null, null);
        for(AbstractExpr e : args.getList()){
            when(e.verifyExpr(compiler, null, null)).thenReturn(CHAR);
        }
    }

    @Test
    public void testIntInt() throws ContextualError {
        new Print(true, args);
        // check the result
        //t.verifyInst(compiler, null, null, VOID);
        // check that the mocks have been called properly.
        // verify(intexpr1).verifyExpr(compiler, null, null);
        // verify(intexpr2).verifyExpr(compiler, null, null);
    }
}