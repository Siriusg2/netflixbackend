# Etapa 1: Compilar la aplicación usando la imagen base de Maven
FROM adoptopenjdk/maven-openjdk11 AS build
ARG DB_URL_NETFLIX
ENV DB_URL_NETFLIX=$DB_URL_NETFLIX
ARG DB_USERNAME_NETFLIX
ENV DB_USERNAME_NETFLIX=$DB_USERNAME_NETFLIX
ARG DB_PASSWORD_NETFLIX
ENV DB_PASSWORD_NETFLIX=$DB_PASSWORD_NETFLIX
ARG authorization_token_NETFLIX
ENV authorization_token_NETFLIX=$authorization_token_NETFLIX
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

# Etapa 2: Crear una imagen mínima de Java 11 y ejecutar la aplicación
FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY --from=build /app/target/netflixconsulti.jar netflixconsulti.jar
EXPOSE 5000
CMD ["java", "-jar", "netflixconsulti.jar"]
