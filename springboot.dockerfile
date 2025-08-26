FROM maven:3.9.8-eclipse-temurin-21 AS maven_build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
WORKDIR /taskmanager

COPY --from=maven_build /app/target/*.jar taskmanager.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "taskmanager.jar"]
