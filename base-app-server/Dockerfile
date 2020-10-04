#############################################################################################
###                            Copy and Build Application                                 ###
#############################################################################################
FROM maven:3.6.0-jdk-11-slim AS build
COPY base-app-server/src /home/base-app/base-app-server/src
COPY base-app-server/pom.xml /home/base-app/base-app-server
COPY pom.xml /home/base-app
WORKDIR /home/base-app
RUN mvn -f /home/base-app/base-app-server/pom.xml clean install -Pprod

#############################################################################################
###                         Copy the jar and set the Entrypoint                           ###
#############################################################################################
FROM openjdk:11-jdk-slim
COPY --from=build /home/base-app/base-app-server/target/base-app.jar /usr/local/lib/app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/usr/local/lib/app.jar"]