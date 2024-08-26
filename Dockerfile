FROM gradle:7.5.1-jdk17 AS builder
WORKDIR /src/app

COPY . .
RUN ./gradlew clean bootJar

FROM openjdk:17-jdk-slim
WORKDIR /src/app

COPY --from=builder /src/app/build/libs/*.jar /app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]



