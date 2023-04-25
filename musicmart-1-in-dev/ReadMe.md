# Travelway

This project implements a waitlist using Java SpringBoot.

# Prerequisites

    Java JDK 8 or higher
    Apache Maven 3.6 or higher
    springboot 3.0.0

# Installation and Usage

    Clone this repository to your local machine.
    Open the project in your preferred IDE.
    Build the project using Maven: mvn clean install.
    Run the project: mvn spring-boot:run.
    Open a web browser and go to http://localhost:8080/travelway.
    Use the web application to add, remove, or view customers on the waitlist.


# Entity Diagram

![img.png](src/main/resources/static/img.png)

# API Endpoints
This project includes the following REST API endpoints:
POST: Adds a new customer details to the waitlist.

# Configuration

This project uses a postgreSQL database for data storage. You can modify the database settings in the application.properties file.

# Testing

This project includes JUnit tests for the service layer. Run the tests using Maven: mvn test.

# Contributions

Contributions to this project are welcome. Please fork the repository and submit a pull request with your changes.

# License

This project is licensed under the MIT License - see the LICENSE.md file for details.
