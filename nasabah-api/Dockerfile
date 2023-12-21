FROM openjdk:17-oraclelinux8
ARG JAR_FILE=target/nasabah-api-1.0.0-release.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
EXPOSE 9001