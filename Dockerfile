# Use the official image as a parent image
FROM eclipse-temurin:17-jre-jammy

# Set the working directory in docker
WORKDIR /app

# Copy the jar file into the container at /app
COPY ./build/libs/recipe-enchange-platform-0.0.1-SNAPSHOT.jar /app/app.jar

# Instruct Docker to listen on port 3000 at runtime
EXPOSE 3000

# Specify the command to run on container start
CMD ["java", "-jar", "/app/app.jar"]
