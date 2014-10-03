FROM fedora:latest

MAINTAINER Denis Bell

#RUN yum -y update

# Install Java.
RUN yum -y install java-1.7.0-openjdk

RUN yum -y install wget

RUN wget http://repo1.maven.org/maven2/com/github/tomakehurst/wiremock/1.50/wiremock-1.50-standalone.jar

RUN java -jar wiremock-1.50-standalone.jar --port=9999

EXPOSE 9999
