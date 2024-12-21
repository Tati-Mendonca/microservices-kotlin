package br.com.example.rest_with_kotlin.controllers

import br.com.example.rest_with_kotlin.models.Habit
import br.com.example.rest_with_kotlin.services.HabitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/habit")
class HabitController {

    @Autowired
    private lateinit var service: HabitService

    @GetMapping( produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Habit> {
        return service.findAll()
    }

    @GetMapping(value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findyById(@PathVariable(value = "id") id:Long
    ): Habit {
    return service.findById(id)
    }

    @PostMapping( consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])

   fun create(@RequestBody habit: Habit): Habit {
        return service.create(habit)
    }

    @PutMapping( consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])

    fun update(@RequestBody habit: Habit): Habit {
        return service.update(habit)
    }

    @DeleteMapping( value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value = "id") id:Long) : ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}