ARG FILE_NAME=app.jar
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY target/hello-service-0.0.1-SNAPSHOT.jar /app/${FILE_NAME}
ENTRYPOINT [ "java", "-jar", "${FILE_NAME}" ]


