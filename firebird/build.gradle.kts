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

    implementation("org.firebirdsql.jdbc:jaybird:4.0.4.java11"){
        exclude("javax.resource:connector-api")
        exclude("net.java.dev.jna:jna")
    }
    implementation("javax.resource:connector-api:1.5")
    implementation("net.java.dev.jna:jna:5.9.0")
    implementation("org.firebirdsql.jdbc:fbclient:4.0.0.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}