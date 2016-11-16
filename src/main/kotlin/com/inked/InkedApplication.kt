package com.inked

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class InkedApplication {

}

fun main(args: Array<String>) {
    SpringApplication.run(InkedApplication::class.java, *args)
}
