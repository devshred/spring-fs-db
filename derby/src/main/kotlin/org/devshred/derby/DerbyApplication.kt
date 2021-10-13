package org.devshred.derby

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication(scanBasePackages = ["org.devshred.shared", "org.devshred.derby"])
class DerbyApplication

fun main(args: Array<String>) {
    SpringApplication.run(DerbyApplication::class.java, *args)
}