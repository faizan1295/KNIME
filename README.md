# KNIME API TEST

## Description

This project demonstrates an understanding of automated functional testing for a REST API by writing tests for the KNIME Hub's REST API. The tests verify that space creation and deletion functionalities work for logged-in users. This README provides instructions on how to set up and run the project, including prerequisites and usage details.

## Prerequisites

Before running the project, ensure you have the following installed:

- [Java Development Kit (JDK) 11 or later](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)
- A KNIME Hub account (create one [here](https://hub.knime.com/))
- Authentication Token: To execute API tests successfully, you need a valid authentication token (knime_hub_auth). This token is necessary because JWT tokens expire periodically. Ensure you have the token ready before running the tests.

## Installation

1. Clone the repository from GitHub:
   ```
    git clone https://github.com/your-username/knime-api-testing.git
   ```
2. Install the project dependencies using Maven
   ### Dependencies

- **REST-assured**: Java DSL for easy testing of REST services.
- **JUnit 5 (Jupiter)**: Framework for unit testing.
- **Jackson Databind**: Library for processing JSON.

### Maven Configuration (`pom.xml`)

Here is the `pom.xml` file used in this project:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>API-TEST</groupId>
    <artifactId>rest_api_testing</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <!-- Define the Java compiler version -->
    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <!-- Add dependencies for REST-assured and JUnit -->
    <dependencies>
        <!-- REST-assured: Java DSL for easy testing of REST services -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>4.3.3</version>
            <scope>test</scope>
        </dependency>
        
        <!-- JUnit 5 (Jupiter) for unit testing -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.7.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.7.0</version>
            <scope>test</scope>
        </dependency>
        
        <!-- Add JSON processing support if needed -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.10.3</version>
        </dependency>
    </dependencies>

    <!-- Optional: Define the Maven Surefire plugin for running tests -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <includes>
                        <include>/*Test.java</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
## Project Structure

The project uses Maven for dependency management and build automation. The main configuration is in the `pom.xml` file, which includes the following key dependencies and plugins

## (@BeforeAll Method)
In the @BeforeAll setup method (setup()), RestAssured is configured with the base URI and authentication cookie required for accessing the KNIME Hub API.
## @Test Method
The testCreate() method executes a PUT request to create a new space using RestAssured, utilizing the configured authentication cookie and specifying the endpoint URI based on spaceId.
## Explanation
-@BeforeAll Setup: Initializes RestAssured with the base URI (https://api.hub.knime.com) and sets the cookievalue and spaceId variables for authentication and constructing API endpoints.
-@Test Method: Sends a PUT request to create a new space. It includes the authentication token (cookievalue) in the Cookie header and validates the response status code (201 Created).
## Notes
-Ensure the cookievalue and spaceId variables are updated as per your authentication requirements and API endpoints.
-Customize the requestBody and assertions in testCreate() based on your API's payload and expected responses.

## Usage
Run the tests:

-Right-click on the test file SpaceManagementTests.java.
-Select Run As -> JUnit Test

## Test Details 

The tests are designed to perform the following:

- **Login to KNIME Hub**: Authenticate using provided credentials.
- **Create a Space**: Verify that a new space can be created.
- **Make Space Public**: Make the space public.
- **Delete the Space:** Verify that the created space can be deleted.

## Configuration
Update the src/test/resources/config.properties file with your KNIME Hub account credentials:

-knime.username=your-username
-knime.password=your-password

## Contact
If you have any questions, feel free to contact me at faizanabbas1295@gmail.com
  
  
