grammar LanguageRecognition;

s : b r t;
b : o n ;
r : (x (';' r)*)? ;
x : c (':' v)? ;
c : d ;
v : l (',' v)* ;
l : d ('-' d)? ;
t : ('(' n ')')? ;
o : Digit? ;
d : Digit+ ;
n : Letter+ ;

Digit   : [0-9] ;
Letter  : [a-zA-Z] ;
WS      : [ \t] -> skip ;