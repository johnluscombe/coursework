cmake_minimum_required(VERSION 3.8)
project(steganography)

set(CMAKE_C_STANDARD 11)

set(SOURCE_FILES encoder.c)
add_executable(steganography ${SOURCE_FILES})