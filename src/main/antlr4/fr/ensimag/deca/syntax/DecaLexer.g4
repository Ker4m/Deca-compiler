lexer grammar DecaLexer;

options {
   language=Java;
   // Tell ANTLR to make the generated lexer class extend the
   // the named class, which is where any supporting code and
   // variables will be placed.
   superClass = AbstractDecaLexer;
}

@members {
}

// Mots réservés
ASM : 'asm';
CLASS : 'class';
EXTENDS : 'extends';
ELSE : 'else';
FALSE : 'false';
IF : 'if';
INSTANCEOF : 'instanceof';
NEW : 'new';
NULL : 'null';
READINT : 'readInt';
READFLOAT : 'readFloat';
PRINT : 'print';
PRINTLN : 'println';
PRINTLNX : 'printlnx';
PRINTX : 'printx';
PROTECTED : 'protected';
RETURN : 'return';
THIS : 'this';
TRUE : 'true';
WHILE : 'while';
FOR : 'for';


// Identificateurs
fragment DIGIT : [0-9];
fragment LETTER : [a-zA-Z];
IDENT : (LETTER | '$' | '_')(LETTER | DIGIT | '$' | '_')* (OBRACKET CBRACKET | /*epsilon*/);


// Symboles spéciaux
LT: '<';
GT: '>';
EQUALS: '=';
PLUS: '+';
MINUS: '-';
TIMES: '*';
SLASH: '/';
PERCENT: '%';
DOT: '.';
COMMA: ',';
OPARENT: '(';
CPARENT: ')';
OBRACE: '{';
CBRACE: '}';
EXCLAM: '!';
SEMI: ';' ;
EQEQ: '==';
NEQ: '!=';
GEQ: '>=';
LEQ: '<=';
AND: '&&';
OR: '||';
OBRACKET: '[';
CBRACKET: ']';
COL: ':';


// Littéraux entiers
fragment POSITIVE_DIGIT : [1-9];
INT : '0' | POSITIVE_DIGIT DIGIT*;


// Littéraux flottants
fragment NUM : DIGIT+;
fragment SIGN : '+' | '-' | /*epsilon*/;
fragment EXP : ('E' | 'e') SIGN NUM;
fragment DEC : NUM '.' NUM;
fragment FLOATDEC :(DEC | DEC EXP) ('F' | 'f' | /*epsilon*/);
fragment DIGITHEX : [0-9] | [a-f] | [A-F];
fragment NUMHEX : DIGITHEX+;
fragment FLOATHEX : ('0x' | '0X') NUMHEX '.' NUMHEX ('P' | 'p') SIGN NUM ('F' | 'f' | /*epsilon*/);
FLOAT : FLOATDEC | FLOATHEX;


// Chaînes de caractères
fragment STRING_CAR : ~('"' | '\\' | '\n'); // EOL au lieu de '\n' renvoie une erreur sur l'IDE
STRING : '"' (STRING_CAR | '\\"' | '\\\\')* '"';
MULTI_LINE_STRING : '"' (STRING_CAR | '\n' | '\\"' | '\\\\')* '"';

// Tableaux
//ARRAY : ('int' | 'float') OBRACKET CBRACKET;

// Commentaires
fragment COMMENT : '/*' .*? '*/';
fragment MONO_LINE_COMMENT : '//' ~[\r\n]*; // EOL au lieu de '\n' renvoie une erreur sur l'IDE

// Séparateurs
fragment EOL: '\n';
fragment TAB: '\t';
fragment SPACE: ' ';
fragment RCAR: '\r';
SEP : (SPACE | TAB | EOL | RCAR | COMMENT | MONO_LINE_COMMENT) {skip();};

// Inclusion de fichier
fragment FILENAME : (LETTER | DIGIT | DOT | MINUS | '_')+;
INCLUDE : '#include' (SPACE)* '"' FILENAME '"'
      { doInclude(getText()); };
