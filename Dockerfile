FROM openjdk:11-jdk

ADD ./build/libs/findby-0.0.1-SNAPSHOT.jar findby.jar

CMD ["java", "-jar", "findby.jar"]