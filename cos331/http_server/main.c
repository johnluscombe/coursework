#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <zconf.h>
#include "request.h"
#include "response.h"
#include "socket.h"

void check_argc(int argc) {
    if (argc < 3) {
        printf("ERROR: Not enough arguments\n");
        printf("First argument: Server path to web server files\n");
        printf("Second argument: What network port to use\n");
        exit(1);
    } else if (argc == 4) {
        printf("WARNING: Too many arguments. Last argument ignored.\n");
    } else if (argc > 4) {
        printf("WARNING: Too many arguments. Last %d arguments ignored.\n", argc-2);
    }
}

void check_docroot(char* docroot) {
    if (access(docroot, F_OK ) == -1) {
        printf("ERROR: %s: No such file or directory\n", docroot);
        exit(1);
    }
}

void check_port(char* port) {
    int int_port = atoi(port);
    if (int_port == 0 && strncmp(port, "0", 1) != 0) {
        printf("ERROR: Port must be a number\n");
        exit(1);
    }
}

void check_args(int argc, char* docroot, char* port) {
    check_argc(argc);
    check_docroot(docroot);
    check_port(port);
}

int main(int argc, char **argv) {
    char* docroot = argv[1];
    char* port = argv[2];
    char* method;
    char* path;

    check_args(argc, docroot, port);
    int socket_desc = setup_socket(port);

    while (1) {
        int new_socket = get_socket(socket_desc);
        int response_code;

        if (!fork()) {
            close(socket_desc);
            response_code = get_request(new_socket, docroot, &method, &path);
            send_response(path, method, response_code, new_socket);
            close(new_socket);
            exit(0);
        }

        close(new_socket);
    }
}