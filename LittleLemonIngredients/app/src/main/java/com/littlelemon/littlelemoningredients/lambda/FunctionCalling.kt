package com.littlelemon.littlelemoningredients.lambda

fun greet(name: String, function: (name: String) -> Unit) {
    function(name)
}

fun printName(name: String) {
    println("Hello $name")
}

fun main() {
    greet("Ram") { println("Hi $it") }

    greet("Sita", ::printName) //custom func name

    greet("Laxman", ::println) //Default fun name

    greet("Hanuman", { println("Hi $it") })

}