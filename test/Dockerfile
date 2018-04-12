FROM openjdk:8
COPY target/test-1.0-SNAPSHOT.jar /test.jar
WORKDIR /
CMD ["java", "-jar", "-Dspring.profiles.active=development", "test.jar"]
