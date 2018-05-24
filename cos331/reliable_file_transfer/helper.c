#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <zconf.h>
#include <stdint.h>
#include "helper.h"

#define BITS_IN_BYTE 8
#define BYTE_SIZE 1
#define DATA_SIZE 507
#define HEADER_SIZE 4

void check_port(char* port) {
    int int_port = atoi(port);
    if (int_port == 0 && strncmp(port, "0", 1) != 0) {
        printf("ERROR: Port must be a number\n");
        exit(1);
    }
}

void check_path(char* path) {
    int valid_permissions = access(path, W_OK) != -1;
    if (!valid_permissions) {
        printf("ERROR: %s: Invalid permissions to write\n", path);
    }
}

void print_debug_headers() {
    printf("%10s %10s %6s %10s\n", "HOST TYPE", "SEQ/ACK", "EOF", "COMM TYPE");
    for (int i = 0; i < 40; i++) {
        printf("-");
    }
    printf("\n");
}

void print_debug_line(char* host_type, int seq_number, char* seq_ack, char eof, char* comm_type) {
    printf("%10s %4d (%3s) %6d %10s\n", host_type, seq_number, seq_ack, eof, comm_type);
}

char* create_packet(uint32_t sequence_number, char last_byte, char* data) {
    size_t packet_size = HEADER_SIZE + BYTE_SIZE + DATA_SIZE;
    char* packet = malloc(packet_size);
    int shift_amount;

    for (int i = 0; i < HEADER_SIZE; i++) {
        shift_amount = 24 - i*BITS_IN_BYTE;
        packet[i] = (unsigned char)((sequence_number >> shift_amount) & 0xFF);
    }

    packet[HEADER_SIZE] = last_byte;

    strncpy(packet+HEADER_SIZE+BYTE_SIZE, data, DATA_SIZE);
    return packet;
}

struct rft_packet parse_packet(unsigned char* str_packet) {
    struct rft_packet packet;
    uint32_t sequence_number = 0;
    int shift_amount;
    char* data = calloc(DATA_SIZE, 1);

    for (int i = 0; i < HEADER_SIZE; i++) {
        shift_amount = 24 - i*BITS_IN_BYTE;
        sequence_number = sequence_number | (str_packet[i] << shift_amount);
    }

    packet.sequence_number = sequence_number;
    packet.last_byte = str_packet[HEADER_SIZE];
    strncpy(data, str_packet+HEADER_SIZE+BYTE_SIZE, DATA_SIZE);
    packet.data = data;

    return packet;
}