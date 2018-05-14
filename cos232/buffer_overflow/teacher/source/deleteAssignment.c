#include "../../shared/header/shared.h"

void deleteAssignment(char*** assignmentNamesPtr, short** assignmentTotalsPtr, float*** scoresPtr, char** studentNames) {
    char** assignmentNames = *assignmentNamesPtr;
    short* assignmentTotals = *assignmentTotalsPtr;
    float** scores = *scoresPtr;

    short assignmentIdx = getAssignmentIdx(assignmentNames);
    short assignmentNamesLastIndex = (short)(stringArrayLength(assignmentNames)-1);
    short studentNamesLastIndex = (short)(stringArrayLength(studentNames)-1);

    for (short assignmentNum = assignmentIdx; assignmentNum < assignmentNamesLastIndex; assignmentNum++) {
        assignmentNames[assignmentNum] = assignmentNames[assignmentNum+1];
        assignmentTotals[assignmentNum] = assignmentTotals[assignmentNum+1];
    }

    assignmentNames[assignmentNamesLastIndex] = NULL;
    assignmentTotals[assignmentNamesLastIndex] = 0;

    for (short studentNum = 0; studentNum < studentNamesLastIndex; studentNum++) {
        for (short assignmentNum = assignmentIdx; assignmentNum < assignmentNamesLastIndex; assignmentNum++) {
            scores[studentNum][assignmentNum] = scores[studentNum][assignmentNum+1];
        }
        scores[studentNum][assignmentNamesLastIndex] = 0;
    }

    *assignmentNamesPtr = assignmentNames;
    *assignmentTotalsPtr = assignmentTotals;
    *scoresPtr = scores;
}