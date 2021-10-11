package org.devshred.sqlite

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication(scanBasePackages = ["org.devshred.shared", "org.devshred.sqlite"])
class SqliteApplication

fun main(args: Array<String>) {
    SpringApplication.run(SqliteApplication::class.java, *args)
}