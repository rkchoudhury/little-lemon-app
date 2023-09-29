package com.littlelemon.littlelemoningredients.collectionprocessing

data class OrderItem(
    val name: String,
    val amount: Int,
    val quantity: Int
)

fun main() {
    val orderItemList = listOf(
        OrderItem("Burger", 6, 2),
        OrderItem("Fries", 2, 1),
        OrderItem("Soda", 3, 3)
    )

    val totalAmount = orderItemList.fold(0) { totalOrderAmount, orderItem ->
        totalOrderAmount + (orderItem.amount * orderItem.quantity)
    }

    println(totalAmount)
}