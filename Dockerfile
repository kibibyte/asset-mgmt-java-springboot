FROM openjdk:17-jdk-slim
WORKDIR /asset-mgmt-app
CMD ["./gradlew", "clean", "bootJar"]
COPY app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]