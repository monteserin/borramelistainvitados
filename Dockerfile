# Build stage
FROM maven:3.9.0-jdk-11-slim AS build 
COPY src /home/app/src 
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml 

# Run stage
FROM openjdk:8-alpine 
COPY --from=build /home/app/target/Spa-0.0.1-SNAPSHOT.war /usr/share/app.war 
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.war"]