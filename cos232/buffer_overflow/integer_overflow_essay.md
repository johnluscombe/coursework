# Attack 2 Essay - Integer Overflow

For my second attack, I exploited an integer overflow vulnerability. The code is vulnerable because the user can
carefully craft a specific menu option input to get access to options he or she is not supposed to access.

The exploit works like this: when the user specifies a number option in the command-line menu, the program checks for
valid input based on the string representation of the number, not the its integer representation. Since the integer
representation is stored as a short, the user can overflow the short's maximum value. Then, the user simply specifies
the overflow's version of an invalid number, and this completely bypasses the program's check for a valid menu option.

To prevent the attack, the programmer should check the integer representation of the menu option, not the string
version. That way, if the user exploits integer overflow, it would not matter, as the integer version of the menu option
would store the correct value (i.e. it would store 65543 as 7, not 65543).

If a malicious teacher, like Dr. Stanley, exploited this vulnerability, he could gain access to functionality that he
should not be able to access. This allows him to surpass the program's access control, essentially giving him
administrator access. From there, he could do all sorts of damage to the gradebook data.