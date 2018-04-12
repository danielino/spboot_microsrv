FROM openjdk:8
COPY target/test-1.0-SNAPSHOT.jar /test.jar
COPY wait-for-it.sh /
RUN chmod +x /wait-for-it.sh
WORKDIR /
CMD ["./wait-for-it.sh", "mongodb:27017", "--", "java", "-jar", "-Dspring.profiles.active=docker", "test.jar"]
