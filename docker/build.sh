#!/bin/bash

cd ..
./gradlew clean build -x test
cd docker

APPS="hsqldb h2 sqlite derby"
for app in $APPS; do

  case $app in
    'hsqldb') PORT=7001;;
    'h2') PORT=7002;;
    'h2v2') PORT=7003;;
    'sqlite') PORT=7004;;
    'derby') PORT=7005;;
    *) echo "app $1 not found";exit 1;;
  esac

  docker build -t spring-fs-$app -f Dockerfile --build-arg PORT=$PORT --build-arg JAR_FILE=./$app/build/libs/$app-1.0-SNAPSHOT.jar ../.
done