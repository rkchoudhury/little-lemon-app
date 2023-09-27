package com.littlelemon.littlelemoningredients.generic

open class FoodItem

class Salad : FoodItem()

class IceCream : FoodItem()

fun <T : FoodItem> addFoodItemToCart(item: T) {
    println(item.javaClass)
}

fun <T> addFoodItemToCart1(item: T) {
    println(item)
}

fun main() {
    //With Generic constraint : Accept only FoodItem type
    addFoodItemToCart<Salad>(Salad())
    addFoodItemToCart<IceCream>(IceCream())
    addFoodItemToCart(IceCream())
    addFoodItemToCart<FoodItem>(IceCream())

    //This will give type mismatch error
    // addFoodItemToCart<String>("val")

    //With generic type: Accept any value
    addFoodItemToCart1(10)
    addFoodItemToCart1("rkk")
}