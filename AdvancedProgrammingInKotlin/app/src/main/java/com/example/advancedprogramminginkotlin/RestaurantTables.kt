package com.example.advancedprogramminginkotlin

/*
 * RestaurantTables is a Singleton object
 * Only one instance of this class can exist
 */
object RestaurantTables {

    val customers: MutableList<String> = mutableListOf()

    fun addCustomer(customer: String) {
        customers.add(customer)
    }

    fun removeCustomer(customer: String) {
        customers.remove(customer)
    }
}