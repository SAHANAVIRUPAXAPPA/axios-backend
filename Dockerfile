FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

RUN apk add --no-cache maven

COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/axios-backend-0.1.0.jar"]
