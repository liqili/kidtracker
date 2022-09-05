FROM maven:3.6.3-jdk-8
MAINTAINER Sergey Shadchin (sergei.shadchin@gmail.com)

RUN mkdir -p /build
ADD build.sh /usr/local/bin/build.sh

RUN chmod u+x /usr/local/bin/build.sh

WORKDIR /build
CMD build.sh