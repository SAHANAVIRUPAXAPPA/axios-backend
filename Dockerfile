FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY pom.xml .
RUN ./mvnw -q -e -DskipTests dependency:go-offline || true

COPY src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java","-jar","target/axios-backend-0.0.1-SNAPSHOT.jar"]
