#include "../../shared/header/shared.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void editStudentName(char*** studentNamesPtr) {
    char** studentNames = *studentNamesPtr;
    short studentIdx = getStudentIdx(studentNames);
    char* newStudentName = malloc(32);

    printf("New student name: ");
    fgets(newStudentName, 32, stdin);
    newStudentName[strlen(newStudentName)-1] = '\0';

    while (strlen(newStudentName) == 0) {
        printf("Sorry, student name cannot be empty.\n");
        printf("New student name: ");
        fgets(newStudentName, 32, stdin);
    }

    while (strlen(newStudentName) >= 32) {
        printf("Sorry, student name must be less than 32 characters.\n");
        printf("New student name: ");
        fgets(newStudentName, 32, stdin);
    }

    studentNames[studentIdx] = newStudentName;
    free(newStudentName);
    *studentNamesPtr = studentNames;
}