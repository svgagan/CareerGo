FROM openjdk:8
ADD target/CareerGo.war CareerGo.war
EXPOSE 9090
ENTRYPOINT ["mvn clean install"]