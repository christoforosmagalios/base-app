#############################################################################################
###                            Copy and Build Application                                 ###
#############################################################################################
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app
RUN mvn -f /home/app/pom.xml clean install -Pprod

#############################################################################################
###                         Copy the jar and set the Entrypoint                           ###
#############################################################################################
FROM openjdk:11-jdk-slim
COPY --from=build /home/app/target/base-app.jar /usr/local/lib/app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/usr/local/lib/app.jar"]