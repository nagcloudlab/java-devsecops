FROM maven:3.8.7-amazoncorretto-17 AS stage-1
WORKDIR /app
COPY pom.xml ./
COPY src/ ./src/
RUN mvn clean package -DskipTests


FROM amazoncorretto:17 AS stage-2
WORKDIR /app
COPY --from=stage-1 /app/target/greeting-service-0.0.1-SNAPSHOT.jar ./greeting-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "greeting-service.jar"]