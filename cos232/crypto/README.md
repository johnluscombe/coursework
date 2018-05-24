# Practical Cryptography

## Assignment Purpose

The purpose of this assignment was to get some practical experience using
cryptography. There were three parts to this assignment.

### Part I - Caesar Cipher

For Part I of this assignment, we were to create a C program that encrypts
data by taking each character and replacing it with a letter N positions away.
My source code can be seen in `caesar.c`.

### Part II - Encrypt a File (Symmetric)

For Part II of this assignment, we were to encrypt and send a file to the
professor using symmetric cryptography. To do this, I used a program called
"GnuPG" (a.k.a. GPG) with the AES-256 algorithm. I then sent the decryption
key to the professor using LastPass, a secure password and notes-sharing
application that specializes in information security.

There are two main advantages to my approach. First of all, it is relatively
fast, due to the symmetric encryption. Second, a large key is not required in
this approach, again due to the symmetric encryption. Furthermore, a usual
disadvantage of symmetric encryption - that O(n2) keys are required - is not
present in this scenario, because only one pair of users require this key.

Despite these advantages, there are still a few disadvantages to this approach.
First of all, I used third-party tools to transmit the file and key. Ken
Thompson, creator of the original Unix operating system, said that "you can't
trust code that you did not totally create yourself." Therefore, I cannot
completely trust LastPass, because they are third-party tools. Second of all,
it is slightly inconvenient due to the fact that the key and the file are being
sent separately, so the recipient must go to two different places to retrieve
everything necessary for decrypting the file. However, despite these
disadvantages, this is still a solid approach for encrypting and transmitting a
file.

### Part III - Encrypt an Email (Asymmetric)

For Part III of this assignment, we were to send the professor an email using
a standard asymmetric email encryption mechanism to encrypt the message. To do
this, I used a program called "OpenGPG" on a Mac.

There are two main advantages to my approach. First of all, it was relatively
easy to set up. From what I heard, PGP is not an easy encryption tool to set up,
so using the OpenGPG tool for Apple Mail provided a relatively easy user
interface. Second, it is free, because you do not need to purchase any keys or
certificates.

Despite these advantages, there are still a few disadvantages to this approach.
First of all, both the sender and the receiver must have a compatible version of
PGP, and this can be difficult for somebody who is not well-versed in computer
security. Second, the "from" address and the "to" address is not encrypted, so
an attacker can see who's talking and who he or she is talking to. However,
despite these disadvantages, this is still a solid approach for encrypting
email.

## Credit

- **Assignment Author**: Dr. Dannie Stanley, PhD