FROM tomcat:7-jre7
MAINTAINER gagan--8@gmail.com

#Install git
RUN apt-get update && apt-get install -y git

#Create & Change directory and clone the project Public POM repo into it.
RUN mkdir /usr/myProject \
    && cd /usr/myProject \
    && git clone https://github.com/Gans92/CareerGo.git
    
RUN cd /usr/myProject/CareerGo 

RUN apt-get install -y maven && apt-get install -y openjdk-7-jdk

RUN mvn clean install    

COPY /usr/myProject/CareerGo/target/CareerGo.war /usr/local/tomcat/webapps/CareerGo.war

CMD ["catalina.sh", "run"]