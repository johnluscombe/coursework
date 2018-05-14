#include "../../shared/header/shared.h"
#include <stdlib.h>

void deleteStudent(char*** studentNamesPtr, float*** scoresPtr) {
    char** studentNames = *studentNamesPtr;
    float** scores = *scoresPtr;

    short studentIdx = getStudentIdx(studentNames);
    short studentNamesLastIndex = (short)(stringArrayLength(studentNames)-1);

    for (short i = studentIdx; i < studentNamesLastIndex; i++) {
        studentNames[i] = studentNames[i+1];
        scores[i] = scores[i+1];
    }

    studentNames[studentNamesLastIndex] = NULL;
    *studentNamesPtr = studentNames;
    *scoresPtr = scores;
}