# Use a lightweight Java base image
FROM openjdk:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port your app runs on (default is 8080)
EXPOSE 8082

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
