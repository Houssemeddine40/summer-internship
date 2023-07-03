#FROM openjdk:17-jdk-alpine
#WORKDIR /app
#COPY target/demo2-0.0.1-SNAPSHOT.jar .
#ENTRYPOINT ["java", "-jar", "demo2-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8087
FROM bitnami/java:17 as builder
RUN apt-get update -y && apt-get install maven -y
COPY . .
RUN mvn clean package -D maven.test.skip=true


FROM bitnami/java:17
ENV APPLICATION_DIR="/target/"
ENV MODULE="demo2-0.0.1-SNAPSHOT.jar"

COPY --from=builder $APPLICATION_DIR/$MODULE $APPLICATION_DIR/$MODULE
CMD java -jar $APPLICATION_DIR/$MODULE
EXPOSE 8087