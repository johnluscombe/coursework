#ifndef HTTP_REQUEST_H
#define HTTP_REQUEST_H

int get_request(int new_socket, char* docroot, char** method, char** path);

#endif
