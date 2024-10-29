# Use an official OpenJDK 17 runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file to the container
COPY target/service-hello-1.0-SNAPSHOT.jar /app/service-hello-1.0-SNAPSHOT.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "service-hello-1.0-SNAPSHOT.jar"]