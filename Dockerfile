FROM openjdk:17
MAINTAINER nussi.net

COPY target/DrinkManager-0.0.1-SNAPSHOT.jar server.jar
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=production", "server.jar"]