#include <arpa/inet.h>
#include <netdb.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>

void get_hints(struct addrinfo* hints) {
    memset(hints, 0, sizeof *hints);
    hints->ai_family = AF_UNSPEC;
    hints->ai_socktype = SOCK_STREAM;
    hints->ai_flags = AI_PASSIVE;
}

void get_socket_desc(int* socket_desc, struct addrinfo* addr_resource) {
    *socket_desc = socket(addr_resource->ai_family,
                          addr_resource->ai_socktype,
                          addr_resource->ai_protocol);

    if (*socket_desc == 0) {
        perror("socket failed");
        exit(EXIT_FAILURE);
    }
}

void f_setsockopt(int socket_desc) {
    int enable = 1;
    int result = setsockopt(socket_desc, SOL_SOCKET, SO_REUSEADDR, &enable, sizeof(int));

    if (result < 0) {
        perror("setsockopt failed");
        exit(EXIT_FAILURE);
    }
}

void f_bind(int socket_desc, struct addrinfo* addr_resource) {
    int result = bind(socket_desc, addr_resource->ai_addr, addr_resource->ai_addrlen);

    if (errno == 13) {
        printf("ERROR: You do not have sufficient privileges to bind to ports < 1024\n");
        exit(13);
    }

    if (result < 0) {
        perror("bind failed");
        exit(EXIT_FAILURE);
    }
}

void f_listen(int socket_desc) {
    int result = listen(socket_desc, 0);

    if (result < 0) {
        perror("listen failed");
        exit(EXIT_FAILURE);
    }
}

int f_accept(int socket_desc, struct sockaddr* their_addr) {
    socklen_t addr_size = sizeof(*their_addr);
    int new_socket = accept(socket_desc, their_addr, &addr_size);

    if (new_socket < 0) {
        perror("accept failed");
        exit(EXIT_FAILURE);
    } else {
        return new_socket;
    }
}

void* get_in_addr(struct sockaddr *their_addr) {
    if (their_addr->sa_family == AF_INET) {
        return &((struct sockaddr_in*)their_addr)->sin_addr;
    }

    return &((struct sockaddr_in6*)their_addr)->sin6_addr;
}

int setup_socket(char* port) {
    struct addrinfo hints;
    struct addrinfo* addr_resource;
    int socket_desc;

    get_hints(&hints);
    getaddrinfo(NULL, port, &hints, &addr_resource);
    get_socket_desc(&socket_desc, addr_resource);
    f_setsockopt(socket_desc);
    f_bind(socket_desc, addr_resource);
    freeaddrinfo(addr_resource);
    f_listen(socket_desc);

    printf("server: waiting for connections...\n");

    return socket_desc;
}

int get_socket(int socket_desc) {
    struct sockaddr their_addr;
    char their_addr_str[INET6_ADDRSTRLEN];

    int new_socket = f_accept(socket_desc, &their_addr);

    inet_ntop(their_addr.sa_family, get_in_addr(&their_addr), their_addr_str, sizeof their_addr_str);
    printf("server: got connection from %s\n", their_addr_str);

    return new_socket;
}