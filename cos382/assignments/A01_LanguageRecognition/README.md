# Language Recognition

## Assignment Purpose

The purpose of this assignment was to implement various approaches of
recognizing sentences of a simple language. The approaches were as follows:

- **Recursive Descent Parser (RDP) in C**. See `LanguageRecognition.c` for my
  implementation.
- **ANTLR Code and Java**. See `LanguageRecognition.g4` for the ANTLR grammar,
  and the files in the `src` directory for the Java code.
- **Regular Expression in Perl**. See `LanguageRecognition.pl` for my
  implementation.

For this assignment, we were to write programs that recognized valid Bible
verse formats from invalid ones. We were not concerned with correct book names,
existence of chapters/verses, etc. Examples of valid formats included:

- `John`
- `1 John 1:2-4`
- `Ps 12:1,3-4`
- `Rev 2:4;4:3-6 (NASB)`
- `9 Matthew 77:190-314 (MyOwnVersion)`

## Credit

- **Assignment Author**: Dr. Jonathan Denning, PhD