#ifndef HTTP_SOCKET_H
#define HTTP_SOCKET_H

ssize_t receive_packet(char** packet, char** ip, char* port, size_t packet_size, int host_type, int timeout);
void send_packet(char* ip, char* port, void* packet, size_t packet_size);

#endif
