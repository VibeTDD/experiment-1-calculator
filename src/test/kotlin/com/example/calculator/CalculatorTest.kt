// src/test/kotlin/com/example/calculator/CalculatorTest.kt
package com.example.calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @ParameterizedTest
    @CsvSource(
        "2, 3, 5",
        "-2, -3, -5",
        "5, 0, 5",
        "0, 0, 0"
    )
    fun `should add numbers correctly`(a: Int, b: Int, expected: Int) {
        val result = calculator.add(a, b)
        result shouldBe expected
    }

    @ParameterizedTest
    @CsvSource(
        "7, 3, 4",
        "3, 7, -4"
    )
    fun `should subtract numbers correctly`(a: Int, b: Int, expected: Int) {
        val result = calculator.subtract(a, b)
        result shouldBe expected
    }

    @ParameterizedTest
    @CsvSource(
        "3, 4, 12",
        "5, 0, 0"
    )
    fun `should multiply numbers correctly`(a: Int, b: Int, expected: Int) {
        val result = calculator.multiply(a, b)
        result shouldBe expected
    }

    @Test
    fun `should divide two numbers`() {
        val result = calculator.divide(12, 3)
        result shouldBe 4
    }

    @Test
    fun `should throw exception when dividing by zero`() {
        val exception = org.junit.jupiter.api.assertThrows<ArithmeticException> {
            calculator.divide(10, 0)
        }
        exception.message shouldBe "Division by zero is not allowed"
    }
}