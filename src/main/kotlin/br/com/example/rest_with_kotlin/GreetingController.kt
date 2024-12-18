package br.com.example.rest_with_kotlin

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {
    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/gretting")
    fun greeting(@RequestParam(value="name", defaultValue="World") name: String?): Gretting {
        return Gretting(counter.incrementAndGet(), "Hello, $name!")
    }
}