package com.veontomo.Reception

import org.json.JSONObject
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.ui.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

/**
 * Reception controller
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

    @RequestMapping(value = "/{origin}/{action}", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun entry(@PathVariable("origin") origin: String,
              @PathVariable("action") action: String,
              @RequestPart("files") files: Array<MultipartFile>,
              @RequestPart("data") data: String): String {
        return "$origin/$action"
    }
}

