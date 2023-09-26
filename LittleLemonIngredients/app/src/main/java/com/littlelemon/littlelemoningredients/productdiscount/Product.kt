package com.littlelemon.littlelemoningredients.productdiscount

data class Product(
    val title: String,
    var price: Double,
    var amount: Int
) {

    fun applyDiscount(discountPercent: Int) {
        if (amount > 0 && amount <= 5) {
            price -= (price * discountPercent / 100)
        }
    }

}