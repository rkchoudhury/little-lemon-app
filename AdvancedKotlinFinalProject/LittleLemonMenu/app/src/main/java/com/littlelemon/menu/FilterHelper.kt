package com.littlelemon.menu

class FilterHelper {//TODO create a FilterHelperTest and write a unit test for filterProducts

    fun filterProducts(type: FilterType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            FilterType.All -> productsList
            FilterType.Dessert -> TODO("only products with category equal to Dessert")
            FilterType.Drinks -> TODO("only products with category equal to Drinks")
            FilterType.Food -> TODO("only products with category equal to Food")
        }
    }

}