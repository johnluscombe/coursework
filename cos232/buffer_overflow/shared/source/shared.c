#include <stdio.h>
#include <stdlib.h>
#include <string.h>

FILE* getFileObject(char* mode) {
    size_t fileNameSize = 0;
    size_t fileNameCapacity = 32;
    char* fileName = calloc(fileNameCapacity, 1);

    printf("File name: ");

    char c = (char)getchar();

    while (c != '\n') {
        if (fileNameSize == fileNameCapacity) {
            fileNameCapacity += 32;
            fileName = realloc(fileName, fileNameCapacity);
        }
        strncat(fileName, &c, 1);
        fileNameSize++;
        c = (char)getchar();
    }

    FILE* fileObject = fopen(fileName, mode);
    free(fileName);
    return fileObject;
}

short stringArrayLength(char** arr) {
    short count = 0;
    short idx = 0;
    while (arr[idx] != NULL) {
        count++;
        idx++;
    }
    return count;
}

short shortArrayLength(const short* arr) {
    short count = 0;
    short idx = 0;
    while (arr[idx] != 0) {
        count++;
        idx++;
    }
    return count;
}

short floatArrayLength(const float* arr) {
    short count = 0;
    short idx = 0;
    while (arr[idx] != 0.0) {
        count++;
        idx++;
    }
    return count;
}

void repeatChar(char c, int times) {
    for (short i = 0; i < times; i++) {
        printf("%c",c);
    }
}

short getAssignmentIdx(char** assignmentNames) {
    char* assignmentName = malloc(32);
    short assignmentIdx = -1;

    while (assignmentIdx == -1) {
        printf("Old assignment name: ");
        fgets(assignmentName, 32, stdin);
        assignmentName[strlen(assignmentName)-1] = '\0';

        for (short assignmentNum = 0; assignmentNum < stringArrayLength(assignmentNames); assignmentNum++) {
            if (strcmp(assignmentName, assignmentNames[assignmentNum]) == 0) {
                assignmentIdx = assignmentNum;
                break;
            }
        }

        if (assignmentIdx == -1) {
            printf("Sorry, assignment name could not be found. Try again.\n");
        }
    }

    free(assignmentName);
    return assignmentIdx;
}

short getStudentIdx(char** studentNames) {
    char* studentName = malloc(32);
    short studentIdx = -1;

    while (studentIdx == -1) {
        printf("Old student name: ");
        fgets(studentName, 32, stdin);
        studentName[strlen(studentName)-1] = '\0';

        for (short studentNum = 0; studentNum < stringArrayLength(studentNames); studentNum++) {
            if (strcmp(studentName, studentNames[studentNum]) == 0) {
                studentIdx = studentNum;
                break;
            }
        }

        if (studentIdx == -1) {
            printf("Sorry, student name could not be found. Try again.\n");
        }
    }

    free(studentName);
    return studentIdx;
}