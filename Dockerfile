FROM openjdk:11
WORKDIR /usr/app
COPY /target/report-0.0.1-SNAPSHOT.jar Mediscreen-Report.jar
CMD ["java", "-jar", "Mediscreen-Report.jar"]
EXPOSE 8082