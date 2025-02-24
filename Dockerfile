FROM openjdk:21
WORKDIR /opt
#COPY target/*.jar /opt/app.jar
COPY ./target/user-service.jar /opt/app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#ENTRYPOINT exec java $JAVA_OPTS -jar app.jar


#added this tag below in build section of pom.xml for the name of the jar
# <finalName>user-service</finalName>