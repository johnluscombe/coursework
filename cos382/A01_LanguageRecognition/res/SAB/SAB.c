// RDP parser for simple language SAB (grammar below)
// lexer is very simple - tokens are all single characters
// all characters must be 'a', 'b', 'c', 'd' or new line ('\n')

// S -> aA | bB
// A -> bc | cB
// B -> cd | dA

#include <stdio.h>
#include <stdlib.h>

char lookahead;     // current character

// advance to next character
char next() {
    char t = getchar();
    if (t >= 'a' && t <= 'd' || t == '\n') return t;
    else {
        printf("Error: invalid character '%c'\n", t);
        exit(0);
    }
}

// make sure the current character is c, then advance to next
void match(char c) {
    if (lookahead == c) lookahead = next();
    else {
        printf("Error: '%c' expected, '%c' found\n", c, lookahead);
        exit(0);
    }
}

// S -> aA | bB
parse_S() {
    if (lookahead == 'a') {
        // S -> aA
        match('a');
        parse_A();
    }
    else if (lookahead == 'b') {
        // S -> bB
        match('b');
        parse_B();
    }
    else {
        printf("Error: parsing S, '%c' found\n", lookahead);
        exit(0);
    }
}

// A -> bc | cB
parse_A() {
    if (lookahead == 'b') {
        // A -> bc
        match('b');
        match('c');
    }
    else if (lookahead == 'c') {
        // A -> cB
        match('c');
        parse_B();
    }
    else {
      printf("Error: parsing A, '%c' found\n", lookahead);
      exit(0);
    }
}

// B -> cd | dA
parse_B() {
    if (lookahead == 'c') {
        // B -> cd
        match('c');
        match('d');
    }
    else if (lookahead == 'd') {
        // B -> dA
        match('d');
        parse_A();
    }
    else {
        printf("Error: parsing B, '%c' found\n", lookahead);
        exit(0);
    }
}

int main( ) {
    lookahead = next();
    parse_S();
    printf("String successfully parsed\n");
    exit(0);
}