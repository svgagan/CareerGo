FROM tomcat:7-jre7
MAINTAINER gagan--8@gmail.com

#RUN ["rm", "-fr", "/usr/local/tomcat/webapps/CareerGo"]
#ENTRYPOINT ["mvn clean install"]
#COPY ./target/CareerGo.war /usr/local/tomcat/webapps/CareerGo.war

#CMD ["catalina.sh", "run"]

#Install git
RUN apt-get update \ && apt-get install -y git

#Create & Change directory and clone the project Public POM repo into it.
RUN mkdir /usr/myProject \
    && cd /usr/myProject \
    && git clone https://github.com/Gans92/CareerGo.git
    
RUN cd /usr/myProject/CareerGo 

CMD ["mvn clean install"]    

COPY /usr/myProject/CareerGo/target/CareerGo.war /usr/local/tomcat/webapps/CareerGo.war
