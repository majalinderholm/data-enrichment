# Stage 1: Build Stage
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime Stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/data-enrichment-0.0.1-SNAPSHOT.jar ./data-enrichment-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "data-enrichment-0.0.1-SNAPSHOT.jar"]