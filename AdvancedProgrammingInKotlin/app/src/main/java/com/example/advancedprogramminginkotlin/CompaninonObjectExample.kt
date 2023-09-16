package com.example.advancedprogramminginkotlin


data class OrderItem(val name: String, val price: Double)

class TaxCalculator {
    var amount: Double = 0.00

    companion object {
        val salesTaxPercentage: Double = 15.0
        var gst: Double = 10.0

        fun getTaxAmountForOrderItems(orderItemList: List<OrderItem>): Double {
            var orderAmount: Double = 0.00

            for (item in orderItemList) {
                orderAmount += item.price
            }

            return (orderAmount * salesTaxPercentage) / 100
        }

        //Can't access `amount` here

        fun calculateGst() {
            println("${gst * 10}")
        }

    }
}

fun main() {
    println("Hello, world!!!")

    val orderList: MutableList<OrderItem> = mutableListOf()
    orderList.add(OrderItem("Burger", 8.00))
    orderList.add(OrderItem("Fries", 4.00))
    orderList.add(OrderItem("Soda", 3.00))

    println(TaxCalculator.getTaxAmountForOrderItems(orderList))

    TaxCalculator.calculateGst() //100.0

    //Able to change the value of gst as it is var
    //But we can not change the value of salesTaxPercentage as it is val
    TaxCalculator.gst = 7.00

    TaxCalculator.calculateGst() //70.0
}