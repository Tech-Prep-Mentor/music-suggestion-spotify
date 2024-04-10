# Start with a base image containing Java runtime
FROM maven:3.8.1-openjdk-17-slim AS build

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Change to the app directory
WORKDIR /app

# Copy only the necessary files
COPY src ./src
COPY pom.xml .

# Build the application
RUN mvn clean install

# The application's jar file
ARG JAR_FILE=target/*.jar

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]