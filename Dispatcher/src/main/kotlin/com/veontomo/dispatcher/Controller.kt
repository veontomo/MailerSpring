package com.veontomo.dispatcher

import com.sun.corba.se.impl.activation.RepositoryImpl
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.ui.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Dispatcher controller
 *
 */
@RestController
@EnableAutoConfiguration
class Controller(val repository: CustomerRepository) {

    init {
        print("class Controller is initialized with argument of ${repository.javaClass.name} type")
    }

    @RequestMapping("/main")
    fun mainpage(@RequestParam(value = "name", required = false, defaultValue = "User") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "mainpage"
    }

    @RequestMapping("/{name}")
    fun findByLastName(@PathVariable name: String): List<Customer> {
        repository.findAll().forEach {
            System.out.println(it)
        }
        val tmp = repository.findByLastName(name)
        print(tmp)
        return tmp
    }

}
