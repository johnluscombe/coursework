# Language Translation

## Assignment Purpose

The purpose of this assignment was to implement various approaches of
translating from one language to another. The approaches were as follows:

- **Recursive Descent Program**. See `src/RecursiveDescent.java` for my
  implementation.
- **ANTLR with Actions**. See `src/LanguageTranslationActions.g4` for my ANTLR
  grammar, and the files in the `actions` directory for the Java code.
- **ANTLR with Listener/Visitor**. See `src/LanguageTranslationListener.g4` for
  my ANTLR grammar, and the files in the `listener` directory for the Java
  code.

For this assignment, we were to recognize infix arithmetic expressions and
translate the input to postfix or Reverse Polish Notation (RPN).
o
Example Input:
```
2 + 43 * AB; 4 + f;
    8 * 5 + ty6 / (7 MOD
    3); EOF
```

Example Output:
```
2 43 AB * + ;
4 f + ;
8 5 * ty6 7 3 MOD / + ;
eof
Symbol Table: ty6, AB, f
```

## Credit

- **Assignment Author**: Dr. Jonathan Denning, PhD