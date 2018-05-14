grammar LanguageTranslationListener;

start   : list 'EOF';
list    : (expr ';' list)?;
expr    : term terms;
terms   : ('+' term terms
        | '-' term terms)?;
term    : factor factors;
factors : ('*' factor factors
        | '/' factor factors
        | 'MOD' factor factors)?;
factor  : '(' expr ')'
        | ID
        | NUM;

ID      : LETTER (LETTER | DIGIT)*;
NUM     : DIGIT (DIGIT)*;

DIGIT   : [0-9] ;
LETTER  : [a-zA-Z] ;
WS      : [ \t\r\n] -> skip ;