#!/bin/bash

case $1 in
  'hsqldb') PORT=7001;;
  'h2') PORT=7002;;
  'sqlite') PORT=7003;;
  'derby') PORT=7004;;
#  'firebird') PORT=7005;;
  *) echo "app $1 not found";exit 1;;
esac

docker run --rm -p 8080:$PORT spring-fs-"$1"