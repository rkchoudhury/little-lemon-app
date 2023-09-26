package com.littlelemon.littlelemoningredients.coffeemachine

interface MilkFrother {

    fun getMilk(): String
}

class CoffeeMachine(
    private val milkFrother: MilkFrother
) {

    fun makeCoffee(): String {
        return "Coffee with " + milkFrother.getMilk()
    }

}