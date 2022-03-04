FROM openjdk:11
EXPOSE 9003
ADD target/user-service.jar user-service.jar
ENTRYPOINT ["java","-jar","/user-service.jar"]

