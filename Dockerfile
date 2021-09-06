FROM adoptopenjdk:16-jre-hotspot
RUN mkdir /opt/app
ADD target/*.jar /opt/app/app.jar
CMD ["java", "-jar", "/opt/app/app.jar"]