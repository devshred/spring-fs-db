val flywayVersion: String by rootProject.extra

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")

    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    implementation(project(":shared"))

    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.xerial:sqlite-jdbc:3.36.0.3")
//    implementation("com.github.gwenn:sqlite-dialect:0.1.0")
    implementation("org.flywaydb:flyway-core:${flywayVersion}")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}