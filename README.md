# WFA Application

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