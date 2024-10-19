# Kotlin Spring Boot API with Karate Testing

## Introduction

This project is a Kotlin-based Spring Boot application with integrated API testing using Karate. It demonstrates a Shopping Cart API as the use case while showcasing the following key functionalities:

- Security setup with Spring Security
- Basic and advanced API testing using Karate
- JWT Authentication for securing endpoints
- Environment-specific configurations for running tests in multiple environments
- Chaining API requests and handling asynchronous operations

## Getting Started

### Prerequisites

- JDK 21
- Kotlin 1.9.25
- Docker (optional, for containerized testing)
- Gradle

### Installation

Clone the repository:

```bash
git clone https://github.com/your-username/kotlin-spring-boot-karate.git
cd kotlin-spring-boot-karate
```

### Build and Run

Make sure to build and sync Gradle to resolve dependencies:

```bash
./gradlew build
```

Run the Spring Boot application:

```bash
./gradlew bootRun
```

### Running Tests

You can run the API tests with Karate by simply executing:

```bash
./gradlew test
```

For running the tests in a specific environment (e.g., production):

```bash
./gradlew test -Dkarate.env=prod
```

### Docker Setup

You can also use Docker to containerize the app and run it.

1. First, build the Docker image:

```bash
docker build -t kotlin-spring-boot-api .
```

2. Run the app using Docker Compose:

```bash
docker-compose up
```

## Project Structure

```bash
src
├── main
│   └── kotlin       # Your main Kotlin code
└── test
    ├── kotlin       # Your test runner (Karate + Kotlin)
    └── resources    # Karate feature files
```

### Key Components

- **Shopping Cart API**: A simple API for managing shopping cart items, designed with Kotlin and Spring Boot.
- **SecurityConfig**: Configures Spring Security to disable CSRF, essential for testing APIs.
- **Karate Tests**: Includes various tests for basic and advanced use cases (e.g., JWT Authentication, Data-driven testing).
