# Multimodule project + file-system-based databases

Start all web projects in parallel:
```shell
./gradlew bootRun --parallel
```
---
Start one project only:
```shell
./gradlew :sqlite:bootRun
```
---
Empty all databases:
```shell
./gradlew clean
```