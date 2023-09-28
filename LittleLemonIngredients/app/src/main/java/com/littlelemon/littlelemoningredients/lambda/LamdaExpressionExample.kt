package com.littlelemon.littlelemoningredients.lambda

/*
* Lambda Expression Example
*/

//Lambda Expression to define functions as objects
val taxCalculator: (Double, Double) -> Double = { price, taxRatio ->
    price * taxRatio
}

val taxCalculator1 = { price: Double, taxRatio: Double ->
    price * taxRatio
}

//Rk: We can combine both function type and argument type
val taxCalculator2: (Double, Double) -> Double = { price: Double, taxRatio: Double ->
    price * taxRatio
}

/*
* Lambda Expression as Extension function
*/

val taxCalculatorExtension: Double.(Double) -> Double = { taxRatio ->
    this * taxRatio
}

fun main() {
    println(taxCalculator(100.0, 0.65))
    println(taxCalculator1(10.0, 0.65))
    println(taxCalculator2(200.0, 0.50))

    println()

    println(taxCalculatorExtension(200.0, 0.10))
    println(100.0.taxCalculatorExtension(0.10))

}