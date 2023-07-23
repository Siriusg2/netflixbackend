# Etapa 1: Compilar la aplicación usando la imagen base de Maven
FROM adoptopenjdk/maven-openjdk11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

# Etapa 2: Crear una imagen mínima de Java 11 y ejecutar la aplicación
FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY --from=build /app/target/netflixconsulti.jar netflixconsulti.jar

ENV DB_URL_NETFLIX=jdbc:postgresql://localhost:5432/netflix
ENV DB_USERNAME_NETFLIX=postgres
ENV DB_PASSWORD_NETFLIX=123456
ENV authorization_token_NETFLIX="Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0OWJkMzY5ZWI2MjQzZTRjMjRiZDlmYmMzNTVhOTk0MCIsInN1YiI6IjY0OWVjYTYwYzlkYmY5MDEwN2UxY2Y1MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ._CrwC8_UAwCQLeMMLpIEPGBxu0TpM5wTmMAzokg6Ty8"

EXPOSE 5000
CMD ["java", "-jar", "netflixconsulti.jar"]
