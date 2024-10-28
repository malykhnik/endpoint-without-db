FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/endpoint-without-db-0.0.1-SNAPSHOT.jar /app/endpoint-without-db.jar

ENTRYPOINT ["java", "-jar", "endpoint-without-db.jar"]