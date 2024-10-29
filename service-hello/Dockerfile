# Stage 1: Build the application
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and the source code to the container
COPY service-hello/pom.xml ./service-hello/
COPY service-hello/src ./service-hello/src

# Build the application
RUN mvn -f service-hello/pom.xml clean package

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file to the container
COPY --from=build /app/service-hello/target/service-hello-1.0-SNAPSHOT.jar ./service-hello-1.0-SNAPSHOT.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "service-hello-1.0-SNAPSHOT.jar"]
