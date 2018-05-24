# Web Server

## Assignment Purpose

The purpose of this assignment was to write a general-purpose web server in C.

## Requirements

The requirements for the web server were as listed below:

- Implements a subset of the HTTP/1.1 specification
	- Must handle the following HTTP request types: GET, HEAD
	- Responds with an error if the request is malformed
- Listens for connections on a socket that is bound to a network port number
	- Port number is specified as a command line argument (see Command
	  Arguments section)
	- Handles non-persistent connections (support for persistent connections is
  	  not required)
	- Can handle multiple requests simultaneously (using fork to spawn multiple
	  processes)
- Determine if requested file exists (see File Handling section):
	- If yes, transmit file with appropriate HTTP response headers
	- If no, transmit appropriate HTTP error code and message

## Usage

The executable expects two command line arguments as listed below:

1. DOCROOT: server path to web server files
2. PORT: what network port to use

Example:
```shell
% ./http-server /tmp/www/htdocs 8080
```