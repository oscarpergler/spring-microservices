FROM openjdk:21
COPY ./target/user-0.0.1-SNAPSHOT.jar /usr/src/user/
WORKDIR /usr/src/user
EXPOSE 8083
CMD ["java", "-jar", "user-0.0.1-SNAPSHOT.jar"]