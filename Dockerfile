FROM maven:3.9.8-eclipse-temurin-21 AS build
COPY src /app/src
COPY pom.xml /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:21
COPY --from=build /app/target/*.jar /app/Ecommerce.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "Ecommerce.jar"]
