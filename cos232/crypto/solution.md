# Crypto Essays

## Part 2

The file I used to encrypt was a text file called `plaintext_riddles.txt`. To encrypt the file, I used a program called
"GnuPG" (a.k.a. "GPG") with the AES-256 algorithm. AES-256 uses a symmetric encryption, which uses a shared key to do
both encryption and decryption. To transmit the file, I used the GitLab repository assigned to me for the class. To
transmit the key required for decrypting the file, I used LastPass - a secure password and notes-sharing application
that specializes in information security. Using this tool, I created a "secure note" containing the shared key and how
to decrypt it, and shared it with the professor.

There are two main advantages to my approach. First of all, it is relatively fast, due to the symmetric encryption.
Second, a large key is not required in this approach, again due to the symmetric encryption. Furthermore, a usual
disadvantage of symmetric encryption - that O(n<sup>2</sup>) keys are required - is not present in this scenario,
because only one pair of users require this key. 

Despite these advantages, there are still a few disadvantages to this approach. First of all, I used third-party tools
to transmit the file and key. Ken Thompson, creator of the original Unix operating system, said that "you can't trust
code that you did not totally create yourself." Therefore, I cannot completely trust GitLab or LastPass, because they
are third-party tools. Second of all, it is slightly inconvenient due to the fact that the key and the file are being
sent separately, so the recipient must go to two different places to retrieve everything necessary for decrypting the
file. However, despite these disadvantages, this is still a solid approach for encrypting and transmitting a file.

## Part 3

To send an encrypted email to Dr. Stanley, I used the OpenGPG suite on Mac. To send the encrypted email, I installed
the program, created my own public key, imported Dr. Stanley's public key from Moodle, and Apple Mail was able to
send the email encrypted. I had some issues importing Dr. Stanley's public key with the tool, but I just had to learn
how the app worked. All I had to do was copy the PGP key with GPG Keychain open, and the app detected it and imported
it. Overall, it was a lot easier than expected. OpenGPG uses OpenPGP to do the encryption, which is a type of asymmetric
encryption. Asymmetric encryption uses a public key to encrypt something (in this case, the email), and a private key to
decrypt it. Both my key and Dr. Stanley's public key was generated using the RSA algorithm.

There are two main advantages to my approach. First of all, as I mentioned earlier, it was relatively easy to set up.
From what I heard, PGP is not an easy encryption tool to set up, so using the OpenGPG tool for Apple Mail provided a
relatively easy user interface. Second, it is free, because you do not need to purchase any keys or certificates.

Despite these advantages, there are still a few disadvantages to this approach. First of all, both the sender and the
receiver must have a compatible version of PGP, and this can be difficult for somebody who is not well-versed in
computer security. Second, the "from" address and the "to" address is not encrypted, so an attacker can see who's
talking and who he or she is talking to. However, despite these disadvantages, this is still a solid approach for
encrypting email.