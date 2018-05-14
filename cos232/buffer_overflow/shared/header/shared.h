#include <stdio.h>

#ifndef SHARED_H_
#define SHARED_H_

FILE* getFileObject(char* mode);
short stringArrayLength(char** arr);
short shortArrayLength(const short* arr);
short floatArrayLength(const float* arr);
void repeatChar(char c, int times);
short getAssignmentIdx(char** assignmentNames);
short getStudentIdx(char** studentNames);

#endif
