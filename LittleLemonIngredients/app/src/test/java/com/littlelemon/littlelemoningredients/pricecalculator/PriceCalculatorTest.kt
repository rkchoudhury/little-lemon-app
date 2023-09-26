package com.littlelemon.littlelemoningredients.pricecalculator

import org.junit.Assert.*
import org.junit.Test

class PriceCalculatorTest {
    private val classUnderTest = PriceCalculator()

    @Test
    fun `validate calculation` () {
        val result = classUnderTest.calculatePrice(item1Price = 50.0, item2Price = 50.0, taxRate = 0.20)

        assertEquals(120.0, result, 0.001)
    }
}

