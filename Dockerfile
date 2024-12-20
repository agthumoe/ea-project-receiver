FROM openjdk:21

VOLUME /tmp
COPY . tmp/target/
ADD target/ea-project-receiver.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8080
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]