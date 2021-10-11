package org.devshred.hsqldb

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication(scanBasePackages = ["org.devshred.shared", "org.devshred.hsqldb"])
class HsqldbApplication

fun main(args: Array<String>) {
    SpringApplication.run(HsqldbApplication::class.java, *args)
}