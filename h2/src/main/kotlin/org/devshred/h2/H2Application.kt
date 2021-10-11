package org.devshred.h2

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication(scanBasePackages = ["org.devshred.shared", "org.devshred.h2"])
class H2Application

fun main(args: Array<String>) {
    SpringApplication.run(H2Application::class.java, *args)
}