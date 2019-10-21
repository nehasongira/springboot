FROM openjdk:11
WORKDIR usr/src
ADD ./target/stackroute-0.0.1-SNAPSHOT.jar /stackroute/src/stackroute-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/stackroute/src/stackroute-0.0.1-SNAPSHOT.jar"]


