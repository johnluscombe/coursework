#ifndef RFT_HELPER_H
#define RFT_HELPER_H

struct rft_packet {
    uint32_t sequence_number;
    char last_byte;
    char* data;
};

void check_port(char* port);
void check_path(char* path);
void print_debug_headers();
void print_debug_line(char* host_type, int seq_number, char* seq_ack, char eof, char* comm_type);
char* create_packet(uint32_t sequence_number, char last_byte, char* data);
struct rft_packet parse_packet(unsigned char* str_packet);

#endif