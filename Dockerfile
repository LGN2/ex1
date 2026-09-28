FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw -q -DskipTests dependency:go-offline
COPY src src
RUN ./mvnw -q -DskipTests package
ENTRYPOINT ["java","-jar","target/property-management-0.0.1-SNAPSHOT.jar"]