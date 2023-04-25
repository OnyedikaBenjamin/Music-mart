# Use a JDK 17 image as base
FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

#RUN chmod +x mvnw
#RUN ./mvnw dependency:resolve

COPY src ./src

EXPOSE ${PORT}

CMD ["./mvnw", "spring-boot:run"]