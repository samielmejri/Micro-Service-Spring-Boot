FROM openjdk:8-jdk-alpine
#default port
EXPOSE 8009


ADD target/quizz-0.0.1-SNAPSHOT.jar quizz-0.0.1-SNAPSHOT.jar

ENTRYPOINT  ["java", "-jar", "quizz-0.0.1-SNAPSHOT.jar"]