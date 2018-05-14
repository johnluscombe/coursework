# Attack 1 Essay - Return-Oriented Programming Attack

For my first attack, I exploited a return-oriented programming vulnerability. The code is vulnerable because a student
can carefully craft specific input for the username to get access to teacher functionality.

The exploit works like this: the stack location of the return address is located 56 bytes higher in memory than the
username variable. Because of this, the user can simply provide 56 bytes of junk characters in username input,
overflowing its 32-byte capacity. After 56 bytes, the user can specify the address of the first instruction in
`runTeacherProgram`, replacing the actual return address with a custom return address. After entering the malicious
username and a random password, the program will jump to `runTeacherProgram`, providing the user full teacher access
without the user giving a valid username and password.

To prevent the attack, the programmer should use a more secure function than `gets`. Additionally, the programmer should
not allow an input longer than the buffer, or better yet, resize the buffer once the input reaches or exceeds the buffer
capacity.

If a malicious student, like me, exploited this vulnerability, he could change gradebook data to give myself all As,
wiping out the data reflecting my true performance in my classes.