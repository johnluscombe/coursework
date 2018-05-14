#include <netdb.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include "error.h"

struct response {
    struct {
        char* version;
        char* code;
        char* description;
    } line;

    struct {
        char *content_type;
        char *content_length;
        char *date;
    } headers;
};

char* int_to_string(int val, size_t len) {
    char* string = malloc(len);
    sprintf(string, "%d", val);
    return string;
}

char* long_to_string(long val, size_t len) {
    char* string = malloc(len);
    sprintf(string, "%ld", val);
    return string;
}

void send_response_line(int new_socket, struct response* resp) {
    size_t MAX_RESPONSE_LINE_SIZE = 37;
    char* response_line = malloc(MAX_RESPONSE_LINE_SIZE);
    sprintf(response_line, "%s %s %s\r\n", resp->line.version, resp->line.code, resp->line.description);
    send(new_socket, response_line, strlen(response_line), 0);
    free(response_line);
}

void send_headers(int new_socket, struct response* resp) {
    char* content_type = resp->headers.content_type;
    char* content_length = resp->headers.content_length;
    char* date = resp->headers.date;
    char* server = "Server: LuscombeServ/0.0.1\r\n";

    send(new_socket, content_type, strlen(content_type), 0);
    send(new_socket, content_length, strlen(content_length), 0);
    send(new_socket, date, strlen(date), 0);
    send(new_socket, server, strlen(server), 0);
    send(new_socket, "\r\n", 2, 0);
}

void send_file(int new_socket, FILE* file) {
    int char_as_int = 0;
    char char_as_char = 0;

    while (char_as_int != EOF) {
        char_as_int = fgetc(file);
        char_as_char = (char)char_as_int;
        send(new_socket, &char_as_char, 1, 0);
    }
}

char* get_description_from_code(int response_code) {
    switch (response_code) {
        case 200:
            return "OK";
        case 400:
            return "Bad Request";
        case 404:
            return "Not Found";
        default:
            return "Internal Server Error";
    }
}

char* get_content_type_header(char* path, int response_code) {
    size_t MAX_CONTENT_TYPE_SIZE = 39;
    char* header = calloc(MAX_CONTENT_TYPE_SIZE, 1);
    strcat(header, "Content-Type: ");

    if (response_code != 200) {
        strcat(header, "text/html\r\n");
        return header;
    }

    char* extension = strrchr(path, '.');

    if (strncmp(extension, ".jpg", 4) == 0) {
        strcat(header, "image/jpeg");
    } else if (strncmp(extension, ".jpeg", 5) == 0) {
        strcat(header, "image/jpeg");
    } else if (strncmp(extension, ".png", 4) == 0) {
        strcat(header, "image/png");
    } else if (strncmp(extension, ".gif", 4) == 0) {
        strcat(header, "image/gif");
    } else if (strncmp(extension, ".pdf", 4) == 0) {
        strcat(header, "application/pdf");
    } else if (strncmp(extension, ".js", 3) == 0) {
        strcat(header, "application/javascript");
    } else if (strncmp(extension, ".html", 5) == 0) {
        strcat(header, "text/html");
    } else if (strncmp(extension, ".txt", 4) == 0) {
        strcat(header, "text/plain");
    } else if (strncmp(extension, ".css", 4) == 0) {
        strcat(header, "text/css");
    } else {
        return NULL;
    }

    strcat(header, "\r\n");
    return header;
}

long get_file_size(FILE* file) {
    long size = 0;
    fseek(file, 0, SEEK_END);
    size = ftell(file);
    rewind(file);
    return size;
}

char* get_content_length_header(FILE* file, int response_code, char* description) {
    size_t MAX_CONTENT_LENGTH_SIZE = 38;
    char* header = calloc(MAX_CONTENT_LENGTH_SIZE, 1);
    strcat(header, "Content-Length: ");

    if (response_code == 200) {
        long file_size = get_file_size(file);
        char* file_size_str = long_to_string(file_size, 19);
        strcat(header, file_size_str);
        free(file_size_str);
    } else {
        int HTML_SIZE = 128;
        int TITLE_SIZE = 4 + (int)strlen(description);
        int TEXT_SIZE = TITLE_SIZE;
        int TOTAL_SIZE = HTML_SIZE + TITLE_SIZE + TEXT_SIZE;
        char* size_str = int_to_string(TOTAL_SIZE, 3);
        strcat(header, size_str);
        free(size_str);
    }

    strcat(header, "\r\n");
    return header;
}

char* get_date_header() {
    const int DATE_HEADER_SIZE = 38;

    struct tm* info;
    time_t unformatted_date;
    char* formatted_date = malloc(DATE_HEADER_SIZE);

    time(&unformatted_date);
    info = gmtime(&unformatted_date);
    strftime(formatted_date, DATE_HEADER_SIZE-2, "Date: %a, %d %b %Y %X %Z", info);
    strcat(formatted_date, "\r\n");

    return formatted_date;
}

void send_response(char* path, char* method, int response_code, int new_socket) {
    FILE* file = fopen(path, "r");

    struct response resp;
    resp.line.version = "HTTP/1.1";
    resp.line.code = int_to_string(response_code, 3);
    resp.line.description = get_description_from_code(response_code);
    resp.headers.content_type = get_content_type_header(path, response_code);
    resp.headers.content_length = get_content_length_header(file, response_code, resp.line.description);
    resp.headers.date = get_date_header();

    send_response_line(new_socket, &resp);
    send_headers(new_socket, &resp);

    if (strncmp(method, "HEAD", 4) != 0) {
        if (response_code == 200) {
            send_file(new_socket, file);
        } else {
            send_error(new_socket, resp.line.code, resp.line.description);
        }
    }

    free(resp.line.code);
    free(resp.headers.content_type);
    free(resp.headers.content_length);
    free(resp.headers.date);
}