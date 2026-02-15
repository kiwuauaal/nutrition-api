package com.nutrition.api

import okhttp3.OkHttpClient
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class NutritionApiApplication {
    
    @Bean
    fun httpClient(): OkHttpClient = OkHttpClient()
    
    @Bean
    fun objectMapper(): ObjectMapper = ObjectMapper()
}

fun main(args: Array<String>) {
    runApplication<NutritionApiApplication>(*args)
}