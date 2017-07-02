package com.veontomo.dispatcher

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DispatcherApplication {
    // The code below is taken from here:
    // https://spring.io/blog/2016/02/15/developing-spring-boot-applications-with-kotlin
    @Bean
    open fun init(repository: CustomerRepository) = CommandLineRunner {
        println("Saving customers")
        repository.save(Customer("Jack", "Bauer"))
        repository.save(Customer("Chloe", "O'Brian"))
        repository.save(Customer("Kim", "Bauer"))
        repository.save(Customer("David", "Palmer"))
        repository.save(Customer("Michelle", "Dessler"))
        repository.save(Customer("Michelle", "Dessler-2"))
        println("Done saving customers")
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(DispatcherApplication::class.java, *args)

}
