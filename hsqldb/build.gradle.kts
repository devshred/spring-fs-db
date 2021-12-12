val flywayVersion: String by rootProject.extra

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")

    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":shared"))

    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    runtimeOnly("org.hsqldb:hsqldb:2.6.1")
    implementation("org.flywaydb:flyway-core:${flywayVersion}")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}