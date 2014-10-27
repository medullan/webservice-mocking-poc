FROM fedora:latest

MAINTAINER Denis Bell

#RUN yum -y update

# Install Java.
RUN yum -y install java-1.7.0-openjdk

RUN yum -y install wget

RUN yum -y install git

RUN wget http://repo1.maven.org/maven2/com/github/tomakehurst/wiremock/1.50/wiremock-1.50-standalone.jar

RUN git clone https://github.com/denisdbell/wiremock-mock-services.git

RUN  mv wiremock-1.50-standalone.jar wiremock-mock-services

ENTRYPOINT ["java","-jar","/wiremock-mock-services/wiremock-1.50-standalone.jar","--port=9999"]

EXPOSE 9999
