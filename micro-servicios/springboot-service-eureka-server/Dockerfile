FROM openjdk:8
VOLUME /tmp
EXPOSE 8888
ADD ./target/springboot-service-eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]