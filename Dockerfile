# Usar una imagen base con JDK 11 y Maven
FROM maven:4.0.0-openjdk-17 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al directorio de trabajo
COPY . /app

# Ejecutar Maven para construir el proyecto
RUN mvn clean package

# Crear una nueva imagen basada en OpenJDK 11
FROM openjdk:17-alpine

# Exponer el puerto que utilizará la aplicación
EXPOSE 8080

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build /app/target/nico-0.0.1-SNAPSHOT.jar /app/nico-app.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/nico-app.jar"]

#FROM openjdk:17-alpine
#MAINTAINER NICO
#EXPOSE 8080
#COPY target/nico-0.0.1-SNAPSHOT.jar  nico-app.jar
#ENTRYPOINT ["java","-jar","/nico-app.jar"]