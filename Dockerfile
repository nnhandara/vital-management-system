FROM eclipse-temurin:17-jdk-alpine

LABEL maintainer="Nyasha Nhandara"
LABEL application="Vitals Management System"

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
