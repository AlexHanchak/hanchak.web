FROM openjdk:17-jdk-slim
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY . .
RUN curl -fsSL https://raw.githubusercontent.com/carlossg/maven-docker/master/install-maven.sh | bash && mvn --version
RUN mvn dependency:resolve
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]
