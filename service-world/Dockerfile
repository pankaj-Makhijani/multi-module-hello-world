# Stage 1: Build the service-world application
FROM maven:3.8.5-openjdk-17 AS builder 
WORKDIR /app

# Copy the root pom.xml for dependency resolution and project structure
COPY ../pom.xml /app/pom.xml
COPY ../service-world/pom.xml /app/service-world/pom.xml

# Copy the source files of the entire project into the container
COPY .. /app

# Build the service-world module specifically
RUN mvn clean package spring-boot:repackage

# Stage 2: Run the service-world application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/service-world/target/service-world-1.0-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
