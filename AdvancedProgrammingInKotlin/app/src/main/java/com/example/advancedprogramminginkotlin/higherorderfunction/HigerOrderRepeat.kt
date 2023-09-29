package com.example.advancedprogramminginkotlin.higherorderfunction

import kotlin.random.Random

fun main() {
    val totalTimes: Int = 3
    var maximumDiscountValue: Int = 0

    repeat(totalTimes) { index ->
        val discount = Random.nextInt(10)
        println("Attempt ${index + 1}: $discount")
        if (maximumDiscountValue < discount) {
            maximumDiscountValue = discount
        }
    }

    println("The maximum discount is $maximumDiscountValue")
}