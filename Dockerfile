FROM eclipse-temurin:11-jdk-jammy

WORKDIR /src

COPY .mvn/ .mvn
COPY pom.xml ./
RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean install
COPY src ./src
CMD ["mvn", "spring-boot:run"]
