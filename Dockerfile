# Usar una imagen base con JDK 11 y Maven
FROM maven:3.8.1-openjdk-17 AS build

# Ejecutar Maven para construir el proyecto
RUN mvn clean package

FROM openjdk:17-alpine
MAINTAINER NICO
EXPOSE 8080

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build target/nico-0.0.1-SNAPSHOT.jar  nico-app.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/nico-app.jar"]


COPY target/nico-0.0.1-SNAPSHOT.jar  nico-app.jar
ENTRYPOINT ["java","-jar","/nico-app.jar"]