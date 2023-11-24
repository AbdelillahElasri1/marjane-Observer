FROM openjdk:21
WORKDIR /app
#EXPOSE 8080
COPY target/promotion-mar-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar" , "app.jar"]