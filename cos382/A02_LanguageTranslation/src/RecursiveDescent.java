/*
 * START -> LIST eof {print 'EOF'; dump symbol table}
 * LIST -> EXPR ';' {print ';'} LIST
 *       | ""
 * EXPR -> TERM TERMS
 * TERMS -> '+' TERM {print '+'} TERMS
 *        | '-' TERM {print '-'} TERMS
 *        | ""
 * TERM -> FACTOR FACTORS
 * FACTORS -> '*' FACTOR {print '*'} FACTORS
 *          | '/' FACTOR {print '/'} FACTORS
 *          | mod FACTOR {print 'mod'} FACTORS
 *          | ""
 * FACTOR -> '(' EXPR ')'
 *         | id {print ID.name}
 *         | num {print NUM.value}
 *
 * mod -> 'MOD'
 * eof -> 'EOF'
 * id -> letter (letter | digit)*
 * num -> digit (digit)*
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Hashtable;

public class RecursiveDescent {
    private String fileString;
    private int fileStringPtr = -1;
    private char lookahead;
    private Hashtable<String, String> symbolTable = new Hashtable<>();


    private RecursiveDescent(String path) {
        Path file = Paths.get(path);
        byte[] fileArray;

        try {
            fileArray = Files.readAllBytes(file);
            fileString = get_string_from_byte_array(fileArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        lookahead = next();
        parse_START();
    }


    private String get_string_from_byte_array(byte[] byteArray) {
        StringBuilder string = new StringBuilder();
        for (byte b : byteArray) {
            string.append((char)b);
        }
        return string.toString();
    }


    private void print(char c) {
        System.out.print(c);
        System.out.print(' ');
    }

    private void print(String s) {
        System.out.print(s);
        System.out.print(' ');
    }


    private boolean is_digit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean is_letter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean is_operator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean is_other_valid_char(char c) {
        return c == ';' || c == '(' || c == ')' || c == '\0';
    }

    private boolean is_newline(char c) {
        return c == '\n' || c == '\r';
    }

    private boolean is_whitespace(char c) {
        return c == ' ' || c == '\t';
    }


    // check that c is a valid character
    private boolean check(char c) {
        return (is_letter(c) || is_digit(c) || is_operator(c) || is_other_valid_char(c));
    }


    // make sure the current character is c, then advance to next
    private void match(char c) {
        if (lookahead == c) lookahead = next();
        else {
            System.out.println(String.format("Invalid syntax: '%1c' expected, '%2c' found", c, lookahead));
            System.exit(1);
        }
    }

    private void match(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            match(c);
        }
    }


    // advance to the next character
    private char next() {
        char c = getchar();
        while (is_whitespace(c) || is_newline(c)) c = getchar();
        if (check(c)) return c;
        else {
            System.out.println(String.format("Invalid syntax: invalid character '%c'", c));
            System.exit(1);
            return 1;
        }
    }


    // mimics the getchar() function from C language
    private char getchar() {
        fileStringPtr++;
        if (fileStringPtr < fileString.length()) {
            return fileString.charAt(fileStringPtr);
        }
        return '\0';
    }


    // START -> LIST eof {print 'EOF'; dump symbol table}
    private void parse_START() {
        parse_LIST();
        match("EOF");
        System.out.println("eof");

        System.out.print("Symbol Table: ");
        Enumeration<String> keys = symbolTable.keys();
        StringBuilder symbolTableString = new StringBuilder();

        while (keys.hasMoreElements()) {
            symbolTableString.append(keys.nextElement());
            symbolTableString.append(", ");
        }

        int deleteStart = symbolTableString.length()-2;
        int deleteEnd = symbolTableString.length();
        symbolTableString.delete(deleteStart, deleteEnd);
        System.out.println(symbolTableString.toString());

        System.out.println();
    }


    /* LIST -> EXPR ';' {print ';'} LIST
     *       | ""
     */
    private void parse_LIST() {
        int start = fileStringPtr;
        int end = fileStringPtr + 3;
        String substring = fileString.substring(start, end);
        if ((lookahead == '(' || is_digit(lookahead) || is_letter(lookahead)) &&
                !substring.equals("EOF")) {
            parse_EXPR();
            match(';');
            System.out.println(';');
            parse_LIST();
        }
    }


    // EXPR -> TERM TERMS
    private void parse_EXPR() {
        parse_TERM();
        parse_TERMS();
    }


    /* TERMS -> '+' TERM {print '+'} TERMS
     *        | '-' TERM {print '-'} TERMS
     *        | ""
     */
    private void parse_TERMS() {
        if (lookahead == '+' || lookahead == '-') {
            char operator = lookahead;
            match(operator);
            parse_TERM();
            print(operator);
            parse_TERMS();
        }
    }


    // TERM -> FACTOR FACTORS
    private void parse_TERM() {
        parse_FACTOR();
        parse_FACTORS();
    }


    /* FACTORS -> '*' FACTOR {print '*'} FACTORS
     *          | '/' FACTOR {print '/'} FACTORS
     *          | mod FACTOR {print 'MOD'} FACTORS
     *          | ""
     */
    private void parse_FACTORS() {
        int start = fileStringPtr;
        int end = fileStringPtr + 3;
        String substring = fileString.substring(start, end);
        if (lookahead == '*' || lookahead == '/') {
            char operator = lookahead;
            match(operator);
            parse_FACTOR();
            print(operator);
            parse_FACTORS();
        } else if (substring.equals("MOD")) {
            match("MOD");
            parse_FACTOR();
            print("MOD");
            parse_FACTORS();
        }
    }


    /* FACTOR -> '(' EXPR ')'
     * id {print ID.name}
     * num {print NUM.value}
     */
    private void parse_FACTOR() {
        if (lookahead == '(') {
            match('(');
            parse_EXPR();
            match(')');
        } else if (is_letter(lookahead)) {
            parse_id();
        } else if (is_digit(lookahead)) {
            parse_num();
        }
    }


    // letter (letter | digit)*
    private void parse_id() {
        StringBuilder id = new StringBuilder();
        char letter = parse_letter();
        id.append(letter);
        while (is_letter(lookahead) || is_digit(lookahead)) {
            if (is_letter(lookahead)) {
                letter = parse_letter();
                id.append(letter);
            } else {
                letter = parse_digit();
                id.append(letter);
            }
        }
        System.out.print(" ");
        symbolTable.put(id.toString(), "");
    }


    // digit (digit)*
    private void parse_num() {
        parse_digit();
        while (is_digit(lookahead)) parse_digit();
        System.out.print(" ");
    }


    private char parse_digit() {
        if (is_digit(lookahead)) {
            char c = lookahead;
            match(c);
            System.out.print(c);
            return c;
        } else {
            System.out.println(String.format("Invalid syntax: parsing digit, '%c' found", lookahead));
            System.exit(1);
            return '\0';
        }
    }


    private char parse_letter() {
        if (is_letter(lookahead)) {
            char c = lookahead;
            match(c);
            System.out.print(c);
            return c;
        } else {
            System.out.println(String.format("Invalid syntax: parsing letter, '%c' found", lookahead));
            System.exit(1);
            return '\0';
        }
    }


    public static void main(String[] args) {
        new RecursiveDescent("src/input.txt");
    }
}
