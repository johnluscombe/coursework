# Web Security
This project is divided into four parts. It is recommended that you complete the parts in order. Some exercises require you to repair the code. If you repair the code too early it may complicate the completion of earlier exercises.

## Introduction

### Assumptions
This project assumes the following:

* Student has basic familiarity with using the Linux operating system
* Student is comfortable with the Linux command line interface (CLI)
* Student has root-level access to a computer running Linux
	* Project description assumes compatibility with a version of Linux derived from Debian GNU/Linux 8.1
* Student's Linux computer has the following components installed:
	* Apache web server compatible with Apache 2
	* PHP apache module compatible with PHP 7
		* with MySQL support
	* MySQL database management server compatible with MySQL 5.7
* Instructor has root-level access to the student's Linux computer via SSH
* The Apache web server's DocumentRoot is set to /var/www/html
* Student has access to a second computer with following characteristics:
	* Accessible web server with server-side scripting language (similar to Apache with PHP) referred to later as "server2"



### Getting Started

Students may collaborate on this "Getting Started" section. Students may not collaborate on the remaining sections of the assignment.

Each student has been assigned a virtual lab machine for this project ("server"). The server has been configured to be a web server that hosts a vulnerable web application named "hackme". Students must make the hackme web application available at the following web address:

- http://[your server address]/hackme

To configure and start the web application complete the following steps:

1. Clone your student work repository to your server (it has the source code for the web application):

	```
	REMOT% git clone https://repo.cse.taylor.edu/work/{username}
	```

	The source code is already in your project directory for this assignment:
	
	`course/cos232/project/web/src`

2. Install Apache, MySQL, and PHP (the AMP part of a "LAMP" development environment, L is for Linux)

	**Important**: when prompted enter a password for the MySQL root password. Set the password to toor

	```
	REMOT% sudo apt-get install -y apache2 mysql-server php php-mysql libapache2-mod-php
	```


3. Configure the Apache web server to point the URL http://[your server address]/hackme to the source code directory `course/cos232/project/web/src`. To do this, add the following lined to the web server configuration file: `/etc/apache2/sites-enabled/000-default.conf`:

	```
	Alias "/hackme" "/{full path to repo directory}/course/cos232/project/web/src"
	<Directory /{full path to repo directory}/course/cos232/project/web/src>
		Options Indexes FollowSymLinks
		AllowOverride None
		Require all granted
	</Directory>
	```

4. Restart Apache and check to see if the site comes up in your browser. If not, get this working before moving forward. 

	```
	REMOT% sudo service apache2 restart
	```

	Browse to: http://[your server address]/hackme
	
	Note: You can't actually use the web application yet. You must configure the database.

5. Initialize the database:

	```
	REMOT% mysql -u root -p < {full path to repo directory}/course/cos232/project/web/src/db_schema.sql
	```

6. (optional) Reconfigure PHP to show errors. Might be helpful for debugging. Modify the php.ini configuration located at: `/etc/php/7.0/apache2/php.ini`
	- Change display_errors = Off to `display_errors = On`

7. Familiarize yourself with the application
	- Browse to: http://[your server address]/hackme
	- Register a few new users
	- Post a few messages to the forum as different users



## Milestone 1: Web Authentication

Many web applications require users to register for an account and authenticate each time they return to use the web application. The hackme web application requires users to register. The PHP file that handles new user registration is named `register.php`. Messages posted to the bulletin board are rendered by the PHP file `members.php`.

### Security Policy
Analyze the hackme authentication system. Consider the following security policies, does the hackme web application have security mechanisms in place to adequately enforce these policies?

1. Messages, including the title of a post, should:
	* only be viewable by registered users
	* only be submitted by registered users
	* only be deleted by registered users
2. If attackers obtain a copy of the database, user passwords should not be easily obtainable
3. Attackers should not be able to use snooping to obtain user credentials
	* HTTPS is not an option
4. Should resist brute-force attacks aimed at guessing user passwords
5. Should enforce a strong password scheme, including at minimum:
	* Password should be longer than 8 characters in length
	* Password should not be a dictionary word


### Output

#### a.) Essay
In 500 words or less, describe the password management system used by hackme. Include in your description whether or not hackme enforces the security policies listed. If hackme does not enforce the security policies adequately, **implement** fixes to make it compliant (if possible). Describe the changes you made if any.

#### b.) Secured Application
In addition to your essay:

* Commit and push changes made to hackme (if any)
* Make your repaired web application available to the instructor
	* The instructor will attempt to use your web application at the following location: `http://[your server address]/hackme`




## Milestone 2: XSS Attack and Remediation
The hackme web application is vulnerable to cross-site scripting (XSS) attack. Design and implement an XSS attack that satisfies the following requirements:

* A registered user, the attacker, posts a message to the bulletin board that contains a malicious payload
	* The message appears to be innocuous to the casual observer
* When other registered users, the victims, access the malicious message they fall victim to a XSS attack that transmits the victim username and password to the attacker's web server (server2)
* The attacker's web server (server2) hosts a web application that stores victim usernames and passwords in a plain-text file

Design and implement a fix for this XSS vulnerability.

### Output

#### a.) Essay
In 500 words or less, describe your attack and the design of your fix in detail.

#### b.) Implementation Details
In addition to your essay:

* Commit and push code changes made to hackme to fix the XSS vulnerability
* Submit the exact malicious message you used to leverage the XSS attack
	* The instructor will attempt to run the attack from an unpatched version of hackme
* Submit the source code for the web application installed on server2 that stores the username and passwords


## Milestone 3: CSRF Attack and Remediation
The hackme web application is vulnerable to a cross-site request forgery (CSRF) attacks. Design and implement a CSRF attack that satisfies the following requirements:

* A registered user, the victim, logs into the hackme web application
* The victim then visits the attacker's website hosted on server2
* The attacker's website appears to be innocuous. However, the attacker's webpage executes a CSRF attack and posts a spam message to the hackme bulletin board using the victim's credentials. The spam message has the following characteristics:
	* Title: You won!
	* Message: You have been selected for a free flying dragon ride.
* The message will be displayed on the hackme bulletin board and appear to have been posted by the victim user.
* The CSRF logic should be hidden completely from the user
	* You may assume that the user does not view the source of the webpage

Design and implement a fix for this CSRF vulnerability.

### Output

#### a.) Essay
In 500 words or less, describe your attack and the design of your fix in detail. Include in your description a discussion about how the victim might be lured to visit the malicious website.

#### b.) Implementation Details
In addition to your essay:

* Commit and push code changes made to hackme to fix the CSRF vulnerability
* Submit the source code for the web page installed on server2 that implements the CSRF attack


## Milestone 4: SQL Injection Attack and Remediation
The hackme web application is vulnerable to SQL injection attacks. Design and implement an SQL injection attack that allows a registered (attacker) user to obtain the password of any other bulletin board user if the victim username is known.

It is common for websites to use existing open source web applications. For your attack you may assume that the attacker (the student in this case) has the source code but not the database data. Feel free to inspect the source code carefully to craft the attack. You may **not** modify the hackme source code to leverage the attack.

Design and implement a fix for this **and** all other SQL injection vulnerabilities present in the hackme web application.

#### a.) Essay
In 500 words or less, describe your attack and the design of your fix(es) in detail.

#### b.) Implementation Details
In addition to your essay:

* Commit and push code changes made to hackme to fix the SQL injection vulnerabilities
* Submit the exact HTTP request you used to leverage the SQL injection attack. For full credit you must provide enough detail that the instructor can recreate the attack on an unmodified version of hackme.


## Grading

This assignment uses a progressive grading scheme. Students are required to push incremental work to a designated repository.

**Commit and push** your work for this assignment to the following Git repository and subdirectory:

- *Git Repository*: `https://repo.cse.taylor.edu/work/{username}`
- *Project Subdirectory*: `course/cos232/project/web`

Place essays in a Markdown file in the project subdirectory (`course/cos232/project/web`) named `solution.md`. Your solution.md file must be written in valid [Markdown](https://daringfireball.net/projects/markdown/)

- Detailed Markdown specification can be found: [http://spec.commonmark.org/0.27/](http://spec.commonmark.org/0.27/)
- Markdown should be structured semantically, ex.
	- For top-level heading: use `# Foo`
	- For second-level heading: use `## Foo`
	- For lists of items, use lists:
		- `- list item`
		- `- another list item`
	- etc

To get full credit, students must commit and push work that satisfies the milestone requirements on a schedule provided by the instructor.

The grade requirements for each part are described in the corresponding section above. The point allocation is shown in the following table:

| Part | Points |
|------|--------|
| Milestone 1 (a & b) | 50
| Milestone 2 (a & b) | 50
| Milestone 3 (a & b) | 50
| Milestone 4 (a & b) | 50
| **Total**	| 200 points