FROM openjdk:8-jdk-alpine
EXPOSE 8085
COPY target/lightfeather-0.0.1-SNAPSHOT.jar lightfeather.jar
ENTRYPOINT ["java","-jar","/lightfeather.jar"]