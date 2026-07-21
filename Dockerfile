FROM openjdk:25-rc-jdk
VOLUME /tmp
ADD target/catoks-backend.jar catoks-backend.jar
ENTRYPOINT ["java", "-jar", "/catoks-backend.jar"]