package br.com.example.rest_with_kotlin.exceptions

import java.util.*

class ExceptionResponse (
    val timestamp: Date,
        val message: String?,
        val details: String
)