package com.littlelemon.littlelemoningredients.collectionprocessing

data class Order(
    val orderId: Int,
    val month: String,
    val amount: Int
)

fun main() {
    val orderList = listOf(
        Order(1, "August", 40),
        Order(2, "August", 27),
        Order(3, "September", 44),
        Order(4, "September", 57),
        Order(5, "October", 38),
    )

    val tax = 0.095

    val selectedOrders = orderList.filter { eachOrder -> eachOrder.month === "September" }
    val selectedOrderAmounts = selectedOrders.map { eachOrder -> eachOrder.amount * (1.0 + tax) }
    val totalOrderAmount =
        selectedOrderAmounts.fold(0.0) { total, currentAmount -> total + currentAmount }
    println(totalOrderAmount)

    val total = orderList.filter { eachOrder -> eachOrder.month === "September" }.map { it.amount * (1.0 + tax) }
        .fold(0.0) { total, currentAmount -> total + currentAmount }
    println(total)

}