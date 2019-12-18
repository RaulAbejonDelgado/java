FROM openjdk:8
VOLUME /tmp
ADD ./target/springboot-service-user-0.0.1-SNAPSHOT.jar service-user.jar
ENTRYPOINT ["java","-jar","/service-user.jar"]