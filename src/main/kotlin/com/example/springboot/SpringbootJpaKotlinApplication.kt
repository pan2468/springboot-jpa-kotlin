package com.example.springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootJpaKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringbootJpaKotlinApplication>(*args)
}
