FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu as base
# FROM openjdk:17

EXPOSE 8080
ADD ./target/microservice_1.jar microservice_1.jar
ENTRYPOINT [ "java", "-jar", "/microservice_1.jar" ]