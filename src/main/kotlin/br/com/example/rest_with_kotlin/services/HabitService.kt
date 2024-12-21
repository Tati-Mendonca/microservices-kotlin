package br.com.example.rest_with_kotlin.services

import br.com.example.rest_with_kotlin.exceptions.ResourceNotFoundException
import br.com.example.rest_with_kotlin.models.Habit
import br.com.example.rest_with_kotlin.repositories.HabitRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.logging.Logger

@Service
class HabitService {

    @Autowired
    private lateinit var repository: HabitRepository

    private val logger = Logger.getLogger(HabitService::class.java.name)

    fun findAll(): List<Habit> {
        logger.info("Finding all habits!")
        return repository.findAll()
    }

    fun findById(id: Long): Habit {
        logger.info("Finding one habit!")
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this Id") }
    }

    fun create(habit: Habit) : Habit {
        logger.info("Creating one new habit!")
        return repository.save(habit)
    }

    fun update(habit: Habit) : Habit{
        logger.info("Updating one new habit ID ${habit.id}!")
        val entity = repository.findById(habit.id)
            .orElseThrow { ResourceNotFoundException("No records found for this Id") }

        entity.name = habit.name
        entity.description = habit.description
        entity.frequency = habit.frequency
        entity.inComplited = habit.inComplited
        entity.daysDone = habit.daysDone
        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting one new habit ID ${id}!")
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this Id")
            }
        repository.delete(entity)
    }
}