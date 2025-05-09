FROM openjdk:24-ea-17-jdk-bookworm

COPY . /tmp
RUN mkdir /opt/app
WORKDIR /tmp
RUN ./mvnw package && rm -rf ~/.m2  && mv target/socket_lock_gate-RELEASE.jar /opt/app/socket_lock_gate.jar \
 && cd / && rm -rf /tmp/*

CMD ["java", "-jar", "/opt/app/socket_lock_gate.jar"]