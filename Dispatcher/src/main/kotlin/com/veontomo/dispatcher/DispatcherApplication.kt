package com.veontomo.dispatcher

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DispatcherApplication

fun main(args: Array<String>) {
    SpringApplication.run(DispatcherApplication::class.java, *args)
}
