package com.littlelemon.littlelemoningredients.coffeemachine

import org.junit.Assert.assertEquals
import org.junit.Test

class FakeMilkFrother : MilkFrother {

    override fun getMilk(): String {
        return "hot milk"
    }
}

class FakeMilkFrother1 : MilkFrother {

    var getMilkLogic: () -> String = { "cold milk" }

    override fun getMilk(): String {
        return getMilkLogic()
    }
}

class CoffeeMachineTest {
    private val milkFrother = FakeMilkFrother()
    private val classUnderTest = CoffeeMachine(milkFrother)


    @Test
    fun `validate makeCoffee - hot coffee`() {
        val actualResult = classUnderTest.makeCoffee()
        assertEquals("Coffee with hot milk", actualResult)
    }

    @Test
    fun `validate makeCoffee - cold coffee`() {
        val milkFrother = FakeMilkFrother1()
        val classUnderTest = CoffeeMachine(milkFrother)

        val actualResult = classUnderTest.makeCoffee()
        assertEquals("Coffee with cold milk", actualResult)
    }

    @Test
    fun `validate makeCoffee - with empty value`() {
        val milkFrother = FakeMilkFrother1()
        val classUnderTest = CoffeeMachine(milkFrother)

        milkFrother.getMilkLogic = { "" }

        val actualResult = classUnderTest.makeCoffee()
        assertEquals("Coffee with ", actualResult)
    }

    @Test
    fun `validate makeCoffee - should throw exception`() {
        val milkFrother = FakeMilkFrother1()
        val classUnderTest = CoffeeMachine(milkFrother)

        //  NoPowerException()
        milkFrother.getMilkLogic = { throw java.lang.Exception("NoPowerException") }

        try {
            // This will throw a NoPowerException
            val actualResult = classUnderTest.makeCoffee()
        } catch (e: java.lang.Exception) {
            println(e.message)
            assertEquals("NoPowerException", e.message)
        }
    }
}