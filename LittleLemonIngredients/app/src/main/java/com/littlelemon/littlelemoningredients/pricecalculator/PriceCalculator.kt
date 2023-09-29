package com.littlelemon.littlelemoningredients.pricecalculator

class PriceCalculator {

    fun calculatePrice(item1Price: Double, item2Price: Double, taxRate: Double): Double {
        return (item1Price + item2Price) * (1.0 + taxRate)
    }
}