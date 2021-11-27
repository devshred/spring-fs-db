FROM openjdk:11

ARG JAR_FILE
ARG PORT

RUN apt-get update -y && apt-get install -y libtommath-dev libtomcrypt-dev && \
    ln -sf /usr/lib/x86_64-linux-gnu/libtommath.so.1 /usr/lib/x86_64-linux-gnu/libtommath.so.0

WORKDIR /app
RUN groupadd app-group && useradd app-user && usermod -G app-group app-user
RUN mkdir -p /app/build /tmp && chown -R app-user.app-group /app /tmp
USER app-user
EXPOSE ${PORT}
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
