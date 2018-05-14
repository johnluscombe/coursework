#include <netdb.h>
#include <stdlib.h>
#include <string.h>
#include <regex.h>
#include <zconf.h>

struct request {
    struct {
        char* method;
        char* resource;
        char* version;
    } line;

    char** headers;
    size_t size;
};

int is_empty_string(const char* string) {
    return strnlen(string, 1) == 0;
}

char* get_request_part(const int new_socket, const int is_whole_line) {
    size_t size = 0;
    char c = 0;
    char* part = malloc(size+2);

    while (c != '\n' && c != '\r' && (is_whole_line || c != ' ')) {
        recv(new_socket, &c, 1, 0);
        part[size] = c;
        size++;
        part = realloc(part, size+2);
    }

    if (c == '\r') {
        recv(new_socket, &c, 1, 0);
    }

    part[size-1] = 0;
    return part;
}

char* get_resource(int new_socket) {
    char* resource = get_request_part(new_socket, 0);
    char* new_resource;

    if (resource[strlen(resource)-1] == '/') {
        int SIZE_OF_FILE_NAME = 10;
        new_resource = malloc(sizeof(resource) + SIZE_OF_FILE_NAME);
        strcat(new_resource, resource);
        strcat(new_resource, "index.html");
    } else {
        new_resource = resource;
    }

    return new_resource;
}

void get_request_headers(struct request* req, const int new_socket) {
    size_t size = 0;
    char* header = get_request_part(new_socket, 1);

    if (is_empty_string(header)) {
        req->headers = NULL;
        req->size = 0;
        return;
    }

    char** headers = malloc(sizeof(char*));
    headers[0] = header;
    size++;

    while (!is_empty_string(header)) {
        header = get_request_part(new_socket, 1);

        if (!is_empty_string(header)) {
            headers = realloc(headers, sizeof(char*) * (size + 1));
            headers[size] = header;
            size++;
        }
    }

    req->headers = headers;
    req->size = size;
}

int check_for_null(const char* method, const char* resource, const char* version) {
    return method == NULL || resource == NULL || version == NULL;
}

int check_method(const char* method) {
    int too_long = strnlen(method, 5) > 4;
    int junk_after_get = strnlen(method, 4) == 4 && strncmp(method, "GET", 3) == 0;
    if (too_long || junk_after_get) {
        return 1;
    }

    int method_is_get = strncmp(method, "GET", 3) == 0;
    int method_is_head = strncmp(method, "HEAD", 4) == 0;

    return !method_is_get && !method_is_head;
}

int check_version(const char* version) {
    regex_t regex;
    regcomp(&regex, "^HTTP\\/(1\\.0|1\\.1|2)$", REG_EXTENDED);
    int result = regexec(&regex, version, 0, NULL, 0);
    return result == REG_NOMATCH;
}

int check_request_line(struct request* req) {
    char* method = req->line.method;
    char* resource = req->line.resource;
    char* version = req->line.version;

    int parts_are_null = check_for_null(method, resource, version);
    int invalid_method = check_method(method);
    int invalid_version = check_version(version);

    return parts_are_null || invalid_method || invalid_version;
}

int check_headers(struct request* req) {
    char* header;
    regex_t regex;
    int result;

    for (int i = 0; i < req->size; i++) {
        header = req->headers[i];
        regcomp(&regex, "^(.+): (.+)$", REG_EXTENDED);
        result = regexec(&regex, header, 0, NULL, 0);
        if (result == REG_NOMATCH) {
            return 1;
        }
    }

    return 0;
}

int check_request(struct request* req) {
    return check_request_line(req) || check_headers(req);
}

int check_file(char* docroot, char* resource, char** path) {
    size_t docroot_size = strlen(docroot);
    size_t resource_size = strlen(resource);
    *path = calloc(docroot_size + resource_size, 1);
    strcat(*path, docroot);
    strcat(*path, resource);
    return access(*path, F_OK ) == -1;
}

int get_request(int new_socket, char* docroot, char** method, char** path) {
    struct request req;
    req.line.method = get_request_part(new_socket, 0);
    req.line.resource = get_resource(new_socket);
    req.line.version = get_request_part(new_socket, 0);
    get_request_headers(&req, new_socket);

    int bad_request = check_request(&req);
    free(req.line.version);
    free(req.headers);

    int not_found = check_file(docroot, req.line.resource, path);
    free(req.line.resource);

    int method_is_get = strncmp(req.line.method, "GET", 3) != 0;
    int method_is_head = strncmp(req.line.method, "HEAD", 4) != 0;

    if (method_is_get || method_is_head) {
        *method = req.line.method;
    }

    if (bad_request) {
        return 400;
    } else if (not_found) {
        return 404;
    } else {
        return 200;
    }
}