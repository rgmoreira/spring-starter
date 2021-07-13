FROM openjdk:11-jdk

RUN apt-get update && apt-get install -y --no-install-recommends maven ca-certificates-java ca-certificates && apt-get autoremove -y

WORKDIR /app

ENTRYPOINT if [ ! -f "mvnw" ]; then env && mvn spring-boot:run -U ; else env && ./mvnw spring-boot:run -U ; fi