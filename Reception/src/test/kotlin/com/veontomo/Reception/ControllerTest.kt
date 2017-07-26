package com.veontomo.Reception


import org.hamcrest.Matchers.containsString
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


import org.junit.After
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import java.nio.charset.Charset

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc

class ControllerTest() {

    @Autowired
    lateinit private var mockMvc: MockMvc

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun indexControllerShouldReturnHtmlPage() {
        this.mockMvc.perform(get("/main"))
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("Hello from Reception")));
    }
    @Test
    fun getPlaceholders(){
        val first = MockMultipartFile("data", "filename.txt", "text/plain", "some data to send".byteInputStream(Charsets.US_ASCII));
        val request = MockMvcRequestBuilders.multipart("/first-part-of-url/second-part-of-url").file(first)

        this.mockMvc.perform(request)
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("first-part-of-url")))
                .andExpect(content().string(containsString("second-part-of-url")))
                .andExpect(content().string(containsString("some data to send")))
    }

}