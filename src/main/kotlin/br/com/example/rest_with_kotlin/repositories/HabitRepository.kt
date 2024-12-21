package br.com.example.rest_with_kotlin.repositories

import br.com.example.rest_with_kotlin.models.Habit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HabitRepository : JpaRepository<Habit, Long?> {
}