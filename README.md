# Railway Reservation System

This is a simple Railway Reservation System built using Java Spring Boot Framework and MySQL database. The system allows users to book train tickets and view their bookings.

## Features

- User registration and authentication
- Book train tickets
- View booked tickets

## Prerequisites

- Java Development Kit (JDK) 21 or higher
- Maven
- MySQL Server

## Getting Started

1. Clone the repository:
   ```
   git clone https://github.com/Srikrishna-S-Nayak/Railway-Reservation-System-Using-Spring-Boot.git
   ```
   
2. Navigate to the project directory:
    ```
    cd Railway-Reservation-System-Using-Spring-Boot
    ```
    
3. Configure the MySQL database connection in `src/main/resources/application.properties`.

4. Build the project using Maven:
    ```
    mvn clean install
    ```
    
5. Run the application:
    ```
    mvn spring-boot:run
    ```
    
6. The application will start running on `http://localhost:8080`.

## Project Structure

## Project Structure

The project follows a typical Spring Boot application structure, organized into various packages and directories for better code organization and maintainability. The main components are:

- `config`: Contains configuration classes for the application and security.
- `controller`: Holds the controller classes responsible for handling HTTP requests and responses.
- `model`: Defines the entity classes and data models used in the application.
- `repository`: Includes the repository interfaces for interacting with the database.
- `security`: Handles user authentication and authorization.
- `service`: Contains the service classes.
- `resources/static`: Stores static assets like CSS, images, and other files.
- `resources/templates`: Holds the Thymeleaf template files for rendering views.

Please refer to the codebase directly for a more detailed understanding of the project structure.

## Technologies Used

- Java 21
- Spring Boot 3.2.4
- MySQL
- Thymeleaf
- Spring Security
- Spring Data JPA
- Maven
