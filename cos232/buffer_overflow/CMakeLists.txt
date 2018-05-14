cmake_minimum_required(VERSION 3.8)
project(buffer_overflow)

set(CMAKE_C_STANDARD 11)

set(SOURCE_FILES gradebook.c shared/header/role.h shared/source/role.c teacher/header/teacher.h teacher/source/teacher.c student/source/student.c student/header/student.h shared/header/load.h shared/source/load.c teacher/source/table.c teacher/header/table.h shared/source/shared.c shared/header/shared.h student/source/studentTable.c student/header/studentTable.h teacher/source/addAssignment.c teacher/header/addAssignment.h teacher/source/addStudent.c teacher/header/addStudent.h teacher/source/editAssignment.c teacher/header/editAssignment.h teacher/source/editStudentName.c teacher/header/editStudentName.h teacher/source/deleteAssignment.c teacher/source/deleteStudent.c teacher/source/deleteScore.c teacher/header/deleteAssignment.h teacher/header/deleteScore.h teacher/header/deleteStudent.h teacher/header/editScore.h teacher/source/editScore.c teacher/source/save.c teacher/header/save.h)
add_executable(buffer_overflow ${SOURCE_FILES})