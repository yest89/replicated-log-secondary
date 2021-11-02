FROM openjdk:15
ADD target/replicated-log-0.0.1-SNAPSHOT.jar replicated-log-0.0.1-SNAPSHOT.jar
EXPOSE 8091
ENV ACTIVE_PROFILE=dev
ENTRYPOINT ["java","-Djava.security.egd=f-ile:/dev/./urandom","-jar","replicated-log-0.0.1-SNAPSHOT.jar"]