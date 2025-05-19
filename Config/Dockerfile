# Use an official OpenJDK runtime as a parent image
FROM maven:latest as build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROm openjdk:25-jdk-slim

COPY --from=build /app/target/*.jar /app/app.jar

# Run the application
CMD ["java", "-jar", "app/app.jar"]