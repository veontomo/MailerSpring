package com.veontomo.dispatcher

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

    @RequestMapping("/main")
    fun mainpage(@RequestParam(value = "name", required = false, defaultValue = "User") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "mainpage"
    }

    @RequestMapping("/{name}")
    fun findByLastName(@PathVariable name: String) = repository.findByLastName(name)
}
