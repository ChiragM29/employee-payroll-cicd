# Stage 1: Build stage using Maven and Eclipse Temurin JDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B clean package -DskipTests

# Stage 2: Runtime stage using lightweight Eclipse Temurin JRE 17
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/employee-payroll-cicd-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
