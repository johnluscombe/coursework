#include <netdb.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <zconf.h>
#include "helper.h"
#include "socket.h"

#define BYTE_SIZE 1
#define CLIENT 2
#define DATA_SIZE 507
#define FLAGS 0
#define HEADER_SIZE 4
#define IP_V4_SIZE 16
#define SERVER 3

void check_argc(int argc) {
    if (argc < 2) {
        printf("ERROR: Not enough arguments\n");
        printf("First argument: LISTENING_PORT: network port number where server is listening\n");
        exit(1);
    } else if (argc == 3) {
        printf("WARNING: Too many arguments. Last argument ignored.\n");
    } else if (argc > 3) {
        printf("WARNING: Too many arguments. Last %d arguments ignored.\n", argc-2);
    }
}

int get_file_status(char* path) {
    int exists = access(path, F_OK) != -1;
    int valid_permissions = access(path, R_OK) != -1;

    if (!exists) {
        return 2;
    } else if (!valid_permissions) {
        return 13;
    } else {
        return 0;
    }
}

size_t get_data_from_file(FILE* file, char** data) {
    char* file_data = calloc(DATA_SIZE, BYTE_SIZE);
    size_t bytes_read = fread(file_data, BYTE_SIZE, DATA_SIZE, file);
    *data = file_data;
    return bytes_read;
}

void send_file_error(char* ip, char* port, int file_status) {
    char LAST_BYTE = 1;
    uint32_t seq_number = 0;
    size_t packet_size = HEADER_SIZE + BYTE_SIZE + DATA_SIZE;
    char* str_packet;

    switch (file_status) {
        case 2:
            str_packet = create_packet(seq_number, LAST_BYTE, "File does not exist on server");
            break;
        case 13:
            str_packet = create_packet(seq_number, LAST_BYTE, "File on server cannot be read (may be a permissions error)");
            break;
        default:
            str_packet = create_packet(seq_number, LAST_BYTE, "An unknown error occurred");
            break;
    }

    send_packet(ip, port, str_packet, packet_size);
}

int main(int argc, char** argv) {
    uint32_t seq_number_as_int = 0;
    uint32_t ack_number_as_int;
    int is_handshake;
    int file_status;
    char last_byte = 0;
    char* path;
    char* data;
    struct rft_packet packet;
    FILE* file = NULL;
    size_t bytes_read = 1;
    size_t packet_size = HEADER_SIZE + BYTE_SIZE + DATA_SIZE;
    char* str_packet = calloc(packet_size, 1);

    check_argc(argc);

    char* ip = malloc(IP_V4_SIZE);
    char* listening_port = argv[1];
    check_port(listening_port);
    print_debug_headers();

    while (bytes_read) {
        receive_packet(&str_packet, &ip, listening_port, packet_size, SERVER, 0);
        print_debug_line("SERVER", seq_number_as_int, "ACK", last_byte, "RECEIVE");
        packet = parse_packet(str_packet);
        ack_number_as_int = packet.sequence_number;
        is_handshake = !ack_number_as_int;

        if (is_handshake) {
            path = packet.data;
            file_status = get_file_status(path);
            if (file_status) {
                usleep(10000);
                send_file_error(ip, listening_port, file_status);
                print_debug_line("SERVER", seq_number_as_int, "SEQ", last_byte, "SEND");
                return file_status;
            }
            file = fopen(path, "r");
        }

        if (ack_number_as_int == seq_number_as_int) {
            seq_number_as_int++;
            bytes_read = get_data_from_file(file, &data);
            last_byte = feof(file) != 0;
            str_packet = create_packet(seq_number_as_int, last_byte, data);
        }

        usleep(10000);
        send_packet(ip, listening_port, str_packet, packet_size);
        print_debug_line("SERVER", seq_number_as_int, "SEQ", last_byte, "SEND");
    }

    return 0;
}