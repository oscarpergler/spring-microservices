FROM openjdk:21
COPY ./target/post-0.0.1-SNAPSHOT.jar /usr/src/post/
WORKDIR /usr/src/post
EXPOSE 8081
CMD ["java", "-jar", "post-0.0.1-SNAPSHOT.jar"]