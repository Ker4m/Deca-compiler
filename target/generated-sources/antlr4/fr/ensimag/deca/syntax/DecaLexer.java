// Generated from fr/ensimag/deca/syntax/DecaLexer.g4 by ANTLR 4.9.3
package fr.ensimag.deca.syntax;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecaLexer extends AbstractDecaLexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ASM", "CLASS", "EXTENDS", "ELSE", "FALSE", "IF", "INSTANCEOF", "NEW", 
			"NULL", "READINT", "READFLOAT", "PRINT", "PRINTLN", "PRINTLNX", "PRINTX", 
			"PROTECTED", "RETURN", "THIS", "TRUE", "WHILE", "FOR", "DIGIT", "LETTER", 
			"IDENT", "LT", "GT", "EQUALS", "PLUS", "MINUS", "TIMES", "SLASH", "PERCENT", 
			"DOT", "COMMA", "OPARENT", "CPARENT", "OBRACE", "CBRACE", "EXCLAM", "SEMI", 
			"EQEQ", "NEQ", "GEQ", "LEQ", "AND", "OR", "OBRACKET", "CBRACKET", "COL", 
			"POSITIVE_DIGIT", "INT", "NUM", "SIGN", "EXP", "DEC", "FLOATDEC", "DIGITHEX", 
			"NUMHEX", "FLOATHEX", "FLOAT", "STRING_CAR", "STRING", "MULTI_LINE_STRING", 
			"COMMENT", "MONO_LINE_COMMENT", "EOL", "TAB", "SPACE", "RCAR", "SEP", 
			"FILENAME", "INCLUDE"
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




	public DecaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DecaLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 69:
			SEP_action((RuleContext)_localctx, actionIndex);
			break;
		case 71:
			INCLUDE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void SEP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void INCLUDE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 doInclude(getText()); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u020e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\5\31\u0123\n\31\3\31\3\31\3\31\7\31\u0128\n\31\f"+
		"\31\16\31\u012b\13\31\3\31\3\31\3\31\3\31\5\31\u0131\n\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3"+
		"#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,"+
		"\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3"+
		"\64\3\64\3\64\7\64\u0170\n\64\f\64\16\64\u0173\13\64\5\64\u0175\n\64\3"+
		"\65\6\65\u0178\n\65\r\65\16\65\u0179\3\66\3\66\5\66\u017e\n\66\3\67\3"+
		"\67\3\67\3\67\38\38\38\38\39\39\39\39\59\u018c\n9\39\39\59\u0190\n9\3"+
		":\5:\u0193\n:\3;\6;\u0196\n;\r;\16;\u0197\3<\3<\3<\3<\5<\u019e\n<\3<\3"+
		"<\3<\3<\3<\3<\3<\3<\5<\u01a8\n<\3=\3=\5=\u01ac\n=\3>\3>\3?\3?\3?\3?\3"+
		"?\3?\7?\u01b6\n?\f?\16?\u01b9\13?\3?\3?\3@\3@\3@\3@\3@\3@\3@\7@\u01c4"+
		"\n@\f@\16@\u01c7\13@\3@\3@\3A\3A\3A\3A\7A\u01cf\nA\fA\16A\u01d2\13A\3"+
		"A\3A\3A\3B\3B\3B\3B\7B\u01db\nB\fB\16B\u01de\13B\3C\3C\3D\3D\3E\3E\3F"+
		"\3F\3G\3G\3G\3G\3G\3G\5G\u01ee\nG\3G\3G\3H\3H\3H\3H\3H\6H\u01f7\nH\rH"+
		"\16H\u01f8\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\7I\u0205\nI\fI\16I\u0208\13I"+
		"\3I\3I\3I\3I\3I\3\u01d0\2J\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\2/\2\61\30\63"+
		"\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%M&O\'Q(S)U*W+Y,[-]._/a\60"+
		"c\61e\2g\62i\2k\2m\2o\2q\2s\2u\2w\2y\63{\2}\64\177\65\u0081\2\u0083\2"+
		"\u0085\2\u0087\2\u0089\2\u008b\2\u008d\66\u008f\2\u0091\67\3\2\r\3\2\62"+
		";\4\2C\\c|\4\2&&aa\3\2\63;\4\2--//\4\2GGgg\4\2HHhh\5\2\62;CHch\4\2RRr"+
		"r\5\2\f\f$$^^\4\2\f\f\17\17\2\u021d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2g\3\2\2\2\2y\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u0091\3\2\2\2\3\u0093\3\2\2\2\5\u0097\3\2\2"+
		"\2\7\u009d\3\2\2\2\t\u00a5\3\2\2\2\13\u00aa\3\2\2\2\r\u00b0\3\2\2\2\17"+
		"\u00b3\3\2\2\2\21\u00be\3\2\2\2\23\u00c2\3\2\2\2\25\u00c7\3\2\2\2\27\u00cf"+
		"\3\2\2\2\31\u00d9\3\2\2\2\33\u00df\3\2\2\2\35\u00e7\3\2\2\2\37\u00f0\3"+
		"\2\2\2!\u00f7\3\2\2\2#\u0101\3\2\2\2%\u0108\3\2\2\2\'\u010d\3\2\2\2)\u0112"+
		"\3\2\2\2+\u0118\3\2\2\2-\u011c\3\2\2\2/\u011e\3\2\2\2\61\u0122\3\2\2\2"+
		"\63\u0132\3\2\2\2\65\u0134\3\2\2\2\67\u0136\3\2\2\29\u0138\3\2\2\2;\u013a"+
		"\3\2\2\2=\u013c\3\2\2\2?\u013e\3\2\2\2A\u0140\3\2\2\2C\u0142\3\2\2\2E"+
		"\u0144\3\2\2\2G\u0146\3\2\2\2I\u0148\3\2\2\2K\u014a\3\2\2\2M\u014c\3\2"+
		"\2\2O\u014e\3\2\2\2Q\u0150\3\2\2\2S\u0152\3\2\2\2U\u0155\3\2\2\2W\u0158"+
		"\3\2\2\2Y\u015b\3\2\2\2[\u015e\3\2\2\2]\u0161\3\2\2\2_\u0164\3\2\2\2a"+
		"\u0166\3\2\2\2c\u0168\3\2\2\2e\u016a\3\2\2\2g\u0174\3\2\2\2i\u0177\3\2"+
		"\2\2k\u017d\3\2\2\2m\u017f\3\2\2\2o\u0183\3\2\2\2q\u018b\3\2\2\2s\u0192"+
		"\3\2\2\2u\u0195\3\2\2\2w\u019d\3\2\2\2y\u01ab\3\2\2\2{\u01ad\3\2\2\2}"+
		"\u01af\3\2\2\2\177\u01bc\3\2\2\2\u0081\u01ca\3\2\2\2\u0083\u01d6\3\2\2"+
		"\2\u0085\u01df\3\2\2\2\u0087\u01e1\3\2\2\2\u0089\u01e3\3\2\2\2\u008b\u01e5"+
		"\3\2\2\2\u008d\u01ed\3\2\2\2\u008f\u01f6\3\2\2\2\u0091\u01fa\3\2\2\2\u0093"+
		"\u0094\7c\2\2\u0094\u0095\7u\2\2\u0095\u0096\7o\2\2\u0096\4\3\2\2\2\u0097"+
		"\u0098\7e\2\2\u0098\u0099\7n\2\2\u0099\u009a\7c\2\2\u009a\u009b\7u\2\2"+
		"\u009b\u009c\7u\2\2\u009c\6\3\2\2\2\u009d\u009e\7g\2\2\u009e\u009f\7z"+
		"\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3"+
		"\7f\2\2\u00a3\u00a4\7u\2\2\u00a4\b\3\2\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7"+
		"\7n\2\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7g\2\2\u00a9\n\3\2\2\2\u00aa\u00ab"+
		"\7h\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7u\2\2\u00ae"+
		"\u00af\7g\2\2\u00af\f\3\2\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7h\2\2\u00b2"+
		"\16\3\2\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7u\2\2\u00b6"+
		"\u00b7\7v\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7e\2\2"+
		"\u00ba\u00bb\7g\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7h\2\2\u00bd\20\3\2"+
		"\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7y\2\2\u00c1\22"+
		"\3\2\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7w\2\2\u00c4\u00c5\7n\2\2\u00c5"+
		"\u00c6\7n\2\2\u00c6\24\3\2\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7g\2\2\u00c9"+
		"\u00ca\7c\2\2\u00ca\u00cb\7f\2\2\u00cb\u00cc\7K\2\2\u00cc\u00cd\7p\2\2"+
		"\u00cd\u00ce\7v\2\2\u00ce\26\3\2\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7"+
		"g\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7f\2\2\u00d3\u00d4\7H\2\2\u00d4\u00d5"+
		"\7n\2\2\u00d5\u00d6\7q\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7v\2\2\u00d8"+
		"\30\3\2\2\2\u00d9\u00da\7r\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7k\2\2\u00dc"+
		"\u00dd\7p\2\2\u00dd\u00de\7v\2\2\u00de\32\3\2\2\2\u00df\u00e0\7r\2\2\u00e0"+
		"\u00e1\7t\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7p\2\2\u00e3\u00e4\7v\2\2"+
		"\u00e4\u00e5\7n\2\2\u00e5\u00e6\7p\2\2\u00e6\34\3\2\2\2\u00e7\u00e8\7"+
		"r\2\2\u00e8\u00e9\7t\2\2\u00e9\u00ea\7k\2\2\u00ea\u00eb\7p\2\2\u00eb\u00ec"+
		"\7v\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7z\2\2\u00ef"+
		"\36\3\2\2\2\u00f0\u00f1\7r\2\2\u00f1\u00f2\7t\2\2\u00f2\u00f3\7k\2\2\u00f3"+
		"\u00f4\7p\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6\7z\2\2\u00f6 \3\2\2\2\u00f7"+
		"\u00f8\7r\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7q\2\2\u00fa\u00fb\7v\2\2"+
		"\u00fb\u00fc\7g\2\2\u00fc\u00fd\7e\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff"+
		"\7g\2\2\u00ff\u0100\7f\2\2\u0100\"\3\2\2\2\u0101\u0102\7t\2\2\u0102\u0103"+
		"\7g\2\2\u0103\u0104\7v\2\2\u0104\u0105\7w\2\2\u0105\u0106\7t\2\2\u0106"+
		"\u0107\7p\2\2\u0107$\3\2\2\2\u0108\u0109\7v\2\2\u0109\u010a\7j\2\2\u010a"+
		"\u010b\7k\2\2\u010b\u010c\7u\2\2\u010c&\3\2\2\2\u010d\u010e\7v\2\2\u010e"+
		"\u010f\7t\2\2\u010f\u0110\7w\2\2\u0110\u0111\7g\2\2\u0111(\3\2\2\2\u0112"+
		"\u0113\7y\2\2\u0113\u0114\7j\2\2\u0114\u0115\7k\2\2\u0115\u0116\7n\2\2"+
		"\u0116\u0117\7g\2\2\u0117*\3\2\2\2\u0118\u0119\7h\2\2\u0119\u011a\7q\2"+
		"\2\u011a\u011b\7t\2\2\u011b,\3\2\2\2\u011c\u011d\t\2\2\2\u011d.\3\2\2"+
		"\2\u011e\u011f\t\3\2\2\u011f\60\3\2\2\2\u0120\u0123\5/\30\2\u0121\u0123"+
		"\t\4\2\2\u0122\u0120\3\2\2\2\u0122\u0121\3\2\2\2\u0123\u0129\3\2\2\2\u0124"+
		"\u0128\5/\30\2\u0125\u0128\5-\27\2\u0126\u0128\t\4\2\2\u0127\u0124\3\2"+
		"\2\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0130\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012c\u012d\5_\60\2\u012d\u012e\5a\61\2\u012e\u0131\3\2\2\2\u012f"+
		"\u0131\3\2\2\2\u0130\u012c\3\2\2\2\u0130\u012f\3\2\2\2\u0131\62\3\2\2"+
		"\2\u0132\u0133\7>\2\2\u0133\64\3\2\2\2\u0134\u0135\7@\2\2\u0135\66\3\2"+
		"\2\2\u0136\u0137\7?\2\2\u01378\3\2\2\2\u0138\u0139\7-\2\2\u0139:\3\2\2"+
		"\2\u013a\u013b\7/\2\2\u013b<\3\2\2\2\u013c\u013d\7,\2\2\u013d>\3\2\2\2"+
		"\u013e\u013f\7\61\2\2\u013f@\3\2\2\2\u0140\u0141\7\'\2\2\u0141B\3\2\2"+
		"\2\u0142\u0143\7\60\2\2\u0143D\3\2\2\2\u0144\u0145\7.\2\2\u0145F\3\2\2"+
		"\2\u0146\u0147\7*\2\2\u0147H\3\2\2\2\u0148\u0149\7+\2\2\u0149J\3\2\2\2"+
		"\u014a\u014b\7}\2\2\u014bL\3\2\2\2\u014c\u014d\7\177\2\2\u014dN\3\2\2"+
		"\2\u014e\u014f\7#\2\2\u014fP\3\2\2\2\u0150\u0151\7=\2\2\u0151R\3\2\2\2"+
		"\u0152\u0153\7?\2\2\u0153\u0154\7?\2\2\u0154T\3\2\2\2\u0155\u0156\7#\2"+
		"\2\u0156\u0157\7?\2\2\u0157V\3\2\2\2\u0158\u0159\7@\2\2\u0159\u015a\7"+
		"?\2\2\u015aX\3\2\2\2\u015b\u015c\7>\2\2\u015c\u015d\7?\2\2\u015dZ\3\2"+
		"\2\2\u015e\u015f\7(\2\2\u015f\u0160\7(\2\2\u0160\\\3\2\2\2\u0161\u0162"+
		"\7~\2\2\u0162\u0163\7~\2\2\u0163^\3\2\2\2\u0164\u0165\7]\2\2\u0165`\3"+
		"\2\2\2\u0166\u0167\7_\2\2\u0167b\3\2\2\2\u0168\u0169\7<\2\2\u0169d\3\2"+
		"\2\2\u016a\u016b\t\5\2\2\u016bf\3\2\2\2\u016c\u0175\7\62\2\2\u016d\u0171"+
		"\5e\63\2\u016e\u0170\5-\27\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2\2\2\u0171"+
		"\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2"+
		"\2\2\u0174\u016c\3\2\2\2\u0174\u016d\3\2\2\2\u0175h\3\2\2\2\u0176\u0178"+
		"\5-\27\2\u0177\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u0177\3\2\2\2\u0179"+
		"\u017a\3\2\2\2\u017aj\3\2\2\2\u017b\u017e\t\6\2\2\u017c\u017e\3\2\2\2"+
		"\u017d\u017b\3\2\2\2\u017d\u017c\3\2\2\2\u017el\3\2\2\2\u017f\u0180\t"+
		"\7\2\2\u0180\u0181\5k\66\2\u0181\u0182\5i\65\2\u0182n\3\2\2\2\u0183\u0184"+
		"\5i\65\2\u0184\u0185\7\60\2\2\u0185\u0186\5i\65\2\u0186p\3\2\2\2\u0187"+
		"\u018c\5o8\2\u0188\u0189\5o8\2\u0189\u018a\5m\67\2\u018a\u018c\3\2\2\2"+
		"\u018b\u0187\3\2\2\2\u018b\u0188\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u0190"+
		"\t\b\2\2\u018e\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u018e\3\2\2\2\u0190"+
		"r\3\2\2\2\u0191\u0193\t\t\2\2\u0192\u0191\3\2\2\2\u0193t\3\2\2\2\u0194"+
		"\u0196\5s:\2\u0195\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0195\3\2\2"+
		"\2\u0197\u0198\3\2\2\2\u0198v\3\2\2\2\u0199\u019a\7\62\2\2\u019a\u019e"+
		"\7z\2\2\u019b\u019c\7\62\2\2\u019c\u019e\7Z\2\2\u019d\u0199\3\2\2\2\u019d"+
		"\u019b\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\5u;\2\u01a0\u01a1\7\60"+
		"\2\2\u01a1\u01a2\5u;\2\u01a2\u01a3\t\n\2\2\u01a3\u01a4\5k\66\2\u01a4\u01a7"+
		"\5i\65\2\u01a5\u01a8\t\b\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7"+
		"\u01a6\3\2\2\2\u01a8x\3\2\2\2\u01a9\u01ac\5q9\2\u01aa\u01ac\5w<\2\u01ab"+
		"\u01a9\3\2\2\2\u01ab\u01aa\3\2\2\2\u01acz\3\2\2\2\u01ad\u01ae\n\13\2\2"+
		"\u01ae|\3\2\2\2\u01af\u01b7\7$\2\2\u01b0\u01b6\5{>\2\u01b1\u01b2\7^\2"+
		"\2\u01b2\u01b6\7$\2\2\u01b3\u01b4\7^\2\2\u01b4\u01b6\7^\2\2\u01b5\u01b0"+
		"\3\2\2\2\u01b5\u01b1\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7"+
		"\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01ba\3\2\2\2\u01b9\u01b7\3\2"+
		"\2\2\u01ba\u01bb\7$\2\2\u01bb~\3\2\2\2\u01bc\u01c5\7$\2\2\u01bd\u01c4"+
		"\5{>\2\u01be\u01c4\7\f\2\2\u01bf\u01c0\7^\2\2\u01c0\u01c4\7$\2\2\u01c1"+
		"\u01c2\7^\2\2\u01c2\u01c4\7^\2\2\u01c3\u01bd\3\2\2\2\u01c3\u01be\3\2\2"+
		"\2\u01c3\u01bf\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3"+
		"\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8"+
		"\u01c9\7$\2\2\u01c9\u0080\3\2\2\2\u01ca\u01cb\7\61\2\2\u01cb\u01cc\7,"+
		"\2\2\u01cc\u01d0\3\2\2\2\u01cd\u01cf\13\2\2\2\u01ce\u01cd\3\2\2\2\u01cf"+
		"\u01d2\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d3\3\2"+
		"\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d4\7,\2\2\u01d4\u01d5\7\61\2\2\u01d5"+
		"\u0082\3\2\2\2\u01d6\u01d7\7\61\2\2\u01d7\u01d8\7\61\2\2\u01d8\u01dc\3"+
		"\2\2\2\u01d9\u01db\n\f\2\2\u01da\u01d9\3\2\2\2\u01db\u01de\3\2\2\2\u01dc"+
		"\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u0084\3\2\2\2\u01de\u01dc\3\2"+
		"\2\2\u01df\u01e0\7\f\2\2\u01e0\u0086\3\2\2\2\u01e1\u01e2\7\13\2\2\u01e2"+
		"\u0088\3\2\2\2\u01e3\u01e4\7\"\2\2\u01e4\u008a\3\2\2\2\u01e5\u01e6\7\17"+
		"\2\2\u01e6\u008c\3\2\2\2\u01e7\u01ee\5\u0089E\2\u01e8\u01ee\5\u0087D\2"+
		"\u01e9\u01ee\5\u0085C\2\u01ea\u01ee\5\u008bF\2\u01eb\u01ee\5\u0081A\2"+
		"\u01ec\u01ee\5\u0083B\2\u01ed\u01e7\3\2\2\2\u01ed\u01e8\3\2\2\2\u01ed"+
		"\u01e9\3\2\2\2\u01ed\u01ea\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ec\3\2"+
		"\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\bG\2\2\u01f0\u008e\3\2\2\2\u01f1"+
		"\u01f7\5/\30\2\u01f2\u01f7\5-\27\2\u01f3\u01f7\5C\"\2\u01f4\u01f7\5;\36"+
		"\2\u01f5\u01f7\7a\2\2\u01f6\u01f1\3\2\2\2\u01f6\u01f2\3\2\2\2\u01f6\u01f3"+
		"\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u0090\3\2\2\2\u01fa\u01fb\7%"+
		"\2\2\u01fb\u01fc\7k\2\2\u01fc\u01fd\7p\2\2\u01fd\u01fe\7e\2\2\u01fe\u01ff"+
		"\7n\2\2\u01ff\u0200\7w\2\2\u0200\u0201\7f\2\2\u0201\u0202\7g\2\2\u0202"+
		"\u0206\3\2\2\2\u0203\u0205\5\u0089E\2\u0204\u0203\3\2\2\2\u0205\u0208"+
		"\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0209\3\2\2\2\u0208"+
		"\u0206\3\2\2\2\u0209\u020a\7$\2\2\u020a\u020b\5\u008fH\2\u020b\u020c\7"+
		"$\2\2\u020c\u020d\bI\3\2\u020d\u0092\3\2\2\2\34\2\u0122\u0127\u0129\u0130"+
		"\u0171\u0174\u0179\u017d\u018b\u018f\u0192\u0197\u019d\u01a7\u01ab\u01b5"+
		"\u01b7\u01c3\u01c5\u01d0\u01dc\u01ed\u01f6\u01f8\u0206\4\3G\2\3I\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}