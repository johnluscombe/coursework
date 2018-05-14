#include <arpa/inet.h>
#include <netdb.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>

#define FLAGS 0
#define RECEIVER 0
#define SENDER 1
#define CLIENT 2
#define SERVER 3

void get_hints(struct addrinfo* hints, int socket_type) {
    memset(hints, 0, sizeof *hints);
    hints->ai_family = AF_UNSPEC;
    hints->ai_socktype = SOCK_DGRAM;
    if (socket_type == RECEIVER) hints->ai_flags = AI_PASSIVE;
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

void f_setsockopt(int socket_desc, int timeout) {
    struct timeval tv;
    tv.tv_sec = timeout;
    tv.tv_usec = 0;

    int enable = 1;
    int result1 = setsockopt(socket_desc, SOL_SOCKET, SO_REUSEADDR, &enable, sizeof(int));

    int result2 = 0;
    if (timeout > 0) {
        result2 = setsockopt(socket_desc, SOL_SOCKET, SO_RCVTIMEO, &tv, sizeof(tv));
    }

    if (result1 < 0 || result2 < 0) {
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

ssize_t f_recvfrom(int socket_desc, char* packet, size_t packet_size, struct sockaddr* their_addr, socklen_t* addr_len) {
    ssize_t num_bytes = recvfrom(socket_desc, packet, packet_size, FLAGS, their_addr, addr_len);
    if (num_bytes == -1) {
        if (errno != EAGAIN && errno != EWOULDBLOCK) {
            perror("recvfrom failed");
            exit(EXIT_FAILURE);
        }
    }

    return num_bytes;
}

void f_sendto(int socket_desc, void* packet, size_t packet_size, struct sockaddr* their_addr, socklen_t addr_len) {
    ssize_t num_bytes = sendto(socket_desc, packet, packet_size, FLAGS, their_addr, addr_len);

    if (num_bytes == -1) {
        perror("sendto failed");
        exit(EXIT_FAILURE);
    }
}

void* get_in_addr(struct sockaddr *their_addr) {
    if (their_addr->sa_family == AF_INET) {
        return &((struct sockaddr_in*)their_addr)->sin_addr;
    }

    return &((struct sockaddr_in6*)their_addr)->sin6_addr;
}

int setup_receive_socket(char* port, int timeout) {
    struct addrinfo hints;
    struct addrinfo* addr_resource;
    int socket_desc;

    get_hints(&hints, RECEIVER);
    getaddrinfo(NULL, port, &hints, &addr_resource);
    get_socket_desc(&socket_desc, addr_resource);
    f_setsockopt(socket_desc, timeout);
    f_bind(socket_desc, addr_resource);
    freeaddrinfo(addr_resource);

    return socket_desc;
}

ssize_t receive_packet(char** packet, char** ip, char* port, size_t packet_size, int host_type, int timeout) {
    struct sockaddr_in their_addr;
    socklen_t addr_len = sizeof their_addr;

    int socket_desc = setup_receive_socket(port, timeout);
    ssize_t num_bytes = f_recvfrom(socket_desc, *packet, packet_size, (struct sockaddr *)&their_addr, &addr_len);

    if (host_type == SERVER) *ip = inet_ntoa(their_addr.sin_addr);
    return num_bytes;
}

void send_packet(char* ip, char* port, void* packet, size_t packet_size) {
    struct addrinfo hints;
    struct addrinfo* addr_resource;
    struct sockaddr* ai_addr;
    socklen_t ai_addrlen;
    int socket_desc;

    get_hints(&hints, SENDER);
    getaddrinfo(ip, port, &hints, &addr_resource);
    get_socket_desc(&socket_desc, addr_resource);

    ai_addr = addr_resource->ai_addr;
    ai_addrlen = addr_resource->ai_addrlen;

    f_sendto(socket_desc, packet, packet_size, ai_addr, ai_addrlen);
    freeaddrinfo(addr_resource);
}
