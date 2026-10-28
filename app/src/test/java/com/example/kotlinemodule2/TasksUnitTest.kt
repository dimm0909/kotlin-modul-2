package com.example.kotlinemodule2

import org.junit.Assert.assertEquals
import org.junit.Test

class TasksUnitTest {

    @Test
    fun testTask1HelloTextFormatting() {
        fun getHelloText(name: String?): String {
            return if (name.isNullOrBlank()) "Имя не задано" else "Привет, $name!"
        }

        assertEquals("Имя не задано", getHelloText(null))
        assertEquals("Имя не задано", getHelloText(""))
        assertEquals("Привет, Иван!", getHelloText("Иван"))
    }
}
