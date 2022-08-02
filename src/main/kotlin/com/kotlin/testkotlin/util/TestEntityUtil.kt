package com.kotlin.testkotlin.util

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Component
class TestEntityUtil {
    fun getEntityIdFromString(id:String) : UUID {
        try {
            return UUID.fromString(id)
        }catch (ex: IllegalFormatException){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid UUID", ex)
        }
    }
}