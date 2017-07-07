package com.veontomo.dispatcher

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

/**
 * Dispatcher controller
 *
 */
@RestController
@EnableAutoConfiguration
class Controller(val customerRepository: CustomerRepository, val requestRepository: RequestRepository) {

    init {
        print("class Controller is initialized with argument of ${customerRepository.javaClass.name} type")
    }

    @RequestMapping(value = "/main")
    fun mainpage(@RequestParam(value = "name", required = false, defaultValue = "User") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "mainpage"
    }

    @RequestMapping("/multi", method = arrayOf(RequestMethod.POST))
    fun multi(@RequestParam("file") submissions: Array<MultipartFile>): String {
        println("${submissions.size} elements are received")
        submissions.map { it.size }.forEach { requestRepository.save(Request(it)) }
        return submissions.mapIndexed {i, file -> "file ${i+1} size: ${file.size}" }.joinToString(", ")
    }

    @RequestMapping("/{name}")
    fun findByLastName(@PathVariable name: String) = customerRepository.findByLastName(name)


}
