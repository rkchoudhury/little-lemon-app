package com.littlelemon.menu

class FilterHelper {//TODO create a FilterHelperTest and write a unit test for filterProducts

    fun filterProducts(type: FilterType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            FilterType.All -> productsList
            FilterType.Dessert -> productsList.filter { item -> item.category == "Dessert" }
            FilterType.Drinks -> productsList.filter { item -> item.category == "Drinks" }
            FilterType.Food -> productsList.filter { item -> item.category == "Food" }
        }
    }

}