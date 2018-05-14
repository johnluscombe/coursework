cmake_minimum_required(VERSION 3.8.2)
project(rft C)

set(CMAKE_C_STANDARD 11)

add_executable(rft_client client.c socket.c socket.h helper.c helper.h)
add_executable(rft_server server.c socket.c socket.h helper.c helper.h)
add_executable(example_listener example_listener.c)
add_executable(example_talker example_talker.c)