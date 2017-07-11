package com.veontomo.dispatcher

import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Options
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@SpringBootApplication
class DispatcherApplication {
    // The code below is taken from here:
    // https://spring.io/blog/2016/02/15/developing-spring-boot-applications-with-kotlin
    @Bean
    @Primary
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
    val CONFIG_FILE = "c"
    println(args.joinToString())
    val options = Options()
    options.addOption(CONFIG_FILE, true, "configuration")
    val parser = DefaultParser()
    val cmd = parser.parse(options, args)
    if (cmd.hasOption(CONFIG_FILE)) {
//        val configFile = cmd.getOptionValue(CONFIG_FILE)
//        val config = ServerConfig(configFile)
        val app = SpringApplication(DispatcherApplication::class.java)
        val prop = mapOf("server.port" to 8899)
        app.setDefaultProperties(prop)
        app.run()
    } else {
        println("No c option")
    }


}

class ServerConfig(val configFile: String) {

}
