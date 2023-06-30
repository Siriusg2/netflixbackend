FROM openjdk:11

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} netflixconsulti.jar
EXPOSE 5000

ENTRYPOINT ["java", "-jar", "app.jar", "spring.config.location=file:application2.properties"]