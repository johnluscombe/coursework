grammar QuizGen;

        file : o_block q_blocks;
     o_block : ('(OP)' VWS+ more_options 'END' VWS+)?;
more_options : option VWS+ (more_options)?;
      option : '|' HWS* key HWS* '=' HWS* value;
    q_blocks : q_block (q_blocks)?;
     q_block : string VWS+ i_choices c_choice i_choices 'END' VWS+;
   i_choices : (i_choice i_choices)?;
    i_choice : '|' string VWS+;
    c_choice : '>' string VWS+;
         key : LETTER ( DIGIT | LETTER | CHAR )*;
       value : (LETTER | DIGIT | HWS)+;
      string : (DIGIT | LETTER | CHAR | HWS)+;

       DIGIT : [0-9];
      LETTER : [a-zA-Z];
        CHAR : ["#$%&'()*+,\-./:;<=>?@\\[\]^_`}|{~];
         HWS : [ \t];
         VWS : [\r\n];