FROM eclipse-temurin:17
VOLUME /tmp
COPY build/libs/leasing-0.0.1-SNAPSHOT.jar leasing.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/leasing.jar"]