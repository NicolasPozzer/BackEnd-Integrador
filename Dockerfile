FROM amazoncorretto:17-alpine-jdk
MAINTAINER NICO
EXPOSE 8080
COPY target/nico-0.0.1-SNAPSHOT.jar  nico-app.jar
ENTRYPOINT ["java","-jar","/nico-app.jar"]