package com.veontomo.Reception

/**
 * Reception application entry point.
 */
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ReceptionApplication

fun main(args: Array<String>) {
//    System.setProperty("server.port", "8070");
    SpringApplication.run(ReceptionApplication::class.java, *args)
}
