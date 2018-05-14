#include "../../shared/header/shared.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void editScore(float*** scoresPtr, char** assignmentNames, char** studentNames) {
    float** scores = *scoresPtr;
    short assignmentIdx = getAssignmentIdx(assignmentNames);
    short studentIdx = getStudentIdx(studentNames);
    char* scoreString = malloc(8);
    float score;

    printf("Score: ");
    fgets(scoreString, 8, stdin);
    scoreString[strlen(scoreString)-1] = '\0';
    score = strtof(scoreString, NULL);

    while (score >= 10000) {
        printf("Sorry, maximum score is 9999.\n");
        printf("Score: ");
        fgets(scoreString, 8, stdin);
        scoreString[strlen(scoreString)-1] = '\0';
        score = strtof(scoreString, NULL);
    }

    scores[studentIdx][assignmentIdx] = score;
    *scoresPtr = scores;
}