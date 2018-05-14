#ifndef HTTP_ERROR_H
#define HTTP_ERROR_H

void send_error(int new_socket, char* response_code, char* description);

#endif
