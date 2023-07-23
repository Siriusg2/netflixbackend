FROM maven:3.8.4-openjdk-11

WORKDIR /app

COPY .mvn ./.mvn
COPY pom.xml ./
COPY src ./src
RUN mvn clean install

CMD ["mvn", "spring-boot:run"]
