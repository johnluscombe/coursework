// S -> BRT
// B -> ON
// R -> X|X;R|""
// X -> C|C:V
// C -> D
// V -> L|L,V
// L -> D|D-D
// T -> (N)|""
// O -> digit|""
// D -> digit|digit D
// N -> letter|letter N

#include <stdio.h>
#include <stdlib.h>

char lookahead;

int is_digit(char c) { return c >= '0' && c <= '9'; }
int is_letter(char c) { return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'); }
int is_newline(char c) { return c == '\n' || c == '\r'; }
int is_whitespace(char c) { return c == ' ' || c == '\t'; }

// check that c is a valid character
int check(char c) {
    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == ',' ||
        (c == ';' || c == ':' || c == '(' || c == ')' || c == '-' || is_newline(c))) return 1;
    else return 0;
}

// advance to next character
char next() {
    char c = getchar();
    while (is_whitespace(c)) c = getchar();
    if (check(c)) return c;
    else {
        printf("Invalid Bible reference: invalid character '%c'\n", c);
        exit(0);
    }
}

// make sure the current character is c, then advance to next
void match(char c) {
    if (lookahead == c) lookahead = next();
    else {
        printf("Invalid Bible reference: '%c' expected, '%c' found\n", c, lookahead);
        exit(0);
    }
}

// S -> BRT
parse_S() {
    parse_B();
    parse_R();
    parse_T();
}

// B -> ON
parse_B() {
    if (is_digit(lookahead) || is_letter(lookahead)) {
        parse_O();
        parse_N();
    } else {
        printf("Invalid Bible reference: parsing book, '%c' found\n", lookahead);
        exit(0);
    }
}

// R -> X|X;R|""
parse_R() {
    if (is_digit(lookahead)) {
        parse_X();
        if (lookahead == ';') {
            match(';');
            parse_R();
        }
    } else if (lookahead != '(' && !is_newline(lookahead)) {
        printf("Invalid Bible reference: parsing reference, '%c' found\n", lookahead);
        exit(0);
    }
}

// X -> C|C:V
parse_X() {
    parse_C();
    if (lookahead == ':') {
        match(':');
        parse_V();
    }
}

// C -> D
parse_C() { parse_D(); }

// V -> L|L,V
parse_V() {
    parse_L();
    if (lookahead == ',') {
        match(',');
        parse_V();
    }
}

// L -> D|D-D
parse_L() {
    parse_D();
    if (lookahead == '-') {
        match('-');
        parse_D();
    }
}

// T -> (N)|""
parse_T() {
    if (lookahead == '(') {
        match('(');
        parse_N();
        match(')');
    } else if (lookahead != '(' && !is_newline(lookahead)) {
        printf("Invalid Bible reference: parsing translation, '%c' found\n", lookahead);
        exit(0);
    }
}

// O -> digit|""
parse_O() { if (is_digit(lookahead)) parse_digit(); }

// D -> digit|digit D
parse_D() {
    parse_digit();
    if (is_digit(lookahead)) parse_D();
}

// N -> letter|letter N
parse_N() {
    parse_letter();
    if (is_letter(lookahead)) parse_N();
}

parse_digit() {
    if (is_digit(lookahead)) match(lookahead);
    else {
        printf("Invalid Bible reference: parsing digit, '%c' found\n", lookahead);
        exit(0);
    }
}

parse_letter() {
    if (is_letter(lookahead)) match(lookahead);
    else {
        printf("Invalid Bible reference: parsing letter, '%c' found\n", lookahead);
        exit(0);
    }
}

int main() {
    printf("Enter Bible reference to check: ");
    lookahead = next();
    parse_S();
    printf("Valid Bible reference!\n");
    exit(0);
}