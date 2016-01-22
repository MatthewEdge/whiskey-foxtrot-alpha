# WFA Application

[![Build Status](https://travis-ci.org/MatthewEdge/whiskey-foxtrot-alpha.svg?branch=master)](https://travis-ci.org/MatthewEdge/whiskey-foxtrot-alpha) [![Coverage Status](https://coveralls.io/repos/github/MatthewEdge/whiskey-foxtrot-alpha/badge.svg?branch=develop)](https://coveralls.io/github/MatthewEdge/whiskey-foxtrot-alpha?branch=develop)

by Matthew Edge

## Building

From the top level directory:

    mvn clean package
    
This will create the uber JAR artifact. A code coverage report is also generated in:

    target/surefire-reports/scoverage
    
There are XML reports for CI servers as well as a HTML report for human consumption.
The project is configured to fail if Code Coverage falls below 80%
    
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
is built using Spray for the HTTP Server. Akka Actors were used to support concurrent requests.