FROM openjdk:8
EXPOSE 8080
ADD target/docker-first-file.jar app.jar
ENTRYPOINT [ "java","-jar","/docker-first-file.jar" ]