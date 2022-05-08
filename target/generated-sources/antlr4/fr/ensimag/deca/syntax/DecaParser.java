// Generated from fr/ensimag/deca/syntax/DecaParser.g4 by ANTLR 4.9.3
package fr.ensimag.deca.syntax;

    import fr.ensimag.deca.tree.*;
    import java.io.PrintStream;
    import fr.ensimag.deca.tools.SymbolTable;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecaParser extends AbstractDecaParser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ASM=1, CLASS=2, EXTENDS=3, ELSE=4, FALSE=5, IF=6, INSTANCEOF=7, NEW=8, 
		NULL=9, READINT=10, READFLOAT=11, PRINT=12, PRINTLN=13, PRINTLNX=14, PRINTX=15, 
		PROTECTED=16, RETURN=17, THIS=18, TRUE=19, WHILE=20, FOR=21, IDENT=22, 
		LT=23, GT=24, EQUALS=25, PLUS=26, MINUS=27, TIMES=28, SLASH=29, PERCENT=30, 
		DOT=31, COMMA=32, OPARENT=33, CPARENT=34, OBRACE=35, CBRACE=36, EXCLAM=37, 
		SEMI=38, EQEQ=39, NEQ=40, GEQ=41, LEQ=42, AND=43, OR=44, OBRACKET=45, 
		CBRACKET=46, COL=47, INT=48, FLOAT=49, STRING=50, MULTI_LINE_STRING=51, 
		SEP=52, INCLUDE=53;
	public static final int
		RULE_prog = 0, RULE_main = 1, RULE_block = 2, RULE_list_decl = 3, RULE_decl_var_set = 4, 
		RULE_list_decl_var = 5, RULE_list_decl_matrix = 6, RULE_decl_var = 7, 
		RULE_decl_matrix = 8, RULE_list_inst = 9, RULE_inst = 10, RULE_if_then_else = 11, 
		RULE_list_expr = 12, RULE_expr = 13, RULE_assign_expr = 14, RULE_or_expr = 15, 
		RULE_and_expr = 16, RULE_eq_neq_expr = 17, RULE_inequality_expr = 18, 
		RULE_sum_expr = 19, RULE_mult_expr = 20, RULE_unary_expr = 21, RULE_select_expr = 22, 
		RULE_primary_expr = 23, RULE_type = 24, RULE_matrix_type = 25, RULE_literal = 26, 
		RULE_ident = 27, RULE_matrix_ident = 28, RULE_list_classes = 29, RULE_class_decl = 30, 
		RULE_class_extension = 31, RULE_class_body = 32, RULE_decl_field_set = 33, 
		RULE_list_decl_matrix_field = 34, RULE_decl_matrix_field = 35, RULE_visibility = 36, 
		RULE_list_decl_field = 37, RULE_decl_field = 38, RULE_decl_method = 39, 
		RULE_list_params = 40, RULE_multi_line_string = 41, RULE_param = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "main", "block", "list_decl", "decl_var_set", "list_decl_var", 
			"list_decl_matrix", "decl_var", "decl_matrix", "list_inst", "inst", "if_then_else", 
			"list_expr", "expr", "assign_expr", "or_expr", "and_expr", "eq_neq_expr", 
			"inequality_expr", "sum_expr", "mult_expr", "unary_expr", "select_expr", 
			"primary_expr", "type", "matrix_type", "literal", "ident", "matrix_ident", 
			"list_classes", "class_decl", "class_extension", "class_body", "decl_field_set", 
			"list_decl_matrix_field", "decl_matrix_field", "visibility", "list_decl_field", 
			"decl_field", "decl_method", "list_params", "multi_line_string", "param"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'asm'", "'class'", "'extends'", "'else'", "'false'", "'if'", "'instanceof'", 
			"'new'", "'null'", "'readInt'", "'readFloat'", "'print'", "'println'", 
			"'printlnx'", "'printx'", "'protected'", "'return'", "'this'", "'true'", 
			"'while'", "'for'", null, "'<'", "'>'", "'='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'.'", "','", "'('", "')'", "'{'", "'}'", "'!'", "';'", "'=='", 
			"'!='", "'>='", "'<='", "'&&'", "'||'", "'['", "']'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ASM", "CLASS", "EXTENDS", "ELSE", "FALSE", "IF", "INSTANCEOF", 
			"NEW", "NULL", "READINT", "READFLOAT", "PRINT", "PRINTLN", "PRINTLNX", 
			"PRINTX", "PROTECTED", "RETURN", "THIS", "TRUE", "WHILE", "FOR", "IDENT", 
			"LT", "GT", "EQUALS", "PLUS", "MINUS", "TIMES", "SLASH", "PERCENT", "DOT", 
			"COMMA", "OPARENT", "CPARENT", "OBRACE", "CBRACE", "EXCLAM", "SEMI", 
			"EQEQ", "NEQ", "GEQ", "LEQ", "AND", "OR", "OBRACKET", "CBRACKET", "COL", 
			"INT", "FLOAT", "STRING", "MULTI_LINE_STRING", "SEP", "INCLUDE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DecaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    SymbolTable symbols = new SymbolTable();
	    @Override
	    protected AbstractProgram parseProgram() {
	        return prog().tree;
	    }

	public DecaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public AbstractProgram tree;
		public List_classesContext list_classes;
		public MainContext main;
		public List_classesContext list_classes() {
			return getRuleContext(List_classesContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DecaParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			((ProgContext)_localctx).list_classes = list_classes();
			setState(87);
			((ProgContext)_localctx).main = main();
			setState(88);
			match(EOF);

			            assert(((ProgContext)_localctx).list_classes.tree != null);
			            assert(((ProgContext)_localctx).main.tree != null);
			            ((ProgContext)_localctx).tree =  new Program(((ProgContext)_localctx).list_classes.tree, ((ProgContext)_localctx).main.tree);
			            setLocation(_localctx.tree, (((ProgContext)_localctx).list_classes!=null?(((ProgContext)_localctx).list_classes.start):null));
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public AbstractMain tree;
		public BlockContext block;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{

				            ((MainContext)_localctx).tree =  new EmptyMain();
				        
				}
				break;
			case OBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				((MainContext)_localctx).block = block();

				            assert(((MainContext)_localctx).block.decls != null);
				            assert(((MainContext)_localctx).block.insts != null);
				            ((MainContext)_localctx).tree =  new Main(((MainContext)_localctx).block.decls, ((MainContext)_localctx).block.insts);
				            setLocation(_localctx.tree, (((MainContext)_localctx).block!=null?(((MainContext)_localctx).block.start):null));
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public ListDeclVar decls;
		public ListInst insts;
		public List_declContext list_decl;
		public List_instContext list_inst;
		public TerminalNode OBRACE() { return getToken(DecaParser.OBRACE, 0); }
		public List_declContext list_decl() {
			return getRuleContext(List_declContext.class,0);
		}
		public List_instContext list_inst() {
			return getRuleContext(List_instContext.class,0);
		}
		public TerminalNode CBRACE() { return getToken(DecaParser.CBRACE, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(OBRACE);
			setState(98);
			((BlockContext)_localctx).list_decl = list_decl();
			setState(99);
			((BlockContext)_localctx).list_inst = list_inst();
			setState(100);
			match(CBRACE);

			            assert(((BlockContext)_localctx).list_decl.tree != null);
			            assert(((BlockContext)_localctx).list_inst.tree != null);
			            ((BlockContext)_localctx).decls =  ((BlockContext)_localctx).list_decl.tree;
			            ((BlockContext)_localctx).insts =  ((BlockContext)_localctx).list_inst.tree;
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_declContext extends ParserRuleContext {
		public ListDeclVar tree;
		public List<Decl_var_setContext> decl_var_set() {
			return getRuleContexts(Decl_var_setContext.class);
		}
		public Decl_var_setContext decl_var_set(int i) {
			return getRuleContext(Decl_var_setContext.class,i);
		}
		public List_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_decl; }
	}

	public final List_declContext list_decl() throws RecognitionException {
		List_declContext _localctx = new List_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_list_decl);

		            ((List_declContext)_localctx).tree =  new ListDeclVar();
		        
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(103);
					decl_var_set(_localctx.tree);
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_var_setContext extends ParserRuleContext {
		public ListDeclVar l;
		public TypeContext type;
		public Matrix_typeContext matrix_type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List_decl_varContext list_decl_var() {
			return getRuleContext(List_decl_varContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(DecaParser.SEMI, 0); }
		public Matrix_typeContext matrix_type() {
			return getRuleContext(Matrix_typeContext.class,0);
		}
		public List_decl_matrixContext list_decl_matrix() {
			return getRuleContext(List_decl_matrixContext.class,0);
		}
		public Decl_var_setContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Decl_var_setContext(ParserRuleContext parent, int invokingState, ListDeclVar l) {
			super(parent, invokingState);
			this.l = l;
		}
		@Override public int getRuleIndex() { return RULE_decl_var_set; }
	}

	public final Decl_var_setContext decl_var_set(ListDeclVar l) throws RecognitionException {
		Decl_var_setContext _localctx = new Decl_var_setContext(_ctx, getState(), l);
		enterRule(_localctx, 8, RULE_decl_var_set);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				((Decl_var_setContext)_localctx).type = type();
				setState(110);
				list_decl_var(_localctx.l,((Decl_var_setContext)_localctx).type.tree);
				setState(111);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				((Decl_var_setContext)_localctx).matrix_type = matrix_type();
				setState(114);
				list_decl_matrix(_localctx.l,((Decl_var_setContext)_localctx).matrix_type.tree);
				setState(115);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_decl_varContext extends ParserRuleContext {
		public ListDeclVar l;
		public AbstractIdentifier t;
		public Decl_varContext dv1;
		public Decl_varContext dv2;
		public List<Decl_varContext> decl_var() {
			return getRuleContexts(Decl_varContext.class);
		}
		public Decl_varContext decl_var(int i) {
			return getRuleContext(Decl_varContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecaParser.COMMA, i);
		}
		public List_decl_varContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public List_decl_varContext(ParserRuleContext parent, int invokingState, ListDeclVar l, AbstractIdentifier t) {
			super(parent, invokingState);
			this.l = l;
			this.t = t;
		}
		@Override public int getRuleIndex() { return RULE_list_decl_var; }
	}

	public final List_decl_varContext list_decl_var(ListDeclVar l,AbstractIdentifier t) throws RecognitionException {
		List_decl_varContext _localctx = new List_decl_varContext(_ctx, getState(), l, t);
		enterRule(_localctx, 10, RULE_list_decl_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((List_decl_varContext)_localctx).dv1 = decl_var(_localctx.t);

			        _localctx.l.add(((List_decl_varContext)_localctx).dv1.tree);
			        
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(121);
				match(COMMA);
				setState(122);
				((List_decl_varContext)_localctx).dv2 = decl_var(_localctx.t);

				            _localctx.l.add(((List_decl_varContext)_localctx).dv2.tree);
				        
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_decl_matrixContext extends ParserRuleContext {
		public ListDeclVar l;
		public AbstractIdentifier t;
		public Decl_matrixContext dv1;
		public Decl_matrixContext dv2;
		public List<Decl_matrixContext> decl_matrix() {
			return getRuleContexts(Decl_matrixContext.class);
		}
		public Decl_matrixContext decl_matrix(int i) {
			return getRuleContext(Decl_matrixContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecaParser.COMMA, i);
		}
		public List_decl_matrixContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public List_decl_matrixContext(ParserRuleContext parent, int invokingState, ListDeclVar l, AbstractIdentifier t) {
			super(parent, invokingState);
			this.l = l;
			this.t = t;
		}
		@Override public int getRuleIndex() { return RULE_list_decl_matrix; }
	}

	public final List_decl_matrixContext list_decl_matrix(ListDeclVar l,AbstractIdentifier t) throws RecognitionException {
		List_decl_matrixContext _localctx = new List_decl_matrixContext(_ctx, getState(), l, t);
		enterRule(_localctx, 12, RULE_list_decl_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			((List_decl_matrixContext)_localctx).dv1 = decl_matrix(_localctx.t);

			            _localctx.l.add(((List_decl_matrixContext)_localctx).dv1.tree);
			            
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(132);
				match(COMMA);
				setState(133);
				((List_decl_matrixContext)_localctx).dv2 = decl_matrix(_localctx.t);

				                _localctx.l.add(((List_decl_matrixContext)_localctx).dv2.tree);
				            
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_varContext extends ParserRuleContext {
		public AbstractIdentifier t;
		public AbstractDeclVar tree;
		public IdentContext i;
		public ExprContext e;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(DecaParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Decl_varContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Decl_varContext(ParserRuleContext parent, int invokingState, AbstractIdentifier t) {
			super(parent, invokingState);
			this.t = t;
		}
		@Override public int getRuleIndex() { return RULE_decl_var; }
	}

	public final Decl_varContext decl_var(AbstractIdentifier t) throws RecognitionException {
		Decl_varContext _localctx = new Decl_varContext(_ctx, getState(), t);
		enterRule(_localctx, 14, RULE_decl_var);

		            Initialization initialization;

		            boolean isInitialize = false;
		        
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			((Decl_varContext)_localctx).i = ident();

			            assert(((Decl_varContext)_localctx).i.tree != null);
			        
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALS) {
				{
				setState(143);
				match(EQUALS);
				setState(144);
				((Decl_varContext)_localctx).e = expr();

				            assert(((Decl_varContext)_localctx).e.tree != null);
				            initialization = new Initialization(((Decl_varContext)_localctx).e.tree);
				            setLocation(initialization, (((Decl_varContext)_localctx).e!=null?(((Decl_varContext)_localctx).e.start):null));
				            ((Decl_varContext)_localctx).tree =  new DeclVar(t, ((Decl_varContext)_localctx).i.tree, initialization);
				            isInitialize = true;
				        
				}
			}


			            if (!isInitialize) ((Decl_varContext)_localctx).tree =  new DeclVar(t, ((Decl_varContext)_localctx).i.tree, new NoInitialization());
			        

			            setLocation(_localctx.tree, (((Decl_varContext)_localctx).i!=null?(((Decl_varContext)_localctx).i.start):null));
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_matrixContext extends ParserRuleContext {
		public AbstractIdentifier t;
		public AbstractDeclVar tree;
		public List_exprContext size;
		public IdentContext name;
		public TerminalNode OBRACKET() { return getToken(DecaParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(DecaParser.CBRACKET, 0); }
		public List_exprContext list_expr() {
			return getRuleContext(List_exprContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Decl_matrixContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Decl_matrixContext(ParserRuleContext parent, int invokingState, AbstractIdentifier t) {
			super(parent, invokingState);
			this.t = t;
		}
		@Override public int getRuleIndex() { return RULE_decl_matrix; }
	}

	public final Decl_matrixContext decl_matrix(AbstractIdentifier t) throws RecognitionException {
		Decl_matrixContext _localctx = new Decl_matrixContext(_ctx, getState(), t);
		enterRule(_localctx, 16, RULE_decl_matrix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(OBRACKET);
			setState(153);
			((Decl_matrixContext)_localctx).size = list_expr();
			setState(154);
			match(CBRACKET);
			setState(155);
			((Decl_matrixContext)_localctx).name = ident();

			        assert(((Decl_matrixContext)_localctx).name.tree != null);
			        assert(((Decl_matrixContext)_localctx).size.tree != null);
			        ((Decl_matrixContext)_localctx).tree =  new DeclMatrix(t, ((Decl_matrixContext)_localctx).size.tree, ((Decl_matrixContext)_localctx).name.tree, new NoInitialization());
			        setLocation(_localctx.tree, (((Decl_matrixContext)_localctx).name!=null?(((Decl_matrixContext)_localctx).name.start):null));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_instContext extends ParserRuleContext {
		public ListInst tree;
		public InstContext inst;
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public List_instContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_inst; }
	}

	public final List_instContext list_inst() throws RecognitionException {
		List_instContext _localctx = new List_instContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_list_inst);

		    ((List_instContext)_localctx).tree =  new ListInst();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << IF) | (1L << NEW) | (1L << NULL) | (1L << READINT) | (1L << READFLOAT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PRINTLNX) | (1L << PRINTX) | (1L << RETURN) | (1L << THIS) | (1L << TRUE) | (1L << WHILE) | (1L << FOR) | (1L << IDENT) | (1L << MINUS) | (1L << OPARENT) | (1L << EXCLAM) | (1L << SEMI) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
				{
				{
				setState(158);
				((List_instContext)_localctx).inst = inst();

				        assert(((List_instContext)_localctx).inst.tree != null);
				        _localctx.tree.add(((List_instContext)_localctx).inst.tree);
				        
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstContext extends ParserRuleContext {
		public AbstractInst tree;
		public ExprContext e1;
		public Token SEMI;
		public Token PRINT;
		public List_exprContext list_expr;
		public Token PRINTLN;
		public Token PRINTX;
		public Token PRINTLNX;
		public If_then_elseContext if_then_else;
		public Token WHILE;
		public ExprContext condition;
		public List_instContext body;
		public Token RETURN;
		public ExprContext expr;
		public Token FOR;
		public TypeContext elementType;
		public IdentContext element;
		public Primary_exprContext obj;
		public TerminalNode SEMI() { return getToken(DecaParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(DecaParser.PRINT, 0); }
		public TerminalNode OPARENT() { return getToken(DecaParser.OPARENT, 0); }
		public List_exprContext list_expr() {
			return getRuleContext(List_exprContext.class,0);
		}
		public TerminalNode CPARENT() { return getToken(DecaParser.CPARENT, 0); }
		public TerminalNode PRINTLN() { return getToken(DecaParser.PRINTLN, 0); }
		public TerminalNode PRINTX() { return getToken(DecaParser.PRINTX, 0); }
		public TerminalNode PRINTLNX() { return getToken(DecaParser.PRINTLNX, 0); }
		public If_then_elseContext if_then_else() {
			return getRuleContext(If_then_elseContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(DecaParser.WHILE, 0); }
		public TerminalNode OBRACE() { return getToken(DecaParser.OBRACE, 0); }
		public TerminalNode CBRACE() { return getToken(DecaParser.CBRACE, 0); }
		public List_instContext list_inst() {
			return getRuleContext(List_instContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(DecaParser.RETURN, 0); }
		public TerminalNode FOR() { return getToken(DecaParser.FOR, 0); }
		public TerminalNode COL() { return getToken(DecaParser.COL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Primary_exprContext primary_expr() {
			return getRuleContext(Primary_exprContext.class,0);
		}
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inst);
		try {
			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case NEW:
			case NULL:
			case READINT:
			case READFLOAT:
			case THIS:
			case TRUE:
			case IDENT:
			case MINUS:
			case OPARENT:
			case EXCLAM:
			case INT:
			case FLOAT:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				((InstContext)_localctx).e1 = expr();
				setState(167);
				match(SEMI);

				            assert(((InstContext)_localctx).e1.tree != null);
				            ((InstContext)_localctx).tree =  ((InstContext)_localctx).e1.tree;
				        
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				((InstContext)_localctx).SEMI = match(SEMI);

				            ((InstContext)_localctx).tree =  new NoOperation();
				            setLocation(_localctx.tree, ((InstContext)_localctx).SEMI);
				        
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				((InstContext)_localctx).PRINT = match(PRINT);
				setState(173);
				match(OPARENT);
				setState(174);
				((InstContext)_localctx).list_expr = list_expr();
				setState(175);
				match(CPARENT);
				setState(176);
				match(SEMI);

				            assert(((InstContext)_localctx).list_expr.tree != null);
				            ((InstContext)_localctx).tree =  new Print(false, ((InstContext)_localctx).list_expr.tree);
				            setLocation(_localctx.tree, ((InstContext)_localctx).PRINT);
				        
				}
				break;
			case PRINTLN:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				((InstContext)_localctx).PRINTLN = match(PRINTLN);
				setState(180);
				match(OPARENT);
				setState(181);
				((InstContext)_localctx).list_expr = list_expr();
				setState(182);
				match(CPARENT);
				setState(183);
				match(SEMI);

				            assert(((InstContext)_localctx).list_expr.tree != null);
				            ((InstContext)_localctx).tree =  new Println(false, ((InstContext)_localctx).list_expr.tree);
				            setLocation(_localctx.tree, ((InstContext)_localctx).PRINTLN);
				        
				}
				break;
			case PRINTX:
				enterOuterAlt(_localctx, 5);
				{
				setState(186);
				((InstContext)_localctx).PRINTX = match(PRINTX);
				setState(187);
				match(OPARENT);
				setState(188);
				((InstContext)_localctx).list_expr = list_expr();
				setState(189);
				match(CPARENT);
				setState(190);
				match(SEMI);

				            assert(((InstContext)_localctx).list_expr.tree != null);
				            ((InstContext)_localctx).tree =  new Print(true, ((InstContext)_localctx).list_expr.tree);
				            setLocation(_localctx.tree, ((InstContext)_localctx).PRINTX);
				        
				}
				break;
			case PRINTLNX:
				enterOuterAlt(_localctx, 6);
				{
				setState(193);
				((InstContext)_localctx).PRINTLNX = match(PRINTLNX);
				setState(194);
				match(OPARENT);
				setState(195);
				((InstContext)_localctx).list_expr = list_expr();
				setState(196);
				match(CPARENT);
				setState(197);
				match(SEMI);

				            assert(((InstContext)_localctx).list_expr.tree != null);
				            ((InstContext)_localctx).tree =  new Println(true, ((InstContext)_localctx).list_expr.tree);
				            setLocation(_localctx.tree, ((InstContext)_localctx).PRINTLNX);
				        
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 7);
				{
				setState(200);
				((InstContext)_localctx).if_then_else = if_then_else();

				            assert(((InstContext)_localctx).if_then_else.tree != null);
				            ((InstContext)_localctx).tree =  ((InstContext)_localctx).if_then_else.tree;
				        
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 8);
				{
				setState(203);
				((InstContext)_localctx).WHILE = match(WHILE);
				setState(204);
				match(OPARENT);
				setState(205);
				((InstContext)_localctx).condition = expr();
				setState(206);
				match(CPARENT);
				setState(207);
				match(OBRACE);
				setState(208);
				((InstContext)_localctx).body = list_inst();
				setState(209);
				match(CBRACE);

				            assert(((InstContext)_localctx).condition.tree != null);
				            assert(((InstContext)_localctx).body.tree != null);
				            ((InstContext)_localctx).tree =  new While(((InstContext)_localctx).condition.tree, ((InstContext)_localctx).body.tree);
				            setLocation(_localctx.tree, ((InstContext)_localctx).WHILE);
				        
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 9);
				{
				setState(212);
				((InstContext)_localctx).RETURN = match(RETURN);
				setState(213);
				((InstContext)_localctx).expr = expr();
				setState(214);
				match(SEMI);

				            assert(((InstContext)_localctx).expr.tree != null);
				            ((InstContext)_localctx).tree =  new Return(((InstContext)_localctx).expr.tree);
				            setLocation(_localctx.tree, ((InstContext)_localctx).RETURN);
				        
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 10);
				{
				setState(217);
				((InstContext)_localctx).FOR = match(FOR);
				setState(218);
				match(OPARENT);
				setState(219);
				((InstContext)_localctx).elementType = type();
				setState(220);
				((InstContext)_localctx).element = ident();
				setState(221);
				match(COL);
				setState(222);
				((InstContext)_localctx).obj = primary_expr();
				setState(223);
				match(CPARENT);
				setState(224);
				match(OBRACE);
				setState(225);
				((InstContext)_localctx).body = list_inst();
				setState(226);
				match(CBRACE);

				            assert(((InstContext)_localctx).elementType.tree != null);
				            assert(((InstContext)_localctx).element.tree != null);
				            assert(((InstContext)_localctx).obj.tree != null);
				            assert(((InstContext)_localctx).body.tree != null);
				            ((InstContext)_localctx).tree =  new For(((InstContext)_localctx).elementType.tree, ((InstContext)_localctx).element.tree, ((InstContext)_localctx).obj.tree, ((InstContext)_localctx).body.tree);
				            setLocation(_localctx.tree, ((InstContext)_localctx).FOR);    
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_then_elseContext extends ParserRuleContext {
		public IfThenElse tree;
		public Token if1;
		public ExprContext condition;
		public List_instContext li_if;
		public Token elsif;
		public ExprContext elsif_cond;
		public List_instContext elsif_li;
		public List_instContext li_else;
		public List<TerminalNode> OPARENT() { return getTokens(DecaParser.OPARENT); }
		public TerminalNode OPARENT(int i) {
			return getToken(DecaParser.OPARENT, i);
		}
		public List<TerminalNode> CPARENT() { return getTokens(DecaParser.CPARENT); }
		public TerminalNode CPARENT(int i) {
			return getToken(DecaParser.CPARENT, i);
		}
		public List<TerminalNode> OBRACE() { return getTokens(DecaParser.OBRACE); }
		public TerminalNode OBRACE(int i) {
			return getToken(DecaParser.OBRACE, i);
		}
		public List<TerminalNode> CBRACE() { return getTokens(DecaParser.CBRACE); }
		public TerminalNode CBRACE(int i) {
			return getToken(DecaParser.CBRACE, i);
		}
		public List<TerminalNode> IF() { return getTokens(DecaParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(DecaParser.IF, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<List_instContext> list_inst() {
			return getRuleContexts(List_instContext.class);
		}
		public List_instContext list_inst(int i) {
			return getRuleContext(List_instContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(DecaParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(DecaParser.ELSE, i);
		}
		public If_then_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_then_else; }
	}

	public final If_then_elseContext if_then_else() throws RecognitionException {
		If_then_elseContext _localctx = new If_then_elseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_then_else);

		    IfThenElse tempTree;
		    ListInst elseBranch = new ListInst();
		    ListInst elsifElseBranch = new ListInst();

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			((If_then_elseContext)_localctx).if1 = match(IF);
			setState(232);
			match(OPARENT);
			setState(233);
			((If_then_elseContext)_localctx).condition = expr();
			setState(234);
			match(CPARENT);
			setState(235);
			match(OBRACE);
			setState(236);
			((If_then_elseContext)_localctx).li_if = list_inst();
			setState(237);
			match(CBRACE);

			        assert(((If_then_elseContext)_localctx).condition.tree != null);
			        assert(((If_then_elseContext)_localctx).li_if.tree != null);

			        ((If_then_elseContext)_localctx).tree =  new IfThenElse(((If_then_elseContext)_localctx).condition.tree, ((If_then_elseContext)_localctx).li_if.tree, elseBranch);
			        setLocation(_localctx.tree, ((If_then_elseContext)_localctx).if1);

			        tempTree = _localctx.tree;
			        
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(239);
					match(ELSE);
					setState(240);
					((If_then_elseContext)_localctx).elsif = match(IF);
					setState(241);
					match(OPARENT);
					setState(242);
					((If_then_elseContext)_localctx).elsif_cond = expr();
					setState(243);
					match(CPARENT);
					setState(244);
					match(OBRACE);
					setState(245);
					((If_then_elseContext)_localctx).elsif_li = list_inst();
					setState(246);
					match(CBRACE);

					        assert(((If_then_elseContext)_localctx).elsif_cond.tree != null);
					        assert(((If_then_elseContext)_localctx).elsif_li.tree != null);

					        tempTree = new IfThenElse(((If_then_elseContext)_localctx).elsif_cond.tree, ((If_then_elseContext)_localctx).elsif_li.tree, elsifElseBranch);
					        setLocation(tempTree, ((If_then_elseContext)_localctx).elsif);

					        elseBranch.add(tempTree);
					        elseBranch = elsifElseBranch;
					        
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(254);
				match(ELSE);
				setState(255);
				match(OBRACE);
				setState(256);
				((If_then_elseContext)_localctx).li_else = list_inst();
				setState(257);
				match(CBRACE);

				        assert(((If_then_elseContext)_localctx).li_else.tree != null);

				        tempTree.setElseBranch(((If_then_elseContext)_localctx).li_else.tree);
				        
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_exprContext extends ParserRuleContext {
		public ListExpr tree;
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecaParser.COMMA, i);
		}
		public List_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_expr; }
	}

	public final List_exprContext list_expr() throws RecognitionException {
		List_exprContext _localctx = new List_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_list_expr);

		    ((List_exprContext)_localctx).tree =  new ListExpr();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FALSE) | (1L << NEW) | (1L << NULL) | (1L << READINT) | (1L << READFLOAT) | (1L << THIS) | (1L << TRUE) | (1L << IDENT) | (1L << MINUS) | (1L << OPARENT) | (1L << EXCLAM) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
				{
				setState(262);
				((List_exprContext)_localctx).e1 = expr();

				            assert(((List_exprContext)_localctx).e1.tree != null);
				            _localctx.tree.add(((List_exprContext)_localctx).e1.tree);
				        
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(264);
					match(COMMA);
					setState(265);
					((List_exprContext)_localctx).e2 = expr();

					            assert(((List_exprContext)_localctx).e2.tree != null);
					            _localctx.tree.add(((List_exprContext)_localctx).e2.tree);
					        
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public Assign_exprContext assign_expr;
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			((ExprContext)_localctx).assign_expr = assign_expr();

			            assert(((ExprContext)_localctx).assign_expr.tree != null);
			            ((ExprContext)_localctx).tree =  ((ExprContext)_localctx).assign_expr.tree;
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_exprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public Or_exprContext e;
		public Token EQUALS;
		public Assign_exprContext e2;
		public Or_exprContext or_expr() {
			return getRuleContext(Or_exprContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(DecaParser.EQUALS, 0); }
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assign_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			((Assign_exprContext)_localctx).e = or_expr(0);
			setState(285);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUALS:
				{

				            if (! (((Assign_exprContext)_localctx).e.tree instanceof AbstractLValue)) {
				                throw new InvalidLValue(this, _localctx);
				            }
				        
				setState(280);
				((Assign_exprContext)_localctx).EQUALS = match(EQUALS);
				setState(281);
				((Assign_exprContext)_localctx).e2 = assign_expr();

				            assert(((Assign_exprContext)_localctx).e.tree != null);
				            assert(((Assign_exprContext)_localctx).e2.tree != null);
				            ((Assign_exprContext)_localctx).tree =  new Assign((AbstractLValue) ((Assign_exprContext)_localctx).e.tree, ((Assign_exprContext)_localctx).e2.tree);
				            setLocation(_localctx.tree, ((Assign_exprContext)_localctx).EQUALS);
				        
				}
				break;
			case COMMA:
			case CPARENT:
			case SEMI:
			case CBRACKET:
				{

				            assert(((Assign_exprContext)_localctx).e.tree != null);
				            ((Assign_exprContext)_localctx).tree =  ((Assign_exprContext)_localctx).e.tree;
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_exprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public Or_exprContext e1;
		public And_exprContext e;
		public Token OR;
		public And_exprContext e2;
		public And_exprContext and_expr() {
			return getRuleContext(And_exprContext.class,0);
		}
		public TerminalNode OR() { return getToken(DecaParser.OR, 0); }
		public Or_exprContext or_expr() {
			return getRuleContext(Or_exprContext.class,0);
		}
		public Or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expr; }
	}

	public final Or_exprContext or_expr() throws RecognitionException {
		return or_expr(0);
	}

	private Or_exprContext or_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Or_exprContext _localctx = new Or_exprContext(_ctx, _parentState);
		Or_exprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_or_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(288);
			((Or_exprContext)_localctx).e = and_expr(0);

			            assert(((Or_exprContext)_localctx).e.tree != null);
			            ((Or_exprContext)_localctx).tree =  ((Or_exprContext)_localctx).e.tree;
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Or_exprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_or_expr);
					setState(291);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(292);
					((Or_exprContext)_localctx).OR = match(OR);
					setState(293);
					((Or_exprContext)_localctx).e2 = and_expr(0);

					                      assert(((Or_exprContext)_localctx).e1.tree != null);
					                      assert(((Or_exprContext)_localctx).e2.tree != null);
					                      ((Or_exprContext)_localctx).tree =  new Or(((Or_exprContext)_localctx).e1.tree, ((Or_exprContext)_localctx).e2.tree);
					                      setLocation(_localctx.tree, ((Or_exprContext)_localctx).OR);
					                 
					}
					} 
				}
				setState(300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class And_exprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public And_exprContext e1;
		public Eq_neq_exprContext e;
		public Token AND;
		public Eq_neq_exprContext e2;
		public Eq_neq_exprContext eq_neq_expr() {
			return getRuleContext(Eq_neq_exprContext.class,0);
		}
		public TerminalNode AND() { return getToken(DecaParser.AND, 0); }
		public And_exprContext and_expr() {
			return getRuleContext(And_exprContext.class,0);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
	}

	public final And_exprContext and_expr() throws RecognitionException {
		return and_expr(0);
	}

	private And_exprContext and_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		And_exprContext _localctx = new And_exprContext(_ctx, _parentState);
		And_exprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_and_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(302);
			((And_exprContext)_localctx).e = eq_neq_expr(0);

			            assert(((And_exprContext)_localctx).e.tree != null);
			            ((And_exprContext)_localctx).tree =  ((And_exprContext)_localctx).e.tree;
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(312);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_exprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_and_expr);
					setState(305);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(306);
					((And_exprContext)_localctx).AND = match(AND);
					setState(307);
					((And_exprContext)_localctx).e2 = eq_neq_expr(0);

					                      assert(((And_exprContext)_localctx).e1.tree != null);                         
					                      assert(((And_exprContext)_localctx).e2.tree != null);
					                      ((And_exprContext)_localctx).tree =  new And(((And_exprContext)_localctx).e1.tree, ((And_exprContext)_localctx).e2.tree);
					                      setLocation(_localctx.tree, ((And_exprContext)_localctx).AND);
					                  
					}
					} 
				}
				setState(314);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Eq_neq_exprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public Eq_neq_exprContext e1;
		public Inequality_exprContext e;
		public Token EQEQ;
		public Inequality_exprContext e2;
		public Token NEQ;
		public Inequality_exprContext inequality_expr() {
			return getRuleContext(Inequality_exprContext.class,0);
		}
		public TerminalNode EQEQ() { return getToken(DecaParser.EQEQ, 0); }
		public Eq_neq_exprContext eq_neq_expr() {
			return getRuleContext(Eq_neq_exprContext.class,0);
		}
		public TerminalNode NEQ() { return getToken(DecaParser.NEQ, 0); }
		public Eq_neq_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_neq_expr; }
	}

	public final Eq_neq_exprContext eq_neq_expr() throws RecognitionException {
		return eq_neq_expr(0);
	}

	private Eq_neq_exprContext eq_neq_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Eq_neq_exprContext _localctx = new Eq_neq_exprContext(_ctx, _parentState);
		Eq_neq_exprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_eq_neq_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(316);
			((Eq_neq_exprContext)_localctx).e = inequality_expr(0);

			            assert(((Eq_neq_exprContext)_localctx).e.tree != null);
			            ((Eq_neq_exprContext)_localctx).tree =  ((Eq_neq_exprContext)_localctx).e.tree;
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(331);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(329);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new Eq_neq_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_eq_neq_expr);
						setState(319);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(320);
						((Eq_neq_exprContext)_localctx).EQEQ = match(EQEQ);
						setState(321);
						((Eq_neq_exprContext)_localctx).e2 = inequality_expr(0);

						                      assert(((Eq_neq_exprContext)_localctx).e1.tree != null);
						                      assert(((Eq_neq_exprContext)_localctx).e2.tree != null);
						                      ((Eq_neq_exprContext)_localctx).tree =  new Equals(((Eq_neq_exprContext)_localctx).e1.tree, ((Eq_neq_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Eq_neq_exprContext)_localctx).EQEQ);
						                  
						}
						break;
					case 2:
						{
						_localctx = new Eq_neq_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_eq_neq_expr);
						setState(324);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(325);
						((Eq_neq_exprContext)_localctx).NEQ = match(NEQ);
						setState(326);
						((Eq_neq_exprContext)_localctx).e2 = inequality_expr(0);

						                      assert(((Eq_neq_exprContext)_localctx).e1.tree != null);
						                      assert(((Eq_neq_exprContext)_localctx).e2.tree != null);
						                      ((Eq_neq_exprContext)_localctx).tree =  new NotEquals(((Eq_neq_exprContext)_localctx).e1.tree, ((Eq_neq_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Eq_neq_exprContext)_localctx).NEQ);
						                  
						}
						break;
					}
					} 
				}
				setState(333);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Inequality_exprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public Inequality_exprContext e1;
		public Sum_exprContext e;
		public Token LEQ;
		public Sum_exprContext e2;
		public Token GEQ;
		public Token GT;
		public Token LT;
		public TypeContext type;
		public Sum_exprContext sum_expr() {
			return getRuleContext(Sum_exprContext.class,0);
		}
		public TerminalNode LEQ() { return getToken(DecaParser.LEQ, 0); }
		public Inequality_exprContext inequality_expr() {
			return getRuleContext(Inequality_exprContext.class,0);
		}
		public TerminalNode GEQ() { return getToken(DecaParser.GEQ, 0); }
		public TerminalNode GT() { return getToken(DecaParser.GT, 0); }
		public TerminalNode LT() { return getToken(DecaParser.LT, 0); }
		public TerminalNode INSTANCEOF() { return getToken(DecaParser.INSTANCEOF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Inequality_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inequality_expr; }
	}

	public final Inequality_exprContext inequality_expr() throws RecognitionException {
		return inequality_expr(0);
	}

	private Inequality_exprContext inequality_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Inequality_exprContext _localctx = new Inequality_exprContext(_ctx, _parentState);
		Inequality_exprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_inequality_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(335);
			((Inequality_exprContext)_localctx).e = sum_expr(0);

			            assert(((Inequality_exprContext)_localctx).e.tree != null);
			            ((Inequality_exprContext)_localctx).tree =  ((Inequality_exprContext)_localctx).e.tree;
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(363);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new Inequality_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inequality_expr);
						setState(338);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(339);
						((Inequality_exprContext)_localctx).LEQ = match(LEQ);
						setState(340);
						((Inequality_exprContext)_localctx).e2 = sum_expr(0);

						                      assert(((Inequality_exprContext)_localctx).e1.tree != null);
						                      assert(((Inequality_exprContext)_localctx).e2.tree != null);
						                      ((Inequality_exprContext)_localctx).tree =  new LowerOrEqual(((Inequality_exprContext)_localctx).e1.tree, ((Inequality_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Inequality_exprContext)_localctx).LEQ);
						                  
						}
						break;
					case 2:
						{
						_localctx = new Inequality_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inequality_expr);
						setState(343);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(344);
						((Inequality_exprContext)_localctx).GEQ = match(GEQ);
						setState(345);
						((Inequality_exprContext)_localctx).e2 = sum_expr(0);

						                      assert(((Inequality_exprContext)_localctx).e1.tree != null);
						                      assert(((Inequality_exprContext)_localctx).e2.tree != null);
						                      ((Inequality_exprContext)_localctx).tree =  new GreaterOrEqual(((Inequality_exprContext)_localctx).e1.tree, ((Inequality_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Inequality_exprContext)_localctx).GEQ);
						                  
						}
						break;
					case 3:
						{
						_localctx = new Inequality_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inequality_expr);
						setState(348);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(349);
						((Inequality_exprContext)_localctx).GT = match(GT);
						setState(350);
						((Inequality_exprContext)_localctx).e2 = sum_expr(0);

						                      assert(((Inequality_exprContext)_localctx).e1.tree != null);
						                      assert(((Inequality_exprContext)_localctx).e2.tree != null);
						                      ((Inequality_exprContext)_localctx).tree =  new Greater(((Inequality_exprContext)_localctx).e1.tree, ((Inequality_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Inequality_exprContext)_localctx).GT);
						                  
						}
						break;
					case 4:
						{
						_localctx = new Inequality_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inequality_expr);
						setState(353);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(354);
						((Inequality_exprContext)_localctx).LT = match(LT);
						setState(355);
						((Inequality_exprContext)_localctx).e2 = sum_expr(0);

						                      assert(((Inequality_exprContext)_localctx).e1.tree != null);
						                      assert(((Inequality_exprContext)_localctx).e2.tree != null);
						                      ((Inequality_exprContext)_localctx).tree =  new Lower(((Inequality_exprContext)_localctx).e1.tree, ((Inequality_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Inequality_exprContext)_localctx).LT);
						                  
						}
						break;
					case 5:
						{
						_localctx = new Inequality_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inequality_expr);
						setState(358);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(359);
						match(INSTANCEOF);
						setState(360);
						((Inequality_exprContext)_localctx).type = type();

						                      assert(((Inequality_exprContext)_localctx).e1.tree != null);
						                      assert(((Inequality_exprContext)_localctx).type.tree != null);
						                      ((Inequality_exprContext)_localctx).tree =  new InstanceOf(((Inequality_exprContext)_localctx).e1.tree, ((Inequality_exprContext)_localctx).type.tree);
						                      setLocation(_localctx.tree, (((Inequality_exprContext)_localctx).e1!=null?(((Inequality_exprContext)_localctx).e1.start):null));
						                  
						}
						break;
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Sum_exprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public Sum_exprContext e1;
		public Mult_exprContext e;
		public Token PLUS;
		public Mult_exprContext e2;
		public Token MINUS;
		public Mult_exprContext mult_expr() {
			return getRuleContext(Mult_exprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(DecaParser.PLUS, 0); }
		public Sum_exprContext sum_expr() {
			return getRuleContext(Sum_exprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(DecaParser.MINUS, 0); }
		public Sum_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum_expr; }
	}

	public final Sum_exprContext sum_expr() throws RecognitionException {
		return sum_expr(0);
	}

	private Sum_exprContext sum_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Sum_exprContext _localctx = new Sum_exprContext(_ctx, _parentState);
		Sum_exprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_sum_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(369);
			((Sum_exprContext)_localctx).e = mult_expr(0);

			            assert(((Sum_exprContext)_localctx).e.tree != null);
			            ((Sum_exprContext)_localctx).tree =  ((Sum_exprContext)_localctx).e.tree;
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(384);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(382);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new Sum_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_sum_expr);
						setState(372);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(373);
						((Sum_exprContext)_localctx).PLUS = match(PLUS);
						setState(374);
						((Sum_exprContext)_localctx).e2 = mult_expr(0);

						                      assert(((Sum_exprContext)_localctx).e1.tree != null);
						                      assert(((Sum_exprContext)_localctx).e2.tree != null);
						                      ((Sum_exprContext)_localctx).tree =  new Plus(((Sum_exprContext)_localctx).e1.tree, ((Sum_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Sum_exprContext)_localctx).PLUS);
						                  
						}
						break;
					case 2:
						{
						_localctx = new Sum_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_sum_expr);
						setState(377);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(378);
						((Sum_exprContext)_localctx).MINUS = match(MINUS);
						setState(379);
						((Sum_exprContext)_localctx).e2 = mult_expr(0);

						                      assert(((Sum_exprContext)_localctx).e1.tree != null);
						                      assert(((Sum_exprContext)_localctx).e2.tree != null);
						                      ((Sum_exprContext)_localctx).tree =  new Minus(((Sum_exprContext)_localctx).e1.tree, ((Sum_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Sum_exprContext)_localctx).MINUS);
						                  
						}
						break;
					}
					} 
				}
				setState(386);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Mult_exprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public Mult_exprContext e1;
		public Unary_exprContext e;
		public Token TIMES;
		public Unary_exprContext e2;
		public Token SLASH;
		public Token PERCENT;
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public TerminalNode TIMES() { return getToken(DecaParser.TIMES, 0); }
		public Mult_exprContext mult_expr() {
			return getRuleContext(Mult_exprContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(DecaParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(DecaParser.PERCENT, 0); }
		public Mult_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_expr; }
	}

	public final Mult_exprContext mult_expr() throws RecognitionException {
		return mult_expr(0);
	}

	private Mult_exprContext mult_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Mult_exprContext _localctx = new Mult_exprContext(_ctx, _parentState);
		Mult_exprContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_mult_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(388);
			((Mult_exprContext)_localctx).e = unary_expr();

			            assert(((Mult_exprContext)_localctx).e.tree != null);
			            ((Mult_exprContext)_localctx).tree =  ((Mult_exprContext)_localctx).e.tree;
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(408);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(406);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new Mult_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_mult_expr);
						setState(391);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(392);
						((Mult_exprContext)_localctx).TIMES = match(TIMES);
						setState(393);
						((Mult_exprContext)_localctx).e2 = unary_expr();

						                      assert(((Mult_exprContext)_localctx).e1.tree != null);                                         
						                      assert(((Mult_exprContext)_localctx).e2.tree != null);
						                      ((Mult_exprContext)_localctx).tree =  new Multiply(((Mult_exprContext)_localctx).e1.tree, ((Mult_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Mult_exprContext)_localctx).TIMES);
						                  
						}
						break;
					case 2:
						{
						_localctx = new Mult_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_mult_expr);
						setState(396);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(397);
						((Mult_exprContext)_localctx).SLASH = match(SLASH);
						setState(398);
						((Mult_exprContext)_localctx).e2 = unary_expr();

						                      assert(((Mult_exprContext)_localctx).e1.tree != null);                                         
						                      assert(((Mult_exprContext)_localctx).e2.tree != null);
						                      ((Mult_exprContext)_localctx).tree =  new Divide(((Mult_exprContext)_localctx).e1.tree, ((Mult_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Mult_exprContext)_localctx).SLASH);
						                  
						}
						break;
					case 3:
						{
						_localctx = new Mult_exprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_mult_expr);
						setState(401);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(402);
						((Mult_exprContext)_localctx).PERCENT = match(PERCENT);
						setState(403);
						((Mult_exprContext)_localctx).e2 = unary_expr();

						                      assert(((Mult_exprContext)_localctx).e1.tree != null);                                                                          
						                      assert(((Mult_exprContext)_localctx).e2.tree != null);
						                      ((Mult_exprContext)_localctx).tree =  new Modulo(((Mult_exprContext)_localctx).e1.tree, ((Mult_exprContext)_localctx).e2.tree);
						                      setLocation(_localctx.tree, ((Mult_exprContext)_localctx).PERCENT);
						                  
						}
						break;
					}
					} 
				}
				setState(410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Unary_exprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public Token op;
		public Unary_exprContext e;
		public Select_exprContext select_expr;
		public TerminalNode MINUS() { return getToken(DecaParser.MINUS, 0); }
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public TerminalNode EXCLAM() { return getToken(DecaParser.EXCLAM, 0); }
		public Select_exprContext select_expr() {
			return getRuleContext(Select_exprContext.class,0);
		}
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_unary_expr);
		try {
			setState(422);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				((Unary_exprContext)_localctx).op = match(MINUS);
				setState(412);
				((Unary_exprContext)_localctx).e = unary_expr();

				            assert(((Unary_exprContext)_localctx).e.tree != null);
				            ((Unary_exprContext)_localctx).tree =  new UnaryMinus(((Unary_exprContext)_localctx).e.tree);
				            setLocation(_localctx.tree, ((Unary_exprContext)_localctx).op);
				        
				}
				break;
			case EXCLAM:
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				((Unary_exprContext)_localctx).op = match(EXCLAM);
				setState(416);
				((Unary_exprContext)_localctx).e = unary_expr();

				            assert(((Unary_exprContext)_localctx).e.tree != null);
				            ((Unary_exprContext)_localctx).tree =  new Not(((Unary_exprContext)_localctx).e.tree);
				            setLocation(_localctx.tree, ((Unary_exprContext)_localctx).op);
				        
				}
				break;
			case FALSE:
			case NEW:
			case NULL:
			case READINT:
			case READFLOAT:
			case THIS:
			case TRUE:
			case IDENT:
			case OPARENT:
			case INT:
			case FLOAT:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(419);
				((Unary_exprContext)_localctx).select_expr = select_expr(0);

				            assert(((Unary_exprContext)_localctx).select_expr.tree != null);
				            ((Unary_exprContext)_localctx).tree =  ((Unary_exprContext)_localctx).select_expr.tree;
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_exprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public Select_exprContext e1;
		public Primary_exprContext e;
		public IdentContext i;
		public Token o;
		public List_exprContext args;
		public Primary_exprContext primary_expr() {
			return getRuleContext(Primary_exprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(DecaParser.DOT, 0); }
		public Select_exprContext select_expr() {
			return getRuleContext(Select_exprContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode CPARENT() { return getToken(DecaParser.CPARENT, 0); }
		public TerminalNode OPARENT() { return getToken(DecaParser.OPARENT, 0); }
		public List_exprContext list_expr() {
			return getRuleContext(List_exprContext.class,0);
		}
		public Select_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_expr; }
	}

	public final Select_exprContext select_expr() throws RecognitionException {
		return select_expr(0);
	}

	private Select_exprContext select_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Select_exprContext _localctx = new Select_exprContext(_ctx, _parentState);
		Select_exprContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_select_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(425);
			((Select_exprContext)_localctx).e = primary_expr();

			            assert(((Select_exprContext)_localctx).e.tree != null);
			            ((Select_exprContext)_localctx).tree =  ((Select_exprContext)_localctx).e.tree;
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(442);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Select_exprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_select_expr);
					setState(428);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(429);
					match(DOT);
					setState(430);
					((Select_exprContext)_localctx).i = ident();

					                      assert(((Select_exprContext)_localctx).e1.tree != null);
					                      assert(((Select_exprContext)_localctx).i.tree != null);
					                  
					setState(438);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						setState(432);
						((Select_exprContext)_localctx).o = match(OPARENT);
						setState(433);
						((Select_exprContext)_localctx).args = list_expr();
						setState(434);
						match(CPARENT);

						                      // we matched "e1.i(args)"
						                      assert(((Select_exprContext)_localctx).args.tree != null);
						                      ((Select_exprContext)_localctx).tree =  new MethodCall(((Select_exprContext)_localctx).i.tree, ((Select_exprContext)_localctx).args.tree, ((Select_exprContext)_localctx).e1.tree);
						                      setLocation(_localctx.tree, (((Select_exprContext)_localctx).e1!=null?(((Select_exprContext)_localctx).e1.start):null));
						                  
						}
						break;
					case 2:
						{

						                      // we matched "e.i"
						                      ((Select_exprContext)_localctx).tree =  new DotIdentifier(((Select_exprContext)_localctx).e1.tree, ((Select_exprContext)_localctx).i.tree);
						                      setLocation(_localctx.tree, (((Select_exprContext)_localctx).e1!=null?(((Select_exprContext)_localctx).e1.start):null));
						                  
						}
						break;
					}
					}
					} 
				}
				setState(444);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Primary_exprContext extends ParserRuleContext {
		public AbstractExpr tree;
		public IdentContext ident;
		public IdentContext m;
		public List_exprContext args;
		public ExprContext expr;
		public Token READINT;
		public Token READFLOAT;
		public Token NEW;
		public Token cast;
		public TypeContext type;
		public LiteralContext literal;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<TerminalNode> OPARENT() { return getTokens(DecaParser.OPARENT); }
		public TerminalNode OPARENT(int i) {
			return getToken(DecaParser.OPARENT, i);
		}
		public List<TerminalNode> CPARENT() { return getTokens(DecaParser.CPARENT); }
		public TerminalNode CPARENT(int i) {
			return getToken(DecaParser.CPARENT, i);
		}
		public List_exprContext list_expr() {
			return getRuleContext(List_exprContext.class,0);
		}
		public TerminalNode OBRACKET() { return getToken(DecaParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(DecaParser.CBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode READINT() { return getToken(DecaParser.READINT, 0); }
		public TerminalNode READFLOAT() { return getToken(DecaParser.READFLOAT, 0); }
		public TerminalNode NEW() { return getToken(DecaParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Primary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expr; }
	}

	public final Primary_exprContext primary_expr() throws RecognitionException {
		Primary_exprContext _localctx = new Primary_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_primary_expr);
		try {
			setState(490);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(445);
				((Primary_exprContext)_localctx).ident = ident();

				            assert(((Primary_exprContext)_localctx).ident.tree != null);
				            ((Primary_exprContext)_localctx).tree =  ((Primary_exprContext)_localctx).ident.tree;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(448);
				((Primary_exprContext)_localctx).m = ident();
				setState(449);
				match(OPARENT);
				setState(450);
				((Primary_exprContext)_localctx).args = list_expr();
				setState(451);
				match(CPARENT);

				            assert(((Primary_exprContext)_localctx).args.tree != null);
				            assert(((Primary_exprContext)_localctx).m.tree != null);
				            ((Primary_exprContext)_localctx).tree =  new MethodCall(((Primary_exprContext)_localctx).m.tree, ((Primary_exprContext)_localctx).args.tree, null);
				            setLocation(_localctx.tree, (((Primary_exprContext)_localctx).m!=null?(((Primary_exprContext)_localctx).m.start):null));
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(454);
				((Primary_exprContext)_localctx).m = ident();
				setState(455);
				match(OBRACKET);
				setState(456);
				((Primary_exprContext)_localctx).args = list_expr();
				setState(457);
				match(CBRACKET);

				            assert(((Primary_exprContext)_localctx).args.tree != null);
				            assert(((Primary_exprContext)_localctx).m.tree != null);
				            ((Primary_exprContext)_localctx).tree =  new MatrixCall(((Primary_exprContext)_localctx).m.tree, ((Primary_exprContext)_localctx).args.tree);
				            setLocation(_localctx.tree, (((Primary_exprContext)_localctx).m!=null?(((Primary_exprContext)_localctx).m.start):null));
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(460);
				match(OPARENT);
				setState(461);
				((Primary_exprContext)_localctx).expr = expr();
				setState(462);
				match(CPARENT);

				            assert(((Primary_exprContext)_localctx).expr.tree != null);
				            ((Primary_exprContext)_localctx).tree =  ((Primary_exprContext)_localctx).expr.tree;
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(465);
				((Primary_exprContext)_localctx).READINT = match(READINT);
				setState(466);
				match(OPARENT);
				setState(467);
				match(CPARENT);

				            ((Primary_exprContext)_localctx).tree =  new ReadInt();
				            setLocation(_localctx.tree, ((Primary_exprContext)_localctx).READINT);
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(469);
				((Primary_exprContext)_localctx).READFLOAT = match(READFLOAT);
				setState(470);
				match(OPARENT);
				setState(471);
				match(CPARENT);

				            ((Primary_exprContext)_localctx).tree =  new ReadFloat();
				            setLocation(_localctx.tree, ((Primary_exprContext)_localctx).READFLOAT);
				        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(473);
				((Primary_exprContext)_localctx).NEW = match(NEW);
				setState(474);
				((Primary_exprContext)_localctx).ident = ident();
				setState(475);
				match(OPARENT);
				setState(476);
				match(CPARENT);

				            assert(((Primary_exprContext)_localctx).ident.tree != null);
				            ((Primary_exprContext)_localctx).tree =  new New(((Primary_exprContext)_localctx).ident.tree);
				            setLocation(_localctx.tree, ((Primary_exprContext)_localctx).NEW);
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(479);
				((Primary_exprContext)_localctx).cast = match(OPARENT);
				setState(480);
				((Primary_exprContext)_localctx).type = type();
				setState(481);
				match(CPARENT);
				setState(482);
				match(OPARENT);
				setState(483);
				((Primary_exprContext)_localctx).expr = expr();
				setState(484);
				match(CPARENT);

				            assert(((Primary_exprContext)_localctx).type.tree != null);
				            assert(((Primary_exprContext)_localctx).expr.tree != null);
				            ((Primary_exprContext)_localctx).tree =  new Cast(((Primary_exprContext)_localctx).expr.tree, ((Primary_exprContext)_localctx).type.tree);
				            setLocation(_localctx.tree, ((Primary_exprContext)_localctx).cast);
				        
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(487);
				((Primary_exprContext)_localctx).literal = literal();

				            assert(((Primary_exprContext)_localctx).literal.tree != null);
				            ((Primary_exprContext)_localctx).tree =  ((Primary_exprContext)_localctx).literal.tree;
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public AbstractIdentifier tree;
		public IdentContext ident;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			((TypeContext)_localctx).ident = ident();

			            assert(((TypeContext)_localctx).ident.tree != null);
			            ((TypeContext)_localctx).tree =  ((TypeContext)_localctx).ident.tree;
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Matrix_typeContext extends ParserRuleContext {
		public AbstractIdentifier tree;
		public Matrix_identContext matrix_ident;
		public Matrix_identContext matrix_ident() {
			return getRuleContext(Matrix_identContext.class,0);
		}
		public Matrix_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix_type; }
	}

	public final Matrix_typeContext matrix_type() throws RecognitionException {
		Matrix_typeContext _localctx = new Matrix_typeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_matrix_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			((Matrix_typeContext)_localctx).matrix_ident = matrix_ident();

			            assert(((Matrix_typeContext)_localctx).matrix_ident.tree != null);
			            ((Matrix_typeContext)_localctx).tree =  ((Matrix_typeContext)_localctx).matrix_ident.tree;
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public AbstractExpr tree;
		public Token INT;
		public Token fd;
		public Token STRING;
		public Token TRUE;
		public Token FALSE;
		public Token THIS;
		public Token NULL;
		public TerminalNode INT() { return getToken(DecaParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(DecaParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(DecaParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(DecaParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(DecaParser.FALSE, 0); }
		public TerminalNode THIS() { return getToken(DecaParser.THIS, 0); }
		public TerminalNode NULL() { return getToken(DecaParser.NULL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_literal);
		try {
			setState(512);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(498);
				((LiteralContext)_localctx).INT = match(INT);

				        try {
				            ((LiteralContext)_localctx).tree =  new IntLiteral(Integer.parseInt((((LiteralContext)_localctx).INT!=null?((LiteralContext)_localctx).INT.getText():null)));
				            setLocation(_localctx.tree, ((LiteralContext)_localctx).INT);
				        } catch (NumberFormatException e) {
				            throw new IntTooLarge(this, _localctx);
				        }
				        
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				((LiteralContext)_localctx).fd = match(FLOAT);

				        try {
				            ((LiteralContext)_localctx).tree =  new FloatLiteral(Float.parseFloat((((LiteralContext)_localctx).fd!=null?((LiteralContext)_localctx).fd.getText():null)));
				            setLocation(_localctx.tree, ((LiteralContext)_localctx).fd);
				        } catch (IllegalArgumentException e) {
				            throw new FloatTooLarge(this, _localctx);
				        }
				        
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(502);
				((LiteralContext)_localctx).STRING = match(STRING);

				        String input = (((LiteralContext)_localctx).STRING!=null?((LiteralContext)_localctx).STRING.getText():null).substring(1,(((LiteralContext)_localctx).STRING!=null?((LiteralContext)_localctx).STRING.getText():null).length()-1);
				        for (int i = 0; i < input.length() - 1; i++) {
				            if ((input.charAt(i) == '\\') && (input.charAt(i + 1) == '\"')) {
				                input = input.substring(0, i) + input.substring(i+1);
				            }
				        }
				        ((LiteralContext)_localctx).tree =  new StringLiteral(input);
				        setLocation(_localctx.tree, ((LiteralContext)_localctx).STRING);
				        
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(504);
				((LiteralContext)_localctx).TRUE = match(TRUE);

				        ((LiteralContext)_localctx).tree =  new BooleanLiteral(true);
				        setLocation(_localctx.tree, ((LiteralContext)_localctx).TRUE);
				        
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(506);
				((LiteralContext)_localctx).FALSE = match(FALSE);

				        ((LiteralContext)_localctx).tree =  new BooleanLiteral(false);
				        setLocation(_localctx.tree, ((LiteralContext)_localctx).FALSE);
				        
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 6);
				{
				setState(508);
				((LiteralContext)_localctx).THIS = match(THIS);

				        ((LiteralContext)_localctx).tree =  new This();
				        setLocation(_localctx.tree, ((LiteralContext)_localctx).THIS);
				        
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 7);
				{
				setState(510);
				((LiteralContext)_localctx).NULL = match(NULL);

				        ((LiteralContext)_localctx).tree =  new Null();
				        setLocation(_localctx.tree, ((LiteralContext)_localctx).NULL);
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public AbstractIdentifier tree;
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(DecaParser.IDENT, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			((IdentContext)_localctx).IDENT = match(IDENT);

			        ((IdentContext)_localctx).tree =  new Identifier(symbols.create((((IdentContext)_localctx).IDENT!=null?((IdentContext)_localctx).IDENT.getText():null)));
			        setLocation(_localctx.tree, ((IdentContext)_localctx).IDENT);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Matrix_identContext extends ParserRuleContext {
		public AbstractIdentifier tree;
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(DecaParser.IDENT, 0); }
		public Matrix_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix_ident; }
	}

	public final Matrix_identContext matrix_ident() throws RecognitionException {
		Matrix_identContext _localctx = new Matrix_identContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_matrix_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			((Matrix_identContext)_localctx).IDENT = match(IDENT);

			        ((Matrix_identContext)_localctx).tree =  new Identifier(symbols.create((((Matrix_identContext)_localctx).IDENT!=null?((Matrix_identContext)_localctx).IDENT.getText():null) + "[]"));
			        setLocation(_localctx.tree, ((Matrix_identContext)_localctx).IDENT);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_classesContext extends ParserRuleContext {
		public ListDeclClass tree;
		public Class_declContext c1;
		public List<Class_declContext> class_decl() {
			return getRuleContexts(Class_declContext.class);
		}
		public Class_declContext class_decl(int i) {
			return getRuleContext(Class_declContext.class,i);
		}
		public List_classesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_classes; }
	}

	public final List_classesContext list_classes() throws RecognitionException {
		List_classesContext _localctx = new List_classesContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_list_classes);

		        ((List_classesContext)_localctx).tree =  new ListDeclClass();
		    
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(520);
				((List_classesContext)_localctx).c1 = class_decl();

				          assert(((List_classesContext)_localctx).c1.tree != null);
				          _localctx.tree.add(((List_classesContext)_localctx).c1.tree);
				        
				}
				}
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_declContext extends ParserRuleContext {
		public DeclClass tree;
		public Token CLASS;
		public IdentContext name;
		public Class_extensionContext superclass;
		public Class_bodyContext class_body;
		public TerminalNode CLASS() { return getToken(DecaParser.CLASS, 0); }
		public TerminalNode OBRACE() { return getToken(DecaParser.OBRACE, 0); }
		public Class_bodyContext class_body() {
			return getRuleContext(Class_bodyContext.class,0);
		}
		public TerminalNode CBRACE() { return getToken(DecaParser.CBRACE, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Class_extensionContext class_extension() {
			return getRuleContext(Class_extensionContext.class,0);
		}
		public Class_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_decl; }
	}

	public final Class_declContext class_decl() throws RecognitionException {
		Class_declContext _localctx = new Class_declContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_class_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			((Class_declContext)_localctx).CLASS = match(CLASS);
			setState(529);
			((Class_declContext)_localctx).name = ident();
			setState(530);
			((Class_declContext)_localctx).superclass = class_extension(((Class_declContext)_localctx).CLASS);
			setState(531);
			match(OBRACE);
			setState(532);
			((Class_declContext)_localctx).class_body = class_body();
			setState(533);
			match(CBRACE);

			        assert(((Class_declContext)_localctx).name.tree != null);
			        assert(((Class_declContext)_localctx).superclass.tree != null);
			        assert(((Class_declContext)_localctx).class_body.methods != null);
			        assert(((Class_declContext)_localctx).class_body.fields != null);

			        ((Class_declContext)_localctx).tree =  new DeclClass(((Class_declContext)_localctx).name.tree, ((Class_declContext)_localctx).superclass.tree, ((Class_declContext)_localctx).class_body.methods, ((Class_declContext)_localctx).class_body.fields);
			        setLocation(_localctx.tree, ((Class_declContext)_localctx).CLASS);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_extensionContext extends ParserRuleContext {
		public Token _class;
		public AbstractIdentifier tree;
		public IdentContext ident;
		public TerminalNode EXTENDS() { return getToken(DecaParser.EXTENDS, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Class_extensionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Class_extensionContext(ParserRuleContext parent, int invokingState, Token _class) {
			super(parent, invokingState);
			this._class = _class;
		}
		@Override public int getRuleIndex() { return RULE_class_extension; }
	}

	public final Class_extensionContext class_extension(Token _class) throws RecognitionException {
		Class_extensionContext _localctx = new Class_extensionContext(_ctx, getState(), _class);
		enterRule(_localctx, 62, RULE_class_extension);
		try {
			setState(541);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				match(EXTENDS);
				setState(537);
				((Class_extensionContext)_localctx).ident = ident();

				        assert(((Class_extensionContext)_localctx).ident.tree != null);
				        ((Class_extensionContext)_localctx).tree =  ((Class_extensionContext)_localctx).ident.tree;
				        
				}
				break;
			case OBRACE:
				enterOuterAlt(_localctx, 2);
				{

				        ((Class_extensionContext)_localctx).tree =  new Identifier(symbols.create("Object"));
				        setLocation(_localctx.tree, _localctx._class);
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_bodyContext extends ParserRuleContext {
		public ListDeclMethod methods;
		public ListDeclField fields;
		public Decl_methodContext m;
		public List<Decl_field_setContext> decl_field_set() {
			return getRuleContexts(Decl_field_setContext.class);
		}
		public Decl_field_setContext decl_field_set(int i) {
			return getRuleContext(Decl_field_setContext.class,i);
		}
		public List<Decl_methodContext> decl_method() {
			return getRuleContexts(Decl_methodContext.class);
		}
		public Decl_methodContext decl_method(int i) {
			return getRuleContext(Decl_methodContext.class,i);
		}
		public Class_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_body; }
	}

	public final Class_bodyContext class_body() throws RecognitionException {
		Class_bodyContext _localctx = new Class_bodyContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_class_body);

		    ((Class_bodyContext)_localctx).methods =  new ListDeclMethod();
		    ((Class_bodyContext)_localctx).fields =  new ListDeclField();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROTECTED || _la==IDENT) {
				{
				setState(547);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(543);
					((Class_bodyContext)_localctx).m = decl_method();

					        assert(((Class_bodyContext)_localctx).m.tree != null);
					        _localctx.methods.add(((Class_bodyContext)_localctx).m.tree);
					    
					}
					break;
				case 2:
					{
					setState(546);
					decl_field_set(_localctx.fields);
					}
					break;
				}
				}
				setState(551);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_field_setContext extends ParserRuleContext {
		public ListDeclField fields;
		public VisibilityContext v;
		public TypeContext t;
		public Matrix_typeContext matrix_type;
		public List_decl_fieldContext list_decl_field() {
			return getRuleContext(List_decl_fieldContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(DecaParser.SEMI, 0); }
		public VisibilityContext visibility() {
			return getRuleContext(VisibilityContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Matrix_typeContext matrix_type() {
			return getRuleContext(Matrix_typeContext.class,0);
		}
		public List_decl_matrix_fieldContext list_decl_matrix_field() {
			return getRuleContext(List_decl_matrix_fieldContext.class,0);
		}
		public Decl_field_setContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Decl_field_setContext(ParserRuleContext parent, int invokingState, ListDeclField fields) {
			super(parent, invokingState);
			this.fields = fields;
		}
		@Override public int getRuleIndex() { return RULE_decl_field_set; }
	}

	public final Decl_field_setContext decl_field_set(ListDeclField fields) throws RecognitionException {
		Decl_field_setContext _localctx = new Decl_field_setContext(_ctx, getState(), fields);
		enterRule(_localctx, 66, RULE_decl_field_set);
		try {
			setState(562);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(552);
				((Decl_field_setContext)_localctx).v = visibility();
				setState(553);
				((Decl_field_setContext)_localctx).t = type();
				setState(554);
				list_decl_field(_localctx.fields, ((Decl_field_setContext)_localctx).v.tree, ((Decl_field_setContext)_localctx).t.tree);
				setState(555);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(557);
				((Decl_field_setContext)_localctx).v = visibility();
				setState(558);
				((Decl_field_setContext)_localctx).matrix_type = matrix_type();
				setState(559);
				list_decl_matrix_field(_localctx.fields, ((Decl_field_setContext)_localctx).v.tree, ((Decl_field_setContext)_localctx).matrix_type.tree);
				setState(560);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_decl_matrix_fieldContext extends ParserRuleContext {
		public ListDeclField l;
		public Visibility v;
		public AbstractIdentifier t;
		public Decl_matrix_fieldContext dv1;
		public Decl_matrix_fieldContext dv2;
		public List<Decl_matrix_fieldContext> decl_matrix_field() {
			return getRuleContexts(Decl_matrix_fieldContext.class);
		}
		public Decl_matrix_fieldContext decl_matrix_field(int i) {
			return getRuleContext(Decl_matrix_fieldContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecaParser.COMMA, i);
		}
		public List_decl_matrix_fieldContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public List_decl_matrix_fieldContext(ParserRuleContext parent, int invokingState, ListDeclField l, Visibility v, AbstractIdentifier t) {
			super(parent, invokingState);
			this.l = l;
			this.v = v;
			this.t = t;
		}
		@Override public int getRuleIndex() { return RULE_list_decl_matrix_field; }
	}

	public final List_decl_matrix_fieldContext list_decl_matrix_field(ListDeclField l,Visibility v,AbstractIdentifier t) throws RecognitionException {
		List_decl_matrix_fieldContext _localctx = new List_decl_matrix_fieldContext(_ctx, getState(), l, v, t);
		enterRule(_localctx, 68, RULE_list_decl_matrix_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			((List_decl_matrix_fieldContext)_localctx).dv1 = decl_matrix_field(_localctx.t, _localctx.v);

			            _localctx.l.add(((List_decl_matrix_fieldContext)_localctx).dv1.tree);
			            
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(566);
				match(COMMA);
				setState(567);
				((List_decl_matrix_fieldContext)_localctx).dv2 = decl_matrix_field(_localctx.t, _localctx.v);

				                _localctx.l.add(((List_decl_matrix_fieldContext)_localctx).dv2.tree);
				            
				}
				}
				setState(574);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_matrix_fieldContext extends ParserRuleContext {
		public AbstractIdentifier t;
		public Visibility v;
		public AbstractDeclField tree;
		public List_exprContext size;
		public IdentContext name;
		public TerminalNode OBRACKET() { return getToken(DecaParser.OBRACKET, 0); }
		public TerminalNode CBRACKET() { return getToken(DecaParser.CBRACKET, 0); }
		public List_exprContext list_expr() {
			return getRuleContext(List_exprContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Decl_matrix_fieldContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Decl_matrix_fieldContext(ParserRuleContext parent, int invokingState, AbstractIdentifier t, Visibility v) {
			super(parent, invokingState);
			this.t = t;
			this.v = v;
		}
		@Override public int getRuleIndex() { return RULE_decl_matrix_field; }
	}

	public final Decl_matrix_fieldContext decl_matrix_field(AbstractIdentifier t,Visibility v) throws RecognitionException {
		Decl_matrix_fieldContext _localctx = new Decl_matrix_fieldContext(_ctx, getState(), t, v);
		enterRule(_localctx, 70, RULE_decl_matrix_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			match(OBRACKET);
			setState(576);
			((Decl_matrix_fieldContext)_localctx).size = list_expr();
			setState(577);
			match(CBRACKET);
			setState(578);
			((Decl_matrix_fieldContext)_localctx).name = ident();

			        assert(((Decl_matrix_fieldContext)_localctx).name.tree != null);
			        assert(((Decl_matrix_fieldContext)_localctx).size.tree != null);
			        ((Decl_matrix_fieldContext)_localctx).tree =  new DeclMatrixField(t, ((Decl_matrix_fieldContext)_localctx).size.tree, ((Decl_matrix_fieldContext)_localctx).name.tree, new NoInitialization(), _localctx.v);
			        setLocation(_localctx.tree, (((Decl_matrix_fieldContext)_localctx).name!=null?(((Decl_matrix_fieldContext)_localctx).name.start):null));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VisibilityContext extends ParserRuleContext {
		public Visibility tree;
		public TerminalNode PROTECTED() { return getToken(DecaParser.PROTECTED, 0); }
		public VisibilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibility; }
	}

	public final VisibilityContext visibility() throws RecognitionException {
		VisibilityContext _localctx = new VisibilityContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_visibility);
		try {
			setState(584);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{

				        ((VisibilityContext)_localctx).tree =  Visibility.PUBLIC;
				        
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 2);
				{
				setState(582);
				match(PROTECTED);

				        ((VisibilityContext)_localctx).tree =  Visibility.PROTECTED;
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_decl_fieldContext extends ParserRuleContext {
		public ListDeclField fields;
		public Visibility _v;
		public AbstractIdentifier _type;
		public Decl_fieldContext dv1;
		public Decl_fieldContext dv2;
		public List<Decl_fieldContext> decl_field() {
			return getRuleContexts(Decl_fieldContext.class);
		}
		public Decl_fieldContext decl_field(int i) {
			return getRuleContext(Decl_fieldContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecaParser.COMMA, i);
		}
		public List_decl_fieldContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public List_decl_fieldContext(ParserRuleContext parent, int invokingState, ListDeclField fields, Visibility _v, AbstractIdentifier _type) {
			super(parent, invokingState);
			this.fields = fields;
			this._v = _v;
			this._type = _type;
		}
		@Override public int getRuleIndex() { return RULE_list_decl_field; }
	}

	public final List_decl_fieldContext list_decl_field(ListDeclField fields,Visibility _v,AbstractIdentifier _type) throws RecognitionException {
		List_decl_fieldContext _localctx = new List_decl_fieldContext(_ctx, getState(), fields, _v, _type);
		enterRule(_localctx, 74, RULE_list_decl_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			((List_decl_fieldContext)_localctx).dv1 = decl_field(_localctx._v, _localctx._type);

			        fields.add(((List_decl_fieldContext)_localctx).dv1.tree);
			    
			setState(594);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(588);
				match(COMMA);
				setState(589);
				((List_decl_fieldContext)_localctx).dv2 = decl_field(_localctx._v, _localctx._type);

				            fields.add(((List_decl_fieldContext)_localctx).dv2.tree);
				        
				}
				}
				setState(596);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_fieldContext extends ParserRuleContext {
		public Visibility _v;
		public AbstractIdentifier _type;
		public AbstractDeclField tree;
		public IdentContext i;
		public ExprContext e;
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(DecaParser.EQUALS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Decl_fieldContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Decl_fieldContext(ParserRuleContext parent, int invokingState, Visibility _v, AbstractIdentifier _type) {
			super(parent, invokingState);
			this._v = _v;
			this._type = _type;
		}
		@Override public int getRuleIndex() { return RULE_decl_field; }
	}

	public final Decl_fieldContext decl_field(Visibility _v,AbstractIdentifier _type) throws RecognitionException {
		Decl_fieldContext _localctx = new Decl_fieldContext(_ctx, getState(), _v, _type);
		enterRule(_localctx, 76, RULE_decl_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			((Decl_fieldContext)_localctx).i = ident();

			            Initialization initialization;

			            boolean isInitialize = false;
			        
			        
			setState(603);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALS) {
				{
				setState(599);
				match(EQUALS);
				setState(600);
				((Decl_fieldContext)_localctx).e = expr();

				            assert(((Decl_fieldContext)_localctx).e.tree != null);
				            initialization = new Initialization(((Decl_fieldContext)_localctx).e.tree);
				            setLocation(initialization, (((Decl_fieldContext)_localctx).e!=null?(((Decl_fieldContext)_localctx).e.start):null));
				            ((Decl_fieldContext)_localctx).tree =  new DeclField(_localctx._v, _localctx._type, ((Decl_fieldContext)_localctx).i.tree, initialization);
				            isInitialize = true;
				        
				}
			}


			          if (!isInitialize) ((Decl_fieldContext)_localctx).tree =  new DeclField(_localctx._v, _localctx._type, ((Decl_fieldContext)_localctx).i.tree, new NoInitialization());
			      

			          setLocation(_localctx.tree, (((Decl_fieldContext)_localctx).i!=null?(((Decl_fieldContext)_localctx).i.start):null));
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_methodContext extends ParserRuleContext {
		public AbstractDeclMethod tree;
		public TypeContext type;
		public IdentContext ident;
		public List_paramsContext params;
		public BlockContext block;
		public Multi_line_stringContext code;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<TerminalNode> OPARENT() { return getTokens(DecaParser.OPARENT); }
		public TerminalNode OPARENT(int i) {
			return getToken(DecaParser.OPARENT, i);
		}
		public List<TerminalNode> CPARENT() { return getTokens(DecaParser.CPARENT); }
		public TerminalNode CPARENT(int i) {
			return getToken(DecaParser.CPARENT, i);
		}
		public List_paramsContext list_params() {
			return getRuleContext(List_paramsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ASM() { return getToken(DecaParser.ASM, 0); }
		public TerminalNode SEMI() { return getToken(DecaParser.SEMI, 0); }
		public Multi_line_stringContext multi_line_string() {
			return getRuleContext(Multi_line_stringContext.class,0);
		}
		public Decl_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_method; }
	}

	public final Decl_methodContext decl_method() throws RecognitionException {
		Decl_methodContext _localctx = new Decl_methodContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_decl_method);

		    AbstractMethodBody methodBody;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			((Decl_methodContext)_localctx).type = type();
			setState(609);
			((Decl_methodContext)_localctx).ident = ident();
			setState(610);
			match(OPARENT);
			setState(611);
			((Decl_methodContext)_localctx).params = list_params();
			setState(612);
			match(CPARENT);
			setState(623);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBRACE:
				{
				setState(613);
				((Decl_methodContext)_localctx).block = block();

				        assert(((Decl_methodContext)_localctx).block.decls != null);
				        assert(((Decl_methodContext)_localctx).block.insts != null);
				        methodBody = new MethodBody(((Decl_methodContext)_localctx).block.decls, ((Decl_methodContext)_localctx).block.insts);
				        setLocation(methodBody, (((Decl_methodContext)_localctx).block!=null?(((Decl_methodContext)_localctx).block.start):null));
				        
				}
				break;
			case ASM:
				{
				setState(616);
				match(ASM);
				setState(617);
				match(OPARENT);
				setState(618);
				((Decl_methodContext)_localctx).code = multi_line_string();
				setState(619);
				match(CPARENT);
				setState(620);
				match(SEMI);

				          String _codeString = ((Decl_methodContext)_localctx).code.text.substring(1,((Decl_methodContext)_localctx).code.text.length()-1);
				        for (int i = 0; i < _codeString.length() - 1; i++) {
				            if ((_codeString.charAt(i) == '\\') && (_codeString.charAt(i + 1) == '\"')) {
				                _codeString = _codeString.substring(0, i) + _codeString.substring(i+1);
				            }
				        }
				        StringLiteral _code = new StringLiteral(_codeString);
				        methodBody = new AsmMethodBody(_code);
				        methodBody.setLocation(((Decl_methodContext)_localctx).code.location);
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			            assert(((Decl_methodContext)_localctx).type.tree != null);
			            assert(((Decl_methodContext)_localctx).ident.tree != null);
			            assert(((Decl_methodContext)_localctx).params.tree != null);
			            ((Decl_methodContext)_localctx).tree =  new DeclMethod(((Decl_methodContext)_localctx).type.tree, ((Decl_methodContext)_localctx).ident.tree, ((Decl_methodContext)_localctx).params.tree, methodBody);
			            setLocation(_localctx.tree, (((Decl_methodContext)_localctx).type!=null?(((Decl_methodContext)_localctx).type.start):null));
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_paramsContext extends ParserRuleContext {
		public ListDeclParam tree;
		public ParamContext p1;
		public ParamContext p2;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecaParser.COMMA, i);
		}
		public List_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_params; }
	}

	public final List_paramsContext list_params() throws RecognitionException {
		List_paramsContext _localctx = new List_paramsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_list_params);

		    ((List_paramsContext)_localctx).tree =  new ListDeclParam();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(627);
				((List_paramsContext)_localctx).p1 = param();

				        assert(((List_paramsContext)_localctx).p1.tree != null);
				        _localctx.tree.add(((List_paramsContext)_localctx).p1.tree);
				    
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(629);
					match(COMMA);
					setState(630);
					((List_paramsContext)_localctx).p2 = param();

					        assert(((List_paramsContext)_localctx).p2.tree != null);
					        _localctx.tree.add(((List_paramsContext)_localctx).p2.tree);
					        
					}
					}
					setState(637);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multi_line_stringContext extends ParserRuleContext {
		public String text;
		public Location location;
		public Token s;
		public TerminalNode STRING() { return getToken(DecaParser.STRING, 0); }
		public TerminalNode MULTI_LINE_STRING() { return getToken(DecaParser.MULTI_LINE_STRING, 0); }
		public Multi_line_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_line_string; }
	}

	public final Multi_line_stringContext multi_line_string() throws RecognitionException {
		Multi_line_stringContext _localctx = new Multi_line_stringContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_multi_line_string);
		try {
			setState(644);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(640);
				((Multi_line_stringContext)_localctx).s = match(STRING);

				            ((Multi_line_stringContext)_localctx).text =  (((Multi_line_stringContext)_localctx).s!=null?((Multi_line_stringContext)_localctx).s.getText():null);
				            ((Multi_line_stringContext)_localctx).location =  tokenLocation(((Multi_line_stringContext)_localctx).s);
				        
				}
				break;
			case MULTI_LINE_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(642);
				((Multi_line_stringContext)_localctx).s = match(MULTI_LINE_STRING);

				            ((Multi_line_stringContext)_localctx).text =  (((Multi_line_stringContext)_localctx).s!=null?((Multi_line_stringContext)_localctx).s.getText():null);
				            ((Multi_line_stringContext)_localctx).location =  tokenLocation(((Multi_line_stringContext)_localctx).s);
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public AbstractDeclParam tree;
		public TypeContext type;
		public IdentContext ident;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			((ParamContext)_localctx).type = type();
			setState(647);
			((ParamContext)_localctx).ident = ident();

			        ((ParamContext)_localctx).tree =  new DeclParam(((ParamContext)_localctx).type.tree, ((ParamContext)_localctx).ident.tree);
			        setLocation(_localctx.tree, (((ParamContext)_localctx).type!=null?(((ParamContext)_localctx).type.start):null));
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return or_expr_sempred((Or_exprContext)_localctx, predIndex);
		case 16:
			return and_expr_sempred((And_exprContext)_localctx, predIndex);
		case 17:
			return eq_neq_expr_sempred((Eq_neq_exprContext)_localctx, predIndex);
		case 18:
			return inequality_expr_sempred((Inequality_exprContext)_localctx, predIndex);
		case 19:
			return sum_expr_sempred((Sum_exprContext)_localctx, predIndex);
		case 20:
			return mult_expr_sempred((Mult_exprContext)_localctx, predIndex);
		case 22:
			return select_expr_sempred((Select_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean or_expr_sempred(Or_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean and_expr_sempred(And_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean eq_neq_expr_sempred(Eq_neq_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inequality_expr_sempred(Inequality_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean sum_expr_sempred(Sum_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mult_expr_sempred(Mult_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean select_expr_sempred(Select_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u028d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3b\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\7\5k\n\5\f\5\16\5n\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6x"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0080\n\7\f\7\16\7\u0083\13\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\7\b\u008b\n\b\f\b\16\b\u008e\13\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\t\u0096\n\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\7\13\u00a4\n\13\f\13\16\13\u00a7\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u00e8\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00fc\n\r\f\r\16\r\u00ff\13\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u0107\n\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u010f"+
		"\n\16\f\16\16\16\u0112\13\16\5\16\u0114\n\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0120\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u012b\n\21\f\21\16\21\u012e\13\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0139\n\22\f\22\16\22\u013c\13\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\7\23\u014c\n\23\f\23\16\23\u014f\13\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u016e\n\24\f\24\16"+
		"\24\u0171\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\7\25\u0181\n\25\f\25\16\25\u0184\13\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\7\26\u0199\n\26\f\26\16\26\u019c\13\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01a9\n\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01b9\n\30\7\30"+
		"\u01bb\n\30\f\30\16\30\u01be\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01ed\n\31\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u0203\n\34\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\7\37\u020e\n\37\f\37\16\37\u0211\13\37\3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3!\3!\3!\3!\3!\5!\u0220\n!\3\"\3\"\3\"\3\"\7\"\u0226\n\"\f\""+
		"\16\"\u0229\13\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0235\n#\3$\3$\3$\3"+
		"$\3$\3$\7$\u023d\n$\f$\16$\u0240\13$\3%\3%\3%\3%\3%\3%\3&\3&\3&\5&\u024b"+
		"\n&\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0253\n\'\f\'\16\'\u0256\13\'\3(\3(\3"+
		"(\3(\3(\3(\5(\u025e\n(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\5)\u0272\n)\3)\3)\3*\3*\3*\3*\3*\3*\7*\u027c\n*\f*\16*\u027f\13"+
		"*\5*\u0281\n*\3+\3+\3+\3+\5+\u0287\n+\3,\3,\3,\3,\3,\2\t \"$&(*.-\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTV\2\2\2\u02a3\2X\3\2\2\2\4a\3\2\2\2\6c\3\2\2\2\bl\3\2\2\2\nw\3\2\2\2"+
		"\fy\3\2\2\2\16\u0084\3\2\2\2\20\u008f\3\2\2\2\22\u009a\3\2\2\2\24\u00a5"+
		"\3\2\2\2\26\u00e7\3\2\2\2\30\u00e9\3\2\2\2\32\u0113\3\2\2\2\34\u0115\3"+
		"\2\2\2\36\u0118\3\2\2\2 \u0121\3\2\2\2\"\u012f\3\2\2\2$\u013d\3\2\2\2"+
		"&\u0150\3\2\2\2(\u0172\3\2\2\2*\u0185\3\2\2\2,\u01a8\3\2\2\2.\u01aa\3"+
		"\2\2\2\60\u01ec\3\2\2\2\62\u01ee\3\2\2\2\64\u01f1\3\2\2\2\66\u0202\3\2"+
		"\2\28\u0204\3\2\2\2:\u0207\3\2\2\2<\u020f\3\2\2\2>\u0212\3\2\2\2@\u021f"+
		"\3\2\2\2B\u0227\3\2\2\2D\u0234\3\2\2\2F\u0236\3\2\2\2H\u0241\3\2\2\2J"+
		"\u024a\3\2\2\2L\u024c\3\2\2\2N\u0257\3\2\2\2P\u0262\3\2\2\2R\u0280\3\2"+
		"\2\2T\u0286\3\2\2\2V\u0288\3\2\2\2XY\5<\37\2YZ\5\4\3\2Z[\7\2\2\3[\\\b"+
		"\2\1\2\\\3\3\2\2\2]b\b\3\1\2^_\5\6\4\2_`\b\3\1\2`b\3\2\2\2a]\3\2\2\2a"+
		"^\3\2\2\2b\5\3\2\2\2cd\7%\2\2de\5\b\5\2ef\5\24\13\2fg\7&\2\2gh\b\4\1\2"+
		"h\7\3\2\2\2ik\5\n\6\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\t\3\2\2"+
		"\2nl\3\2\2\2op\5\62\32\2pq\5\f\7\2qr\7(\2\2rx\3\2\2\2st\5\64\33\2tu\5"+
		"\16\b\2uv\7(\2\2vx\3\2\2\2wo\3\2\2\2ws\3\2\2\2x\13\3\2\2\2yz\5\20\t\2"+
		"z\u0081\b\7\1\2{|\7\"\2\2|}\5\20\t\2}~\b\7\1\2~\u0080\3\2\2\2\177{\3\2"+
		"\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\r"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\5\22\n\2\u0085\u008c\b\b\1\2"+
		"\u0086\u0087\7\"\2\2\u0087\u0088\5\22\n\2\u0088\u0089\b\b\1\2\u0089\u008b"+
		"\3\2\2\2\u008a\u0086\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\17\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\58\35"+
		"\2\u0090\u0095\b\t\1\2\u0091\u0092\7\33\2\2\u0092\u0093\5\34\17\2\u0093"+
		"\u0094\b\t\1\2\u0094\u0096\3\2\2\2\u0095\u0091\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\u0098\b\t\1\2\u0098\u0099\b\t\1\2\u0099"+
		"\21\3\2\2\2\u009a\u009b\7/\2\2\u009b\u009c\5\32\16\2\u009c\u009d\7\60"+
		"\2\2\u009d\u009e\58\35\2\u009e\u009f\b\n\1\2\u009f\23\3\2\2\2\u00a0\u00a1"+
		"\5\26\f\2\u00a1\u00a2\b\13\1\2\u00a2\u00a4\3\2\2\2\u00a3\u00a0\3\2\2\2"+
		"\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\25"+
		"\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\5\34\17\2\u00a9\u00aa\7(\2\2"+
		"\u00aa\u00ab\b\f\1\2\u00ab\u00e8\3\2\2\2\u00ac\u00ad\7(\2\2\u00ad\u00e8"+
		"\b\f\1\2\u00ae\u00af\7\16\2\2\u00af\u00b0\7#\2\2\u00b0\u00b1\5\32\16\2"+
		"\u00b1\u00b2\7$\2\2\u00b2\u00b3\7(\2\2\u00b3\u00b4\b\f\1\2\u00b4\u00e8"+
		"\3\2\2\2\u00b5\u00b6\7\17\2\2\u00b6\u00b7\7#\2\2\u00b7\u00b8\5\32\16\2"+
		"\u00b8\u00b9\7$\2\2\u00b9\u00ba\7(\2\2\u00ba\u00bb\b\f\1\2\u00bb\u00e8"+
		"\3\2\2\2\u00bc\u00bd\7\21\2\2\u00bd\u00be\7#\2\2\u00be\u00bf\5\32\16\2"+
		"\u00bf\u00c0\7$\2\2\u00c0\u00c1\7(\2\2\u00c1\u00c2\b\f\1\2\u00c2\u00e8"+
		"\3\2\2\2\u00c3\u00c4\7\20\2\2\u00c4\u00c5\7#\2\2\u00c5\u00c6\5\32\16\2"+
		"\u00c6\u00c7\7$\2\2\u00c7\u00c8\7(\2\2\u00c8\u00c9\b\f\1\2\u00c9\u00e8"+
		"\3\2\2\2\u00ca\u00cb\5\30\r\2\u00cb\u00cc\b\f\1\2\u00cc\u00e8\3\2\2\2"+
		"\u00cd\u00ce\7\26\2\2\u00ce\u00cf\7#\2\2\u00cf\u00d0\5\34\17\2\u00d0\u00d1"+
		"\7$\2\2\u00d1\u00d2\7%\2\2\u00d2\u00d3\5\24\13\2\u00d3\u00d4\7&\2\2\u00d4"+
		"\u00d5\b\f\1\2\u00d5\u00e8\3\2\2\2\u00d6\u00d7\7\23\2\2\u00d7\u00d8\5"+
		"\34\17\2\u00d8\u00d9\7(\2\2\u00d9\u00da\b\f\1\2\u00da\u00e8\3\2\2\2\u00db"+
		"\u00dc\7\27\2\2\u00dc\u00dd\7#\2\2\u00dd\u00de\5\62\32\2\u00de\u00df\5"+
		"8\35\2\u00df\u00e0\7\61\2\2\u00e0\u00e1\5\60\31\2\u00e1\u00e2\7$\2\2\u00e2"+
		"\u00e3\7%\2\2\u00e3\u00e4\5\24\13\2\u00e4\u00e5\7&\2\2\u00e5\u00e6\b\f"+
		"\1\2\u00e6\u00e8\3\2\2\2\u00e7\u00a8\3\2\2\2\u00e7\u00ac\3\2\2\2\u00e7"+
		"\u00ae\3\2\2\2\u00e7\u00b5\3\2\2\2\u00e7\u00bc\3\2\2\2\u00e7\u00c3\3\2"+
		"\2\2\u00e7\u00ca\3\2\2\2\u00e7\u00cd\3\2\2\2\u00e7\u00d6\3\2\2\2\u00e7"+
		"\u00db\3\2\2\2\u00e8\27\3\2\2\2\u00e9\u00ea\7\b\2\2\u00ea\u00eb\7#\2\2"+
		"\u00eb\u00ec\5\34\17\2\u00ec\u00ed\7$\2\2\u00ed\u00ee\7%\2\2\u00ee\u00ef"+
		"\5\24\13\2\u00ef\u00f0\7&\2\2\u00f0\u00fd\b\r\1\2\u00f1\u00f2\7\6\2\2"+
		"\u00f2\u00f3\7\b\2\2\u00f3\u00f4\7#\2\2\u00f4\u00f5\5\34\17\2\u00f5\u00f6"+
		"\7$\2\2\u00f6\u00f7\7%\2\2\u00f7\u00f8\5\24\13\2\u00f8\u00f9\7&\2\2\u00f9"+
		"\u00fa\b\r\1\2\u00fa\u00fc\3\2\2\2\u00fb\u00f1\3\2\2\2\u00fc\u00ff\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0106\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u0100\u0101\7\6\2\2\u0101\u0102\7%\2\2\u0102\u0103\5\24"+
		"\13\2\u0103\u0104\7&\2\2\u0104\u0105\b\r\1\2\u0105\u0107\3\2\2\2\u0106"+
		"\u0100\3\2\2\2\u0106\u0107\3\2\2\2\u0107\31\3\2\2\2\u0108\u0109\5\34\17"+
		"\2\u0109\u0110\b\16\1\2\u010a\u010b\7\"\2\2\u010b\u010c\5\34\17\2\u010c"+
		"\u010d\b\16\1\2\u010d\u010f\3\2\2\2\u010e\u010a\3\2\2\2\u010f\u0112\3"+
		"\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0113\u0108\3\2\2\2\u0113\u0114\3\2\2\2\u0114\33\3\2\2"+
		"\2\u0115\u0116\5\36\20\2\u0116\u0117\b\17\1\2\u0117\35\3\2\2\2\u0118\u011f"+
		"\5 \21\2\u0119\u011a\b\20\1\2\u011a\u011b\7\33\2\2\u011b\u011c\5\36\20"+
		"\2\u011c\u011d\b\20\1\2\u011d\u0120\3\2\2\2\u011e\u0120\b\20\1\2\u011f"+
		"\u0119\3\2\2\2\u011f\u011e\3\2\2\2\u0120\37\3\2\2\2\u0121\u0122\b\21\1"+
		"\2\u0122\u0123\5\"\22\2\u0123\u0124\b\21\1\2\u0124\u012c\3\2\2\2\u0125"+
		"\u0126\f\3\2\2\u0126\u0127\7.\2\2\u0127\u0128\5\"\22\2\u0128\u0129\b\21"+
		"\1\2\u0129\u012b\3\2\2\2\u012a\u0125\3\2\2\2\u012b\u012e\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d!\3\2\2\2\u012e\u012c\3\2\2\2"+
		"\u012f\u0130\b\22\1\2\u0130\u0131\5$\23\2\u0131\u0132\b\22\1\2\u0132\u013a"+
		"\3\2\2\2\u0133\u0134\f\3\2\2\u0134\u0135\7-\2\2\u0135\u0136\5$\23\2\u0136"+
		"\u0137\b\22\1\2\u0137\u0139\3\2\2\2\u0138\u0133\3\2\2\2\u0139\u013c\3"+
		"\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b#\3\2\2\2\u013c\u013a"+
		"\3\2\2\2\u013d\u013e\b\23\1\2\u013e\u013f\5&\24\2\u013f\u0140\b\23\1\2"+
		"\u0140\u014d\3\2\2\2\u0141\u0142\f\4\2\2\u0142\u0143\7)\2\2\u0143\u0144"+
		"\5&\24\2\u0144\u0145\b\23\1\2\u0145\u014c\3\2\2\2\u0146\u0147\f\3\2\2"+
		"\u0147\u0148\7*\2\2\u0148\u0149\5&\24\2\u0149\u014a\b\23\1\2\u014a\u014c"+
		"\3\2\2\2\u014b\u0141\3\2\2\2\u014b\u0146\3\2\2\2\u014c\u014f\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e%\3\2\2\2\u014f\u014d\3\2\2\2"+
		"\u0150\u0151\b\24\1\2\u0151\u0152\5(\25\2\u0152\u0153\b\24\1\2\u0153\u016f"+
		"\3\2\2\2\u0154\u0155\f\7\2\2\u0155\u0156\7,\2\2\u0156\u0157\5(\25\2\u0157"+
		"\u0158\b\24\1\2\u0158\u016e\3\2\2\2\u0159\u015a\f\6\2\2\u015a\u015b\7"+
		"+\2\2\u015b\u015c\5(\25\2\u015c\u015d\b\24\1\2\u015d\u016e\3\2\2\2\u015e"+
		"\u015f\f\5\2\2\u015f\u0160\7\32\2\2\u0160\u0161\5(\25\2\u0161\u0162\b"+
		"\24\1\2\u0162\u016e\3\2\2\2\u0163\u0164\f\4\2\2\u0164\u0165\7\31\2\2\u0165"+
		"\u0166\5(\25\2\u0166\u0167\b\24\1\2\u0167\u016e\3\2\2\2\u0168\u0169\f"+
		"\3\2\2\u0169\u016a\7\t\2\2\u016a\u016b\5\62\32\2\u016b\u016c\b\24\1\2"+
		"\u016c\u016e\3\2\2\2\u016d\u0154\3\2\2\2\u016d\u0159\3\2\2\2\u016d\u015e"+
		"\3\2\2\2\u016d\u0163\3\2\2\2\u016d\u0168\3\2\2\2\u016e\u0171\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\'\3\2\2\2\u0171\u016f\3\2\2\2"+
		"\u0172\u0173\b\25\1\2\u0173\u0174\5*\26\2\u0174\u0175\b\25\1\2\u0175\u0182"+
		"\3\2\2\2\u0176\u0177\f\4\2\2\u0177\u0178\7\34\2\2\u0178\u0179\5*\26\2"+
		"\u0179\u017a\b\25\1\2\u017a\u0181\3\2\2\2\u017b\u017c\f\3\2\2\u017c\u017d"+
		"\7\35\2\2\u017d\u017e\5*\26\2\u017e\u017f\b\25\1\2\u017f\u0181\3\2\2\2"+
		"\u0180\u0176\3\2\2\2\u0180\u017b\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180"+
		"\3\2\2\2\u0182\u0183\3\2\2\2\u0183)\3\2\2\2\u0184\u0182\3\2\2\2\u0185"+
		"\u0186\b\26\1\2\u0186\u0187\5,\27\2\u0187\u0188\b\26\1\2\u0188\u019a\3"+
		"\2\2\2\u0189\u018a\f\5\2\2\u018a\u018b\7\36\2\2\u018b\u018c\5,\27\2\u018c"+
		"\u018d\b\26\1\2\u018d\u0199\3\2\2\2\u018e\u018f\f\4\2\2\u018f\u0190\7"+
		"\37\2\2\u0190\u0191\5,\27\2\u0191\u0192\b\26\1\2\u0192\u0199\3\2\2\2\u0193"+
		"\u0194\f\3\2\2\u0194\u0195\7 \2\2\u0195\u0196\5,\27\2\u0196\u0197\b\26"+
		"\1\2\u0197\u0199\3\2\2\2\u0198\u0189\3\2\2\2\u0198\u018e\3\2\2\2\u0198"+
		"\u0193\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2"+
		"\2\2\u019b+\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e\7\35\2\2\u019e\u019f"+
		"\5,\27\2\u019f\u01a0\b\27\1\2\u01a0\u01a9\3\2\2\2\u01a1\u01a2\7\'\2\2"+
		"\u01a2\u01a3\5,\27\2\u01a3\u01a4\b\27\1\2\u01a4\u01a9\3\2\2\2\u01a5\u01a6"+
		"\5.\30\2\u01a6\u01a7\b\27\1\2\u01a7\u01a9\3\2\2\2\u01a8\u019d\3\2\2\2"+
		"\u01a8\u01a1\3\2\2\2\u01a8\u01a5\3\2\2\2\u01a9-\3\2\2\2\u01aa\u01ab\b"+
		"\30\1\2\u01ab\u01ac\5\60\31\2\u01ac\u01ad\b\30\1\2\u01ad\u01bc\3\2\2\2"+
		"\u01ae\u01af\f\3\2\2\u01af\u01b0\7!\2\2\u01b0\u01b1\58\35\2\u01b1\u01b8"+
		"\b\30\1\2\u01b2\u01b3\7#\2\2\u01b3\u01b4\5\32\16\2\u01b4\u01b5\7$\2\2"+
		"\u01b5\u01b6\b\30\1\2\u01b6\u01b9\3\2\2\2\u01b7\u01b9\b\30\1\2\u01b8\u01b2"+
		"\3\2\2\2\u01b8\u01b7\3\2\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01ae\3\2\2\2\u01bb"+
		"\u01be\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd/\3\2\2\2"+
		"\u01be\u01bc\3\2\2\2\u01bf\u01c0\58\35\2\u01c0\u01c1\b\31\1\2\u01c1\u01ed"+
		"\3\2\2\2\u01c2\u01c3\58\35\2\u01c3\u01c4\7#\2\2\u01c4\u01c5\5\32\16\2"+
		"\u01c5\u01c6\7$\2\2\u01c6\u01c7\b\31\1\2\u01c7\u01ed\3\2\2\2\u01c8\u01c9"+
		"\58\35\2\u01c9\u01ca\7/\2\2\u01ca\u01cb\5\32\16\2\u01cb\u01cc\7\60\2\2"+
		"\u01cc\u01cd\b\31\1\2\u01cd\u01ed\3\2\2\2\u01ce\u01cf\7#\2\2\u01cf\u01d0"+
		"\5\34\17\2\u01d0\u01d1\7$\2\2\u01d1\u01d2\b\31\1\2\u01d2\u01ed\3\2\2\2"+
		"\u01d3\u01d4\7\f\2\2\u01d4\u01d5\7#\2\2\u01d5\u01d6\7$\2\2\u01d6\u01ed"+
		"\b\31\1\2\u01d7\u01d8\7\r\2\2\u01d8\u01d9\7#\2\2\u01d9\u01da\7$\2\2\u01da"+
		"\u01ed\b\31\1\2\u01db\u01dc\7\n\2\2\u01dc\u01dd\58\35\2\u01dd\u01de\7"+
		"#\2\2\u01de\u01df\7$\2\2\u01df\u01e0\b\31\1\2\u01e0\u01ed\3\2\2\2\u01e1"+
		"\u01e2\7#\2\2\u01e2\u01e3\5\62\32\2\u01e3\u01e4\7$\2\2\u01e4\u01e5\7#"+
		"\2\2\u01e5\u01e6\5\34\17\2\u01e6\u01e7\7$\2\2\u01e7\u01e8\b\31\1\2\u01e8"+
		"\u01ed\3\2\2\2\u01e9\u01ea\5\66\34\2\u01ea\u01eb\b\31\1\2\u01eb\u01ed"+
		"\3\2\2\2\u01ec\u01bf\3\2\2\2\u01ec\u01c2\3\2\2\2\u01ec\u01c8\3\2\2\2\u01ec"+
		"\u01ce\3\2\2\2\u01ec\u01d3\3\2\2\2\u01ec\u01d7\3\2\2\2\u01ec\u01db\3\2"+
		"\2\2\u01ec\u01e1\3\2\2\2\u01ec\u01e9\3\2\2\2\u01ed\61\3\2\2\2\u01ee\u01ef"+
		"\58\35\2\u01ef\u01f0\b\32\1\2\u01f0\63\3\2\2\2\u01f1\u01f2\5:\36\2\u01f2"+
		"\u01f3\b\33\1\2\u01f3\65\3\2\2\2\u01f4\u01f5\7\62\2\2\u01f5\u0203\b\34"+
		"\1\2\u01f6\u01f7\7\63\2\2\u01f7\u0203\b\34\1\2\u01f8\u01f9\7\64\2\2\u01f9"+
		"\u0203\b\34\1\2\u01fa\u01fb\7\25\2\2\u01fb\u0203\b\34\1\2\u01fc\u01fd"+
		"\7\7\2\2\u01fd\u0203\b\34\1\2\u01fe\u01ff\7\24\2\2\u01ff\u0203\b\34\1"+
		"\2\u0200\u0201\7\13\2\2\u0201\u0203\b\34\1\2\u0202\u01f4\3\2\2\2\u0202"+
		"\u01f6\3\2\2\2\u0202\u01f8\3\2\2\2\u0202\u01fa\3\2\2\2\u0202\u01fc\3\2"+
		"\2\2\u0202\u01fe\3\2\2\2\u0202\u0200\3\2\2\2\u0203\67\3\2\2\2\u0204\u0205"+
		"\7\30\2\2\u0205\u0206\b\35\1\2\u02069\3\2\2\2\u0207\u0208\7\30\2\2\u0208"+
		"\u0209\b\36\1\2\u0209;\3\2\2\2\u020a\u020b\5> \2\u020b\u020c\b\37\1\2"+
		"\u020c\u020e\3\2\2\2\u020d\u020a\3\2\2\2\u020e\u0211\3\2\2\2\u020f\u020d"+
		"\3\2\2\2\u020f\u0210\3\2\2\2\u0210=\3\2\2\2\u0211\u020f\3\2\2\2\u0212"+
		"\u0213\7\4\2\2\u0213\u0214\58\35\2\u0214\u0215\5@!\2\u0215\u0216\7%\2"+
		"\2\u0216\u0217\5B\"\2\u0217\u0218\7&\2\2\u0218\u0219\b \1\2\u0219?\3\2"+
		"\2\2\u021a\u021b\7\5\2\2\u021b\u021c\58\35\2\u021c\u021d\b!\1\2\u021d"+
		"\u0220\3\2\2\2\u021e\u0220\b!\1\2\u021f\u021a\3\2\2\2\u021f\u021e\3\2"+
		"\2\2\u0220A\3\2\2\2\u0221\u0222\5P)\2\u0222\u0223\b\"\1\2\u0223\u0226"+
		"\3\2\2\2\u0224\u0226\5D#\2\u0225\u0221\3\2\2\2\u0225\u0224\3\2\2\2\u0226"+
		"\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228C\3\2\2\2"+
		"\u0229\u0227\3\2\2\2\u022a\u022b\5J&\2\u022b\u022c\5\62\32\2\u022c\u022d"+
		"\5L\'\2\u022d\u022e\7(\2\2\u022e\u0235\3\2\2\2\u022f\u0230\5J&\2\u0230"+
		"\u0231\5\64\33\2\u0231\u0232\5F$\2\u0232\u0233\7(\2\2\u0233\u0235\3\2"+
		"\2\2\u0234\u022a\3\2\2\2\u0234\u022f\3\2\2\2\u0235E\3\2\2\2\u0236\u0237"+
		"\5H%\2\u0237\u023e\b$\1\2\u0238\u0239\7\"\2\2\u0239\u023a\5H%\2\u023a"+
		"\u023b\b$\1\2\u023b\u023d\3\2\2\2\u023c\u0238\3\2\2\2\u023d\u0240\3\2"+
		"\2\2\u023e\u023c\3\2\2\2\u023e\u023f\3\2\2\2\u023fG\3\2\2\2\u0240\u023e"+
		"\3\2\2\2\u0241\u0242\7/\2\2\u0242\u0243\5\32\16\2\u0243\u0244\7\60\2\2"+
		"\u0244\u0245\58\35\2\u0245\u0246\b%\1\2\u0246I\3\2\2\2\u0247\u024b\b&"+
		"\1\2\u0248\u0249\7\22\2\2\u0249\u024b\b&\1\2\u024a\u0247\3\2\2\2\u024a"+
		"\u0248\3\2\2\2\u024bK\3\2\2\2\u024c\u024d\5N(\2\u024d\u0254\b\'\1\2\u024e"+
		"\u024f\7\"\2\2\u024f\u0250\5N(\2\u0250\u0251\b\'\1\2\u0251\u0253\3\2\2"+
		"\2\u0252\u024e\3\2\2\2\u0253\u0256\3\2\2\2\u0254\u0252\3\2\2\2\u0254\u0255"+
		"\3\2\2\2\u0255M\3\2\2\2\u0256\u0254\3\2\2\2\u0257\u0258\58\35\2\u0258"+
		"\u025d\b(\1\2\u0259\u025a\7\33\2\2\u025a\u025b\5\34\17\2\u025b\u025c\b"+
		"(\1\2\u025c\u025e\3\2\2\2\u025d\u0259\3\2\2\2\u025d\u025e\3\2\2\2\u025e"+
		"\u025f\3\2\2\2\u025f\u0260\b(\1\2\u0260\u0261\b(\1\2\u0261O\3\2\2\2\u0262"+
		"\u0263\5\62\32\2\u0263\u0264\58\35\2\u0264\u0265\7#\2\2\u0265\u0266\5"+
		"R*\2\u0266\u0271\7$\2\2\u0267\u0268\5\6\4\2\u0268\u0269\b)\1\2\u0269\u0272"+
		"\3\2\2\2\u026a\u026b\7\3\2\2\u026b\u026c\7#\2\2\u026c\u026d\5T+\2\u026d"+
		"\u026e\7$\2\2\u026e\u026f\7(\2\2\u026f\u0270\b)\1\2\u0270\u0272\3\2\2"+
		"\2\u0271\u0267\3\2\2\2\u0271\u026a\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0274"+
		"\b)\1\2\u0274Q\3\2\2\2\u0275\u0276\5V,\2\u0276\u027d\b*\1\2\u0277\u0278"+
		"\7\"\2\2\u0278\u0279\5V,\2\u0279\u027a\b*\1\2\u027a\u027c\3\2\2\2\u027b"+
		"\u0277\3\2\2\2\u027c\u027f\3\2\2\2\u027d\u027b\3\2\2\2\u027d\u027e\3\2"+
		"\2\2\u027e\u0281\3\2\2\2\u027f\u027d\3\2\2\2\u0280\u0275\3\2\2\2\u0280"+
		"\u0281\3\2\2\2\u0281S\3\2\2\2\u0282\u0283\7\64\2\2\u0283\u0287\b+\1\2"+
		"\u0284\u0285\7\65\2\2\u0285\u0287\b+\1\2\u0286\u0282\3\2\2\2\u0286\u0284"+
		"\3\2\2\2\u0287U\3\2\2\2\u0288\u0289\5\62\32\2\u0289\u028a\58\35\2\u028a"+
		"\u028b\b,\1\2\u028bW\3\2\2\2+alw\u0081\u008c\u0095\u00a5\u00e7\u00fd\u0106"+
		"\u0110\u0113\u011f\u012c\u013a\u014b\u014d\u016d\u016f\u0180\u0182\u0198"+
		"\u019a\u01a8\u01b8\u01bc\u01ec\u0202\u020f\u021f\u0225\u0227\u0234\u023e"+
		"\u024a\u0254\u025d\u0271\u027d\u0280\u0286";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}