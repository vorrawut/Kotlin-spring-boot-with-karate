# Build stage: Use Gradle to build the Kotlin Spring Boot app
FROM openjdk:21-jdk-slim AS build

WORKDIR /temp

# Copy all project files
COPY . .

# Run Gradle to build the Spring Boot JAR
RUN ./gradlew clean bootJar

# Final stage: Create a lightweight container with the app JAR
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the generated JAR file from the build stage
COPY --from=build /temp/build/libs/*.jar /app/app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]