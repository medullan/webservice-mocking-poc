ROM fedora:latest

MAINTAINER Denis Bell

#RUN yum -y update

# Install Java.
RUN yum -y install java-1.7.0-openjdk

RUN yum -y install wget

RUN wget http://repo1.maven.org/maven2/com/github/tomakehurst/wiremock/1.50/wiremock-1.50-standalone.jar

CMD ["nohup java -jar /vagrant/wiremock-1.50-standalone.jar  --port=9999  > /dev/null 2>&1 &"]

EXPOSE 9999