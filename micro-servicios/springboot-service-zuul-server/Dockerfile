FROM openjdk:8
VOLUME /tmp
EXPOSE 9100
ADD ./target/springboot-service-zuul-server-0.0.1-SNAPSHOT.jar service-zuul-server.jar
ENTRYPOINT ["java","-jar","/service-zuul-server.jar"]