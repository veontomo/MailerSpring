package com.veontomo.Mailer

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.stereotype.Controller

/**
 * Mailer controller
 *
 */
@Controller
@EnableAutoConfiguration
class Controller() {

    @RequestMapping("/main")
    fun mainpage(@RequestParam(value = "name", required = false, defaultValue = "User") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "mainpage"
    }
}
