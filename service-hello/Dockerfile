# Stage 1: Build the service-hello application 
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app

# Copy the root pom.xml for dependency resolution and project structure
COPY ../pom.xml /app/pom.xml
COPY ../service-hello/pom.xml /app/service-hello/pom.xml

# Copy the source files of the entire project into the container
COPY .. /app

# Build the service-hello module specifically
RUN mvn clean package spring-boot:repackage

# Stage 2: Run the service-hello application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/service-hello/target/service-hello-1.0-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
