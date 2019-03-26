FROM tomcat:7-jre7
MAINTAINER Gagan

#Install git, maven and Java
RUN apt-get update && apt-get install -y git
RUN apt-get install -y maven && apt-get install -y openjdk-7-jdk

#Create & Change directory and clone the project Public POM repo into it.
RUN mkdir /usr/myProject \
    && cd /usr/myProject \
    && git clone https://github.com/Gans92/CareerGo.git \
	&& cd /usr/myProject/CareerGo \
	&& mvn clean install

COPY /target/CareerGo.war /usr/local/tomcat/webapps/
#ADD /usr/myProject/CareerGo/target/CareerGo.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]