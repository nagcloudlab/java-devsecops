FROM maven:3.8.7-amazoncorretto-17 as stage1
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17 as stage2
WORKDIR /app
COPY --from=stage1 /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
