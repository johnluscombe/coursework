#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>

char isNum(char* string) {
    if (strlen(string) <= 32767) {
        for (char i = 0; i < strlen(string); i++) {
            if (string[i] < '0' || string[i] > '9') {
                if (i != 0 || string[i] != '-') {
                    return 0;
                }
            }
        }
    }

    return 1;
}

int strKeyToIntKey(char* stringKey) {
    long value = strtol(stringKey, 0, 10);

    if (value > 2147483647) {
        printf("Invalid key: must be 2147483647 or less\n");
        exit(1);
    }

    if (value < -2147483647) {
        printf("Invalid key: must be -2147483647 or more\n");
        exit(1);
    }

    return (int)value;
}

char containsString(int argc, char* argv[], char* elem) {
    for (int i = 1; i < argc; i++) {
        if (strcmp(argv[i], elem) == 0) {
            return 1;
        }
    }
    return 0;
}

char getKeyIdx(int argc, char* argv[]) {
    char idx = -1;
    char numKeys = 0;

    for (char i = 1; i < argc; i++) {
        if (isNum(argv[i])) {
            idx = i;
            numKeys++;
        }

        if (numKeys > 1) {
            printf("Error: More than one key detected\n");
            exit(1);
        }
    }

    return idx;
}

int getKey(int argc, char* argv[], int defaultKey) {
    int key;
    int keyIdx = getKeyIdx(argc, argv);

    if (keyIdx != -1) {
        key = strKeyToIntKey(argv[keyIdx]);
    } else {
        key = defaultKey;
    }

    return key;
}

char getFileIdx(int argc, char* argv[]) {
    char idx = -1;
    char numFiles = 0;

    for (char i = 1; i < argc; i++) {
        if (access(argv[i], F_OK) != -1) {
            idx = i;
            numFiles++;
        }

        if (numFiles > 1) {
            printf("Error: More than one file detected\n");
            exit(1);
        }
    }

    return idx;
}

char* getFile(int argc, char* argv[]) {
    char* file;
    int fileIdx = getFileIdx(argc, argv);

    if (fileIdx != -1) {
        file = argv[fileIdx];
    } else {
        file = "";
    }

    return file;
}

void parseArgs(int argc, char* argv[], int* key, char** inputFilePath) {
    if (argc > 4) {
        printf("Too many arguments: 4 received, at most 3 expected\n");
        exit(1);
    }

    *key = getKey(argc, argv, *key);

    if (containsString(argc, argv, "-d")) {
        if (containsString(argc, argv, "-e")) {
            printf("Error: Both decrypt mode and encrypt mode specified\n");
            exit(1);
        }
        *key *= -1;
    }

    *inputFilePath = getFile(argc, argv);
}

char cipherChar(char plainChar, int key) {
    int ascii;

    if (65 <= plainChar && plainChar <= 90) {
        ascii = plainChar + key;
        while (ascii > 90) {
            ascii -= 26;
        }
        while (ascii < 65) {
            ascii += 26;
        }
    } else if (97 <= plainChar && plainChar <= 122) {
        ascii = plainChar + key;
        while (ascii > 122) {
            ascii -= 26;
        }
        while (ascii < 97) {
            ascii += 26;
        }
    } else {
        ascii = plainChar;
    }

    return (char)ascii;
}

void printCipherText(char* inputFilePath, int key) {
    FILE* file;
    char pChar, cChar;

    if (strcmp(inputFilePath, "") != 0) {
        file = fopen(inputFilePath, "r");
    } else {
        file = stdin;
    }

    while ((pChar = (char)fgetc(file)) != EOF) {
        cChar = cipherChar(pChar, key);
        printf("%c", cChar);
    }
}

int main(int argc, char* argv[]) {
    int key = 7;
    char* inputFilePath = "";

    parseArgs(argc, argv, &key, &inputFilePath);
    printCipherText(inputFilePath, key);

    return 0;
}