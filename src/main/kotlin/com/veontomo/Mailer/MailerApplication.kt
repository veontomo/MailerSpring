package com.veontomo.Mailer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MailerApplication

fun main(args: Array<String>) {
    SpringApplication.run(MailerApplication::class.java, *args)
}
