# Stage 1: build with Maven + JDK 17
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /workspace

# Copy pom & mvnw
COPY pom.xml mvnw ./
COPY .mvn .mvn
# Copy source code
COPY src ./src

# Build the project (skip tests for faster build)
RUN mvn -B -DskipTests package

# Stage 2: run minimal JRE
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy jar from build stage
COPY --from=build /workspace/target/*.jar app.jar

# Run command (Render will set $PORT automatically)
CMD ["sh", "-c", "java -Dserver.port=${PORT:-8085} -jar /app/app.jar"]
