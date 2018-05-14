#include "../../shared/header/shared.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* getAssignmentName() {
    char* newAssignmentName = malloc(32);

    printf("Assignment name: ");
    fgets(newAssignmentName, 32, stdin);
    newAssignmentName[strlen(newAssignmentName)-1] = '\0';

    while (strlen(newAssignmentName) == 0) {
        printf("Sorry, assignment name cannot be empty.\n");
        printf("Assignment name: ");
        fgets(newAssignmentName, 32, stdin);
    }

    while (strlen(newAssignmentName) >= 32) {
        printf("Sorry, assignment name must be less than 32 characters.\n");
        printf("Assignment name: ");
        fgets(newAssignmentName, 32, stdin);
    }

    return newAssignmentName;
}

short getAssignmentTotal() {
    char* newTotalString = malloc(5);
    short newTotal;
    char* ptr;

    printf("Assignment total: ");
    fgets(newTotalString, 5, stdin);

    while (strlen(newTotalString) == 5) {
        printf("Sorry, maximum total is 9999.\n");
        printf("Assignment total: ");
        fgets(newTotalString, 5, stdin);
    }

    if (strlen(newTotalString) == 0) {
        newTotal = 0;
    } else {
        newTotal = (short)strtol(newTotalString, &ptr, 10);
    }

    free(newTotalString);
    return newTotal;
}

void addAssignment(char*** assignmentNamesPtr, short** assignmentTotalsPtr, float*** scoresPtr, char** studentNames) {
    char** assignmentNames = *assignmentNamesPtr;
    short assignmentNamesSize = stringArrayLength(assignmentNames);

    short* assignmentTotals = *assignmentTotalsPtr;
    short assignmentTotalsSize = shortArrayLength(assignmentTotals);

    float** scores = *scoresPtr;
    short studentScoresSize;

    char* assignmentName = getAssignmentName();
    short assignmentTotal = getAssignmentTotal();

    assignmentNames[assignmentNamesSize] = assignmentName;
    assignmentTotals[assignmentTotalsSize] = assignmentTotal;

    for (short studentNum = 0; studentNum < stringArrayLength(studentNames); studentNum++) {
        studentScoresSize = floatArrayLength(scores[studentNum]);
        scores[studentNum][studentScoresSize] = 0;
    }

    *assignmentNamesPtr = assignmentNames;
    *assignmentTotalsPtr = assignmentTotals;
    *scoresPtr = scores;
}