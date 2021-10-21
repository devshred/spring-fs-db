package org.devshred.firebird

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication(scanBasePackages = ["org.devshred.shared", "org.devshred.firebird"])
class FirebirdApplication

fun main(args: Array<String>) {
    SpringApplication.run(FirebirdApplication::class.java, *args)
}