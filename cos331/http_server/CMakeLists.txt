cmake_minimum_required(VERSION 3.9)
project(http C)

set(CMAKE_C_STANDARD 11)

add_executable(http main.c request.c request.h response.h response.c socket.h socket.c error.c error.h)