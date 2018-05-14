#include "../../shared/header/shared.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void editAssignmentName(char*** assignmentNamesPtr) {
    char** assignmentNames = *assignmentNamesPtr;
    short assignmentIdx = getAssignmentIdx(assignmentNames);
    char* newAssignmentName = malloc(32);

    printf("New assignment name: ");
    fgets(newAssignmentName, 32, stdin);
    newAssignmentName[strlen(newAssignmentName)-1] = '\0';

    while (strlen(newAssignmentName) == 0) {
        printf("Sorry, assignment name cannot be empty.\n");
        printf("New assignment name: ");
        fgets(newAssignmentName, 32, stdin);
    }

    while (strlen(newAssignmentName) >= 32) {
        printf("Sorry, assignment name must be less than 32 characters.\n");
        printf("New assignment name: ");
        fgets(newAssignmentName, 32, stdin);
    }

    assignmentNames[assignmentIdx] = newAssignmentName;
    free(newAssignmentName);
    *assignmentNamesPtr = assignmentNames;
}

void editAssignmentTotal(short** assignmentTotalsPtr, char** assignmentNames) {
    short* assignmentTotals = *assignmentTotalsPtr;
    short assignmentIdx = getAssignmentIdx(assignmentNames);
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

    assignmentTotals[assignmentIdx] = newTotal;
    free(newTotalString);
    *assignmentTotalsPtr = assignmentTotals;
}

void editAssignment(char*** assignmentNamesPtr, short** assignmentTotalsPtr) {
    char** assignmentNames = *assignmentNamesPtr;
    short* assignmentTotals = *assignmentTotalsPtr;

    printf("\nEdit Assignment Menu:\n");
    printf(" 1 - Edit assignment name\n");
    printf(" 2 - Edit assignment total\n");
    printf(" 3 - Cancel\n\n");

    int menuOption = 0;

    while (menuOption < '1' || menuOption > '3') {
        printf("Enter an menu option: ");
        menuOption = getchar();
        getchar();

        switch (menuOption) {
            case '1':
                editAssignmentName(&assignmentNames);
                break;
            case '2':
                editAssignmentTotal(&assignmentTotals, assignmentNames);
                break;
            case '3':
                break;
            default:
                printf("Sorry, try again.\n");
                break;
        }
    }

    *assignmentNamesPtr = assignmentNames;
    *assignmentTotalsPtr = assignmentTotals;
}