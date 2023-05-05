FROM amazoncorretto:17.0.7-alpine-jdk
COPY target/nico-0.0.1-SNAPSHOT.jar  nico-app.jar
ENTRYPOINT ["java","-jar","/nico-app.jar"]