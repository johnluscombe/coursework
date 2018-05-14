#include "../header/shared.h"
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* getContentFromGradebook(FILE* gradebook, int terminatingChar) {
    size_t contentSize = 0;
    size_t contentCapacity = 32;
    char* content = calloc(contentCapacity, 1);
    char c = (char)fgetc(gradebook);

    if (c == '\n' || c == EOF) {
        content = NULL;
    } else {
        while (c != terminatingChar) {
            if (contentSize >= contentCapacity) {
                contentCapacity += 32;
                content = realloc(content, contentCapacity);
            }
            strncat(content, &c, 1);
            contentSize++;
            c = (char)fgetc(gradebook);
        }
    }

    return content;
}

float* getStudentScores(FILE* gradebook) {
    float* scores = malloc(SHRT_MAX);
    char* scoreStr = getContentFromGradebook(gradebook, '|');
    float score;
    char scoresIdx = 0;

    while (scoreStr != NULL) {
        score = (float)atof(scoreStr);
        scores[scoresIdx] = score;
        scoresIdx++;
        scoreStr = getContentFromGradebook(gradebook, '|');
    }

    if (scoresIdx == 0) {
        scores = NULL;
    }

    return scores;
}

void getAssignmentInfo(FILE* gradebook, char*** assignmentNamesPtr, short** assignmentTotalsPtr) {
    char** assignmentNames = malloc(SHRT_MAX*sizeof(char*));
    char* assignmentName = "";
    short assignmentNamesIdx = 0;

    short* assignmentTotals = malloc(SHRT_MAX*sizeof(short));
    char* assignmentTotalStr = "";
    short assignmentTotal;
    short assignmentTotalsIdx = 0;

    while (assignmentName != NULL && assignmentTotalStr != NULL) {
        assignmentName = getContentFromGradebook(gradebook, ':');
        if (assignmentName != NULL) {
            assignmentNames[assignmentNamesIdx] = assignmentName;
            assignmentNamesIdx++;
            fgetc(gradebook);

            assignmentTotalStr = getContentFromGradebook(gradebook, '\n');
            assignmentTotal = (short) atoi(assignmentTotalStr);
            assignmentTotals[assignmentTotalsIdx] = assignmentTotal;
            assignmentTotalsIdx++;
        }
    }

    if (assignmentNamesIdx == 0) {
        assignmentNames = NULL;
        assignmentTotals = NULL;
    }

    *assignmentNamesPtr = assignmentNames;
    *assignmentTotalsPtr = assignmentTotals;
}

void getStudentInfo(FILE* gradebook, char*** studentNamesPtr, float*** scoresPtr) {

    char** studentNames = malloc(SHRT_MAX);
    char* studentName = "";
    short studentNamesIdx = 0;

    float** scores = malloc(SHRT_MAX);
    float* studentScores = malloc(sizeof(float));
    short scoresIdx = 0;

    while (studentName != NULL && studentScores != NULL) {
        studentName = getContentFromGradebook(gradebook, ':');
        if (studentName != NULL) {
            studentNames[studentNamesIdx] = studentName;
            studentNamesIdx++;
            fgetc(gradebook);

            studentScores = getStudentScores(gradebook);
            scores[scoresIdx] = studentScores;
            scoresIdx++;
        }
    }

    if (studentNamesIdx == 0) {
        studentNames = NULL;
        scores = NULL;
    }

    *studentNamesPtr = studentNames;
    *scoresPtr = scores;
}

void load(char*** assignmentNamesPtr, short** assignmentTotalsPtr, char*** studentNamesPtr, float*** scoresPtr) {
    char** assignmentNames = 0;
    short* assignmentTotals = 0;
    char** studentNames = 0;
    float** scores = 0;

    FILE* gradebook = getFileObject("r");

    while (gradebook == NULL) {
        printf("Sorry, try again.\n");
        gradebook = getFileObject("r");
    }

    getAssignmentInfo(gradebook, &assignmentNames, &assignmentTotals);
    getStudentInfo(gradebook, &studentNames, &scores);

    *assignmentNamesPtr = assignmentNames;
    *assignmentTotalsPtr = assignmentTotals;
    *studentNamesPtr = studentNames;
    *scoresPtr = scores;
}