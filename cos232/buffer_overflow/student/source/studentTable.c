#include "../../shared/header/shared.h"
#include <stdio.h>
#include <string.h>

short getStudentIdxFromUsername(char** studentNames, char* studentName) {
    short studentIdx = -1;

    while (studentIdx == -1) {
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

    return studentIdx;
}

void showStudentAssignmentKey(char** assignmentNames) {
    printf("\n");
    for (short a = 0; a < stringArrayLength(assignmentNames); a++) {
        printf("%d - %s\n", a+1, assignmentNames[a]);
    }
    printf("\n");
}

void showStudentAssignmentNumHeader(char** assignmentNames) {
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

void showStudentAssignmentTotalHeader(const short* assignmentTotals) {
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

void showStudentHeaderSeparator(short numAssignments) {
    repeatChar('-', 32);
    printf("|");
    for (short i = 0; i < numAssignments; i++) {
        repeatChar('-', 5);
        printf("|");
    }
    printf("\n");
}

void showStudentRow(char** studentNames, float** scores, char* studentName, short numAssignments) {
    short studentIdx = getStudentIdxFromUsername(studentNames, studentName);

    if (studentIdx == -1) {
        printf("\nSorry, you could not be found in the Secure GradeBook(TM)\n");
    }

    char* student = studentNames[studentIdx];
    char studentNameLength = (char)(32-strlen(student));
    float* studentScores = scores[studentIdx];
    char score;

    printf("%s", student);
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

void showStudentTable(char** assignmentNames, short* assignmentTotals, char** studentNames, float** scores,
                      char* studentName) {

    if (assignmentNames == NULL) {
        printf("\nSorry, there are no assignments in the Secure GradeBook(TM)\n");
    } else {
        showStudentAssignmentKey(assignmentNames);
        showStudentAssignmentNumHeader(assignmentNames);
        showStudentAssignmentTotalHeader(assignmentTotals);
        showStudentHeaderSeparator(stringArrayLength(assignmentNames));
        showStudentRow(studentNames, scores, studentName, stringArrayLength(assignmentNames));
    }
}