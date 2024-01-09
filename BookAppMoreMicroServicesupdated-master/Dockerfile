# Use an official OpenJDK runtime as a parent image
#FROM openjdk:11-jre-slim
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/BookAppMoreMicroServices-0.0.1-SNAPSHOT.jar /app/
# Expose the port that the application will run on
#EXPOSE 8082

# Run the application
CMD ["java", "-jar", "BookAppMoreMicroServices-0.0.1-SNAPSHOT.jar"]