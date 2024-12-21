package br.com.example.rest_with_kotlin.models

import jakarta.persistence.*

@Entity
@Table(name="habit")
data class Habit (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, length = 80)
    var name: String = "",

    @Column(length = 200)
    var description: String = "",

    @Column(nullable = false, length = 80)
    var frequency: String = "",

    @Column(name = "in_complited")
    var inComplited: Boolean = false,

    @Column(name = "days_done")
    var daysDone: Int = 0
)