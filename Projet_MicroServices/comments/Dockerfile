FROM openjdk:8
COPY target/comments-mysql-docker.jar .
EXPOSE 8085
ENTRYPOINT ["java","-jar","comments-mysql-docker.jar"]