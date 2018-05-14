grammar LanguageTranslationActions;

@header {
    import java.util.Enumeration;
    import java.util.Hashtable;
}

start locals [Hashtable<String, String> symbolTable = new Hashtable<>();] :
    list {System.out.println("eof");} 'EOF'
    {
        Enumeration<String> keys = $start::symbolTable.keys();
        StringBuilder symbolTableString = new StringBuilder();

        while (keys.hasMoreElements()) {
            symbolTableString.append(keys.nextElement());
            symbolTableString.append(", ");
        }

        int deleteStart = symbolTableString.length()-2;
        int deleteEnd = symbolTableString.length();
        symbolTableString.delete(deleteStart, deleteEnd);
        System.out.println("Symbol Table: " + symbolTableString.toString());

        System.out.println();
    };

list : (expr ';' {System.out.println(";");} list)?;
expr : term terms;
terms : ('+' term {System.out.print("+ ");} terms
      | '-' term {System.out.print("- ");} terms)?;
term : factor factors;
factors : ('*' factor {System.out.print("* ");} factors
        | '/' factor {System.out.print("/ ");} factors
        | 'MOD' factor {System.out.print("MOD ");} factors)?;
factor : '(' expr ')'
       | ID {
                System.out.print($ID.text + " ");
                $start::symbolTable.put($ID.text, "");
            }
       | NUM {System.out.print($NUM.text + " ");};

ID : LETTER (LETTER | DIGIT)*;
NUM : DIGIT (DIGIT)*;

DIGIT   : [0-9] ;
LETTER  : [a-zA-Z] ;
WS      : [ \t\r\n] -> skip ;