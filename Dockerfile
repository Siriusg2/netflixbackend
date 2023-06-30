FROM openjdk:11

EXPOSE 5000
ADD ./target/netflixconsulti.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "spring.config.location=file:application2.properties"]
