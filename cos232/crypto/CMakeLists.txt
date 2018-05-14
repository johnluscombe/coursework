cmake_minimum_required(VERSION 3.8)
project(caesar)

set(CMAKE_C_STANDARD 11)

set(SOURCE_FILES caesar.c)
add_executable(caesar ${SOURCE_FILES})