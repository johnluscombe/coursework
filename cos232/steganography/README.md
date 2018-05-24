# Steganography

## Assignment Purpose

The purpose of this assignment was to encode a secret message in an
uncompressed BMP file. To do so, we were to use the least significant bit in
the RGB pixels. For example, say the first eight bytes were as follows:

```
00101100 00011101 00000111 00001010 00011000 01101111 01110000 01011110
Red    ^ Green  ^ Blue   ^ Red    ^ Green  ^ Blue   ^ Red    ^ Green  ^
```

Getting the least significant bits of these bytes results in the following
binary sequence:

```
01100100
```

In decimal, this binary number is 100, which converts to the ASCII character
'd'. Repeating this process until a null byte is hit (`00000000`) will
successfully decode the encoded message. Since only the least significant bit
is getting changed, it will result in an indistinguishable difference from the
original image.

My source code can be seen in `encoder.c`.

## Credit

- **Assignment Author**: Dr. Dannie Stanley, PhD