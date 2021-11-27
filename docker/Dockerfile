FROM eclipse-temurin:11.0.13_8-jre-alpine@sha256:6bb47aba5cebd4cb5ae09b64a54bcaf4fa5903dde0526a664e0b20528336075b

ARG JAR_FILE
ARG PORT

WORKDIR /app
RUN addgroup -S app-group && adduser -D -H -S app-user -G app-group -u 1000
RUN mkdir -p /app/build && chown -R app-user.app-group /app
USER app-user
EXPOSE ${PORT}
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
