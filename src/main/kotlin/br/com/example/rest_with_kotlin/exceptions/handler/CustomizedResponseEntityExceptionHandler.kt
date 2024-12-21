package br.com.example.rest_with_kotlin.exceptions.handler

import br.com.example.rest_with_kotlin.exceptions.ExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.WebRequest
import java.util.Date

class CustomizedResponseEntityExceptionHandler{
    fun handleResourceNotFoundExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse>{
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }
}