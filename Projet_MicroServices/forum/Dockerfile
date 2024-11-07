FROM openjdk:8-jdk-alpine
#default port
EXPOSE 8086

ADD target/forum-0.0.1-SNAPSHOT.jar forum-0.0.1-SNAPSHOT.jar

ENTRYPOINT  ["java", "-jar", "forum-0.0.1-SNAPSHOT.jar"]
