#include <stdio.h>
#include <string.h>

char getRole() {
    char username[32];
    char password[32];
    char role = 0;

    printf("Username: ");
    gets(username);
    printf("Password: ");
    gets(password);

    if (strcmp(username, "student") == 0 && strcmp(password, "student") == 0) {
        role = 1;
    } else if (strcmp(username, "teacher") == 0 && strcmp(password, "teacher") == 0) {
        role = 2;
    }

    return role;
}

char getRoleFromUsernameAndPassword() {
    char role = getRole();

    while (role == 0) {
        printf("Sorry, try again.\n");
        role = getRole();
    }

    return role;
}