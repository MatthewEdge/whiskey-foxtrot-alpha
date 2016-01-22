# WFA Application

[![Build Status](https://travis-ci.org/MatthewEdge/whiskey-foxtrot-alpha.svg?branch=develop)](https://travis-ci.org/MatthewEdge/whiskey-foxtrot-alpha) [![Coverage Status](https://coveralls.io/repos/github/MatthewEdge/whiskey-foxtrot-alpha/badge.svg?branch=develop)](https://coveralls.io/github/MatthewEdge/whiskey-foxtrot-alpha?branch=develop)

by Matthew Edge

## Running

From source, running the ```edge.wfa.Main``` class will spin up the Akka HTTP Web Server on localhost, port 8080. To submit
IP conversion requests, use the following URL:

    http://localhost:8080/ip?ip=IP_HERE
    
Where ```IP_HERE``` is replaced by the desired IPv4 or IPv6 address to convert

## Building

From the top level directory:

    mvn clean package
    
This will create the uber JAR artifact. 

A code coverage report is also generated in:

    target/site/scoverage
    
There are XML reports for CI servers as well as a HTML report for human consumption
    
## Testing

Tests for the backend application are realized with the ScalaTest testing library. They can
be run using

    mvn test

## Structure

The web application resides in the wfa-webapp sub-module. The back-end REST service and business logic
resides in the wfa-backend sub-module. At build time, the web-app is copied over to a known location
for the backend so it can serve the files as static assets

## Modules

### wfa-backend

The backend module is a Scala application written using core Scala for the IP conversion logic. The REST service
is built using Akka HTTP for the HTTP Server/REST API. Akka Actors were used to support concurrent requests.

### wfa-webapp

Work in progress