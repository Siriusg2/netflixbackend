FROM maven:3.9.1  AS MAVEN_BUILD
FROM java:11.0.18 AS JAVA_VERSION

WORKDIR /build/

COPY pom.xml ./
COPY src ./src/

RUN mvn clean install

FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

ARG version=${version}
COPY --from=MAVEN_BUILD /build/src/main/resources/application.properties /app/
COPY --from=MAVEN_BUILD /build/target/netflixconsulti.jar /app/app.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "app.jar", "spring.config.location=file:application.properties"]
