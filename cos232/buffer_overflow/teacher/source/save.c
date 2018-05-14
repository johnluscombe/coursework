#include "../../shared/header/shared.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void writeAssignments(FILE* gradebook, char** assignmentNames, const short* assignmentTotals, short numAssignments) {
    char* assignmentName;
    short assignmentTotal;

    for (short a = 0; a < numAssignments; a++) {
        assignmentName = assignmentNames[a];
        assignmentTotal = assignmentTotals[a];

        fwrite(assignmentName, 1, strlen(assignmentName), gradebook);
        fwrite(": ", 1, 2, gradebook);
        fwrite(&assignmentTotal, 2, 1, gradebook);
        fwrite("\n", 1, 1, gradebook);
    }

    fwrite("\n", 1, 1, gradebook);
}

void writeStudents(FILE* gradebook, char** studentNames, float** scores, short numAssignments) {
    char* studentName;
    float* studentScores;
    float score;
    short numStudents = stringArrayLength(studentNames);

    for (short studentNum = 0; studentNum < numStudents; studentNum++) {
        studentName = studentNames[studentNum];
        studentScores = scores[studentNum];

        fwrite(studentName, 1, strlen(studentName), gradebook);
        fwrite(": ", 1, 2, gradebook);

        for (short scoreNum = 0; scoreNum < numAssignments; scoreNum++) {
            score = studentScores[scoreNum];
            fwrite(&score, 2, 1, gradebook);
            fwrite("|", 1, 1, gradebook);
        }

        fwrite("\n", 1, 1, gradebook);
    }
}

void save(char** assignmentNames, short* assignmentTotals, char** studentNames, float** scores) {
    FILE* gradebook = getFileObject("w");
    short numAssignments = shortArrayLength(assignmentTotals);
    writeAssignments(gradebook, assignmentNames, assignmentTotals, numAssignments);
    writeStudents(gradebook, studentNames, scores, numAssignments);
}