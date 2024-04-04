FROM openjdk:21
COPY ./target/timeline-0.0.1-SNAPSHOT.jar /usr/src/timeline/
WORKDIR /usr/src/timeline
EXPOSE 8082
CMD ["java", "-jar", "timeline-0.0.1-SNAPSHOT.jar"]