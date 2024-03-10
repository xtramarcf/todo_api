FROM openjdk:17-oracle

WORKDIR /app

COPY target/todo_api-0.0.1-SNAPSHOT.jar ./api.jar

EXPOSE 8181

CMD ["java", "-jar", "api.jar"]