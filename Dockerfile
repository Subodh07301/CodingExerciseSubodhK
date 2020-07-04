# For Java 8, try this
FROM openjdk:8-jdk-alpine

# For Java 11, try this
# FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/football-league-subodhk.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/football-league-subodhk.jar /opt/app/football-league-subodhk.jar
COPY ${JAR_FILE} football-league-subodhk.jar
EXPOSE 8080
# java -jar /opt/app/football-league-subodhk.jar
ENTRYPOINT ["java","-jar","football-league-subodhk.jar"]
# sudo docker build -t spring-boot:1.0 .
# sudo docker run -d -p 8080:8080 -t spring-boot:1.0
