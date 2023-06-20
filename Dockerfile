FROM openjdk:17
LABEL \
    maintainer = "Cristian Giovanny Sánchez Pineda harmaharcri@hotmail.com" \
    org.label-schema.name = "Text analyzer" \
    org.label-schema.description = "This service allows to extract some text features"

EXPOSE 8080
WORKDIR /usr/local/bin/
COPY ./ms-launcher/target/ms-launcher-0.0.1-SNAPSHOT.jar text-analyzer.jar
ENTRYPOINT ["java", "-jar", "text-analyzer.jar"]
