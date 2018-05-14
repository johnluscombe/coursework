#include "../header/studentTable.h"
#include "../../shared/header/load.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void printStudentMenu() {
    printf("\nStudent Menu:\n");
    printf("\n  1 - Load a Secure GradeBook(TM)\n");
    printf("  2 - View Grades\n");
    printf("  3 - Quit\n\n");
}

void runStudentProgram() {
    char** assignmentNames = 0;
    short* assignmentTotals = 0;
    char** studentNames = 0;
    float** scores = 0;

    char* menuOptionString = malloc(32);
    short menuOption = 0;

    printStudentMenu();
    getchar();

    while (menuOption != 'Q' && menuOption != 'q') {
        printf("Enter an menu option: ");
        fgets(menuOptionString, 32, stdin);
        menuOptionString[strlen(menuOptionString)-1] = '\0';
        menuOption = (short)strtol(menuOptionString, NULL, 10);

        switch (menuOption) {
            case 1:
                load(&assignmentNames, &assignmentTotals, &studentNames, &scores);
                printStudentMenu();
                break;
            case 2:
                showStudentTable(assignmentNames, assignmentTotals, studentNames, scores, "student");
                printStudentMenu();
                break;
            case 3:
                return;
            default:
                printf("Sorry, try again.\n");
                break;
        }
    }
}