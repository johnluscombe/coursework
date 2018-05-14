grammar QuizGeneratorRecognizer;

        file : o_block q_blocks;
     o_block : ('(OP)' more_options 'END')?;
more_options : option (more_options)?;
      option : '|' key '=' value;
    q_blocks : (q_block q_blocks)?;
     q_block : string i_choices c_choice i_choices 'END';
   i_choices : (i_choice i_choices)?;
    i_choice : '|' string;
    c_choice : '>' string;
         key : LETTER ( DIGIT | LETTER | CHAR )*;
       value : (LETTER | DIGIT)+;
      string : (DIGIT | LETTER | CHAR)+;

       DIGIT : [0-9];
      LETTER : [a-zA-Z];
        CHAR : ["#$%&'()*+,\-./:;<=>?@\\[\]^_`}|{~];
          WS : [ \t\r\n] -> skip;