#include "shared/header/role.h"
#include "student/header/student.h"
#include "teacher/header/teacher.h"
#include <stdio.h>

int main() {
    char role;

    printf("Welcome to Secure GradeBook Pro(TM), where grades are impenetrable to attacks!\n\n");

    role = getRoleFromUsernameAndPassword();

    if (role == 2) {
        runTeacherProgram();
    } else {
        runStudentProgram();
    }

    return 0;
}