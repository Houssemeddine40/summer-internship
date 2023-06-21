FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/demo2-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "demo2-0.0.1-SNAPSHOT.jar"]
EXPOSE 8087
