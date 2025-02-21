FROM openjdk:21
WORKDIR /opt
COPY target/*.jar /opt/app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#ENTRYPOINT exec java $JAVA_OPTS -jar app.jar