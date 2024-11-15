FROM maven:3.9.9-amazoncorretto-21-al2023 AS builder

WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml ./
RUN --mount=type=cache,target=/root/.m2,rw mvn dependency:go-offline -B -DskipTests

COPY src ./src

# Build and create a JAR file
RUN mvn clean package -DskipTests

# smaller base image for the runtime environment
FROM openjdk:21-oracle

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
