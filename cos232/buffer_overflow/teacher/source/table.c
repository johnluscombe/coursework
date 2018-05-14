#include "../../shared/header/shared.h"
#include <stdio.h>
#include <string.h>

void showAssignmentKey(char** assignmentNames) {
    printf("\n");
    for (short a = 0; a < stringArrayLength(assignmentNames); a++) {
        printf("%d - %s\n", a+1, assignmentNames[a]);
    }
    printf("\n");
}

void showAssignmentNumHeader(char** assignmentNames) {
    repeatChar(' ', 32);
    printf("|");
    for (short a = 1; a <= stringArrayLength(assignmentNames); a++) {
        if (a < 10) {
            printf(" %d   |", a);
        } else if (a < 100) {
            printf(" %d  |", a);
        } else {
            printf(" %d |", a);
        }
    }
    printf("\n");
}

void showAssignmentTotalHeader(const short* assignmentTotals) {
    short total;
    repeatChar(' ', 32);
    printf("|");
    for (short t = 0; t < shortArrayLength(assignmentTotals); t++) {
        total = assignmentTotals[t];
        if (total < 10) {
            printf(" %d   |", total);
        } else if (total < 100) {
            printf(" %d  |", total);
        } else {
            printf(" %d |", total);
        }
    }
    printf("\n");
}

void showHeaderSeparator(short numAssignments) {
    repeatChar('-', 32);
    printf("|");
    for (short i = 0; i < numAssignments; i++) {
        repeatChar('-', 5);
        printf("|");
    }
    printf("\n");
}

void showStudentRows(char** studentNames, float** scores, short numAssignments) {
    char* student;
    char studentNameLength;
    float* studentScores;
    char score;

    for (short s = 0; s < stringArrayLength(studentNames); s++) {
        student = studentNames[s];
        studentNameLength = (char)(32-strlen(student));
        studentScores = scores[s];
        printf("%s", studentNames[s]);
        repeatChar(' ', studentNameLength);
        printf("|");
        for (short a = 0; a < numAssignments; a++) {
            score = (char)studentScores[a];
            if (score < 10) {
                printf(" %d   |", score);
            } else if (score < 100) {
                printf(" %d  |", score);
            } else {
                printf(" %d |", score);
            }
        }
        printf("\n");
    }
}

void showTeacherTable(char** assignmentNames, short* assignmentTotals, char** studentNames, float** scores) {
    if (assignmentNames == NULL && studentNames == NULL) {
        printf("You have no assignments or students in your Secure GradeBook(TM)!\n");
    } else if (assignmentNames == NULL) {
        printf("You have no assignments in your Secure GradeBook(TM)!\n");
    } else if (studentNames == NULL) {
        printf("You have no students in your Secure GradeBook(TM)!\n");
    } else {
        showAssignmentKey(assignmentNames);
        showAssignmentNumHeader(assignmentNames);
        showAssignmentTotalHeader(assignmentTotals);
        showHeaderSeparator(stringArrayLength(assignmentNames));
        showStudentRows(studentNames, scores, stringArrayLength(assignmentNames));
    }
}