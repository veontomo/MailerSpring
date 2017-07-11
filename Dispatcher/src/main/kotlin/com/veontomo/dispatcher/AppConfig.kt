package com.veontomo.dispatcher

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Value("\${app.port}")
    var port: Int = -1
}