#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/time.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include "helper.h"
#include "socket.h"

void check_argc(int argc) {
    if (argc < 5) {
        printf("ERROR: Not enough arguments\n");
        printf("First argument: SERVER_IP: ip address of the RFT server\n");
        printf("Second argument: SERVER_PORT: network port number where server is listening\n");
        printf("Third argument: REMOTE_PATH: filesystem path on the server for the file to be downloaded\n");
        printf("Fourth argument: LOCAL_PATH: filesystem path on the client machine where to store the downloaded file\n");
        exit(1);
    } else if (argc == 6) {
        printf("WARNING: Too many arguments. Last argument ignored.\n");
    } else if (argc > 6) {
        printf("WARNING: Too many arguments. Last %d arguments ignored.\n", argc-5);
    }
}

void check_args(int argc, char* server_port, char* local_path) {
    check_argc(argc);
    check_port(server_port);
    check_path(local_path);
}

int main(int argc, char** argv) {
    char* server_ip = argv[1];
    char* server_port = argv[2];
    char* remote_path = argv[3];
    char* local_path = argv[4];

    char* packet;
    char* packet_buf = calloc(512, 1);
    struct rft_packet recv_packet;
    char* body = calloc(508,1);
    char* buf_seq_num = calloc(4,1);
    char buf_eof_flag = 0;
    char* buf_data = calloc(512, 1);
    unsigned int sleep_time;
    ssize_t num_bytes = 0;
    int eof_flag = 0;
    uint32_t client_sequence_num = 0;
    uint32_t server_sequence_num = 0;

    check_args(argc, server_port, local_path);
    print_debug_headers();

    FILE *fp;
    fp = fopen(local_path, "w");

    while (eof_flag != 1) {
        //checks sequence number for 0 (handshake) and builds packet
        if (client_sequence_num == 0) {
            strcpy(body, remote_path);
        }
        else if (client_sequence_num != 0){
            body = calloc(508,1);
        }

        //create the packet
        packet = create_packet(client_sequence_num, buf_eof_flag, body);

        //update eof_flag
        eof_flag = buf_eof_flag;

        //timer & receive
        num_bytes = 0;
        sleep_time = 2;
        for (int i=0; i < 8; i++){
            //send the packet
            usleep(10000);
            send_packet(server_ip, server_port, packet, 512);
            print_debug_line("CLIENT", client_sequence_num, "ACK", buf_eof_flag, "SEND");

            num_bytes = receive_packet(&packet_buf, NULL, server_port, 512, 2, sleep_time);
            recv_packet = parse_packet(packet_buf);
            sprintf(buf_seq_num, "%d", recv_packet.sequence_number);
            buf_eof_flag = recv_packet.last_byte;
            buf_data = recv_packet.data;
            sleep_time += 1;
            if (num_bytes > 0) {
                break;
            }
        }

        //handle triple ACKs
        if (num_bytes <= 0){
            printf("Connection was dropped\n");
            exit(1);
        }

        //store the sequence number
        server_sequence_num = (uint32_t) atoi(buf_seq_num);

        print_debug_line("CLIENT", server_sequence_num, "SEQ", buf_eof_flag, "RECEIVE");

        //check client_sequence_num and server_sequence_num (if S=C+1)
        if (server_sequence_num == (client_sequence_num + 1)) {
            //store the data into correct file
            fprintf(fp, "%s", buf_data);
            client_sequence_num += 1;
        } else if (server_sequence_num == 0) {
            printf("%s\n", buf_data);
            return 1;
        }
    }

    return 0;
}
