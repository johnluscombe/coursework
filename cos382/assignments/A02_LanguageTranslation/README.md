# Language Translation

## Assignment Purpose

The purpose of this assignment was to implement various approaches of
translating from one language to another. The approaches were as follows:

- **Recursive Descent Program**.
- **ANTLR with Actions**.
- **ANTLR with Listener/Visitor**.

For this assignment, we were to recognize infix arithmetic expressions and
translate the input to postfix or Reverse Polish Notation (RPN).

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