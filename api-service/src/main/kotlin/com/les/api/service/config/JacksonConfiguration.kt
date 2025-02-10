package com.les.api.service.config

import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
class JacksonConfiguration {

    @Bean
    fun jackson2ObjectMapperBuilderCustomizer() : Jackson2ObjectMapperBuilderCustomizer {
        return Jackson2ObjectMapperBuilderCustomizer {
            builder ->  builder.modules(kotlinModule())
        }
    }
}