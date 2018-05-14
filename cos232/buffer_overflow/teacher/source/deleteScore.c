#include "../../shared/header/shared.h"

void deleteScore(float*** scoresPtr, char** assignmentNames, char** studentNames) {
    float** scores = *scoresPtr;
    short assignmentIdx = getAssignmentIdx(assignmentNames);
    short studentIdx = getStudentIdx(studentNames);

    scores[studentIdx][assignmentIdx] = 0;
    *scoresPtr = scores;
}