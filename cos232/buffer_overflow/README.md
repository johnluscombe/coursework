# Buffer Overflow Attacks

## Assignment Purpose

The purpose of this assignment was to write a program that is vulnerable to two
overflow attacks, and to demonstrate them to the professor.

## Attacks

### Return-Oriented Programming Attack

**Vulnerability Location**: `shared/source/role.c`

For my first attack, I exploited a return-oriented programming vulnerability.
The code is vulnerable because a student can carefully craft specific input for
the username to get access to teacher functionality.

The exploit works like this: the stack location of the return address is
located 56 bytes higher in memory than the username variable. Because of this,
the user can simply provide 56 bytes of junk characters in username input,
overflowing its 32-byte capacity. To see an example of such a username, see
`malicious_username.txt`.

After 56 bytes, the user can specify the address of the first instruction in
`runTeacherProgram`, replacing the actual return address with a custom return
address. After entering the malicious username and a random password, the
program will jump to `runTeacherProgram`, providing the user full teacher
access without the user giving a valid username and password.

To prevent the attack, the programmer should use a more secure function than
`gets`. Additionally, the programmer should not allow an input longer than the
buffer, or better yet, resize the buffer once the input reaches or exceeds the
buffer capacity.

If a malicious student, like me, exploited this vulnerability, he could change
gradebook data to give myself all As, wiping out the data reflecting my true
performance in my classes.

### Integer Overflow Attack

**Vulnerability Location**: `teacher/source/teacher.c`

For my second attack, I exploited an integer overflow vulnerability. The code
is vulnerable because the user can carefully craft a specific menu option input
to get access to options he or she is not supposed to access.

The exploit works like this: when the user specifies a number option in the
command-line menu, the program checks for valid input based on the string
representation of the number, not the its integer representation. Since the
integer representation is stored as a short, the user can overflow the short's
maximum value. Then, the user simply specifies the overflow's version of an
invalid number, and this completely bypasses the program's check for a valid
menu option.

To prevent the attack, the programmer should check the integer representation
of the menu option, not the string version. That way, if the user exploits
integer overflow, it would not matter, as the integer version of the menu
option would store the correct value (i.e. it would store 65543 as 7, not
65543).

If a malicious teacher, like Dr. Stanley, exploited this vulnerability, he
could gain access to functionality that he should not be able to access. This
allows him to surpass the program's access control, essentially giving him
administrator access. From there, he could do all sorts of damage to the
gradebook data.

## Credit

- **Assignment Author**: Dr. Dannie Stanley, PhD