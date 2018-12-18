FROM tomcat:7-jre7
MAINTAINER gagan--8@gmail.com

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/CareerGo"]
ENTRYPOINT ["mvn clean install"]
COPY ./target/CareerGo.war /usr/local/tomcat/webapps/CareerGo.war

CMD ["catalina.sh", "run"]