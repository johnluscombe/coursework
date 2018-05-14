#include "../../shared/header/shared.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* getStudentName() {
    char* newStudentName = malloc(32);

    printf("Student name: ");
    fgets(newStudentName, 30, stdin);

    while (strlen(newStudentName) == 0) {
        printf("Sorry, student name cannot be empty.\n");
        printf("Student name: ");
        fgets(newStudentName, 30, stdin);
    }

    if (strlen(newStudentName) == 30) {
        newStudentName[29] = '\0';
        strcat(newStudentName, "...");
    }

    return newStudentName;
}

void addStudent(char*** studentNamesPtr, float*** scoresPtr, char** assignmentNames) {
    char** studentNames = *studentNamesPtr;
    short studentNamesSize = stringArrayLength(studentNames);
    float** scores = *scoresPtr;
    char* studentName = getStudentName();

    studentNames[studentNamesSize] = studentName;

    for (short assignmentNum = 0; assignmentNum < stringArrayLength(assignmentNames); assignmentNum++) {
        scores[studentNamesSize][assignmentNum] = 0;
    }

    *studentNamesPtr = studentNames;
    *scoresPtr = scores;
}