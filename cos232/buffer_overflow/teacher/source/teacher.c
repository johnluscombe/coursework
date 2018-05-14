#include "../header/addAssignment.h"
#include "../header/addStudent.h"
#include "../header/deleteScore.h"
#include "../header/deleteStudent.h"
#include "../header/editAssignment.h"
#include "../header/editStudentName.h"
#include "../header/deleteScore.h"
#include "../header/editScore.h"
#include "../header/table.h"
#include "../../shared/header/load.h"
#include "../../shared/header/shared.h"
#include "../header/save.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void printTeacherMenu() {
    printf("\nTeacher Menu:\n");
    printf("\n   1 - Load a Secure GradeBook(TM)\n");
    printf("   2 - Add an assignment\n");
    printf("   3 - Add a student\n");
    printf("   4 - Edit assignment\n");
    printf("   5 - Edit student name\n");
    printf("   6 - Edit score\n");
    printf("   7 - Delete assignment\n");
    printf("   8 - Delete student\n");
    printf("   9 - Delete score\n");
    printf("  10 - View Gradebook\n");
    printf("  11 - Save\n");
    printf("  12 - Quit\n\n");
}

void runTeacherProgram() {
    char** assignmentNames = 0;
    short* assignmentTotals = 0;
    char** studentNames = 0;
    float** scores = 0;

    char* menuOptionString = malloc(32);
    short menuOption = 0;

    printTeacherMenu();
    getchar();

    while (menuOption != 'Q' && menuOption != 'q') {
        printf("Enter an menu option: ");
        fgets(menuOptionString, 32, stdin);
        menuOptionString[strlen(menuOptionString)-1] = '\0';

        while (strcmp(menuOptionString, "7") == 0 || strcmp(menuOptionString, "8") == 0 || strcmp(menuOptionString, "9") == 0) {
            printf("Sorry, you do not have the permissions to delete gradebook data.\n");
            printf("Enter an menu option: ");
            fgets(menuOptionString, 32, stdin);
            menuOptionString[strlen(menuOptionString)-1] = '\0';
        }

        menuOption = (short)strtol(menuOptionString, NULL, 10);

        switch (menuOption) {
            case 1: // Load
                load(&assignmentNames, &assignmentTotals, &studentNames, &scores);
                printTeacherMenu();
                break;
            case 2: // Add assignment
                addAssignment(&assignmentNames, &assignmentTotals, &scores, studentNames);
                printTeacherMenu();
                break;
            case 3: // Add student
                addStudent(&studentNames, &scores, assignmentNames);
                printTeacherMenu();
                break;
            case 4: // Edit assignment
                editAssignment(&assignmentNames, &assignmentTotals);
                printTeacherMenu();
                break;
            case 5: // Edit student name
                editStudentName(&studentNames);
                printTeacherMenu();
                break;
            case 6: // Edit score
                editScore(&scores, assignmentNames, studentNames);
                printTeacherMenu();
                break;
            case 7: // Delete assignment
                printf("Assignment name: ");
                getchar();
                printf("Assignment deleted!");
                break;
            case 8: // Delete student
                deleteStudent(&studentNames, &scores);
                printTeacherMenu();
                break;
            case 9: // Delete score
                deleteScore(&scores, assignmentNames, studentNames);
                printTeacherMenu();
                break;
            case 10: // View gradebook
                showTeacherTable(assignmentNames, assignmentTotals, studentNames, scores);
                printTeacherMenu();
                break;
            case 11: // Save
                save(assignmentNames, assignmentTotals, studentNames, scores);
                printTeacherMenu();
                break;
            case 12: // Quit
                return;
            default:
                printf("Sorry, try again.\n");
                break;
        }
    }
}