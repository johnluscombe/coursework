#ifndef HTTP_RESPONSE_H
#define HTTP_RESPONSE_H

void send_response(char* path, char* method, int request_code, int new_socket);

#endif
