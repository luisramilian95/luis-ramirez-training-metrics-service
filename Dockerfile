FROM openjdk:11-jdk-slim
RUN mkdir -p /metrics-app

WORKDIR /metrics-app

COPY ./webapp/target/webapp-0.0.1-SNAPSHOT-exec.jar .

ENTRYPOINT [ "java", "-jar",  "webapp-0.0.1-SNAPSHOT-exec.jar", "-Pdocker"]