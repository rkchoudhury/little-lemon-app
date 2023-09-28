package com.littlelemon.littlelemoningredients.lambda

/**
 * Example of Function as an object
 */
class A {
    //Here B is tightly coupled
    //Here we have access to all the variable and other functions of B
    //This is an overhead as here we only need displayMenuItems function nothing else
    fun loadMenuItems(instance: B) {
        val items = listOf<String>("salad", "cake", "ice cream")
        instance.displayMenuItems(items)
    }
}

class B {
    fun displayMenuItems(itemList: List<String>) {
        for (item in itemList) {
            println(item)
        }
    }
}

class C {
    //Not tightly coupled
    //Here we passed the function as an object
    fun loadMenuItems(displayMenuItems: (itemList: List<String>) -> Unit) {
        val items = listOf<String>("Chicken", "Milk", "Curd")
        displayMenuItems(items)
    }
}

//Normal function
fun displayItems(itemList: List<String>) {
    var itemCount = 0
    for (item in itemList) {
        ++itemCount
        println("$itemCount. $item")
    }

    println()

    for ((index, item) in itemList.withIndex()) {
        println("$index $item")
    }
}

fun main() {
    //Here B is tightly coupled
    A().loadMenuItems(B())
    println()

    //Using functional programming
    //Passed what is needed
    C().loadMenuItems { list -> B().displayMenuItems(list) }
    println()
    C().loadMenuItems { list -> displayItems(list) }
}