FROM adoptopenjdk:17-jdk
MAINTAINER NICO
EXPOSE 8080
COPY target/nico-0.0.1-SNAPSHOT.jar  nico-app.jar
ENTRYPOINT ["java","-jar","/nico-app.jar"]

#OtrasImagenes
#adoptopenjdk:17-jdk-hotspot-bionic  MAS RECOMENDADA
#adoptopenjdk:17-jre-hotspot-bionic
#amazoncorretto:17-alpine-jdk