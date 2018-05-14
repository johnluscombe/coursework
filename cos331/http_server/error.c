#include <netdb.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void send_title(int new_socket, char* response_code, char* description) {
    size_t MAX_TITLE_SIZE = 28;
    char* title = malloc(MAX_TITLE_SIZE);
    sprintf(title, "%s %s", response_code, description);

    send(new_socket, "<title>", 7, 0);
    send(new_socket, title, strlen(title), 0);
    send(new_socket, "</title>\r\n", 10, 0);

    free(title);
}

void send_html_head(int new_socket, char* response_code, char* description) {
    send(new_socket, "<head>\r\n", 8, 0);
    send(new_socket, "<meta charset=\"UTF-8\">\r\n", 24, 0);
    send_title(new_socket, response_code, description);
    send(new_socket, "</head>\r\n", 9, 0);
}

void send_html_body(int new_socket, char* response_code, char* description) {
    size_t MAX_SIZE = 28;
    char* status = malloc(MAX_SIZE);
    sprintf(status, "%s %s", response_code, description);

    send(new_socket, "<body>\r\n", 8, 0);
    send(new_socket, "<h1>", 4, 0);
    send(new_socket, status, strlen(status), 0);
    send(new_socket, "</h1>\r\n", 7, 0);
    send(new_socket, "</body>\r\n", 9, 0);

    free(status);
}

void send_error(int new_socket, char* response_code, char* description) {
    send(new_socket, "<!DOCTYPE html>\r\n", 17, 0);
    send(new_socket, "<html lang=\"en\">\r\n", 18, 0);
    send_html_head(new_socket, response_code, description);
    send_html_body(new_socket, response_code, description);
    send(new_socket, "</html>", 7, 0);
}