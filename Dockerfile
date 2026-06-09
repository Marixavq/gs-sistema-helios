FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY mvnw pom.xml ./
COPY .mvn .mvn

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/sistemahelios-0.0.1-SNAPSHOT.jar"]