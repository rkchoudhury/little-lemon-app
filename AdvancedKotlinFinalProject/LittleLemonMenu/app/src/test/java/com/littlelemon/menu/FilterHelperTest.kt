package com.littlelemon.menu

import org.junit.Assert.*
import org.junit.Test

class FilterHelperTest {

    @Test
    fun `filterProducts_filterTypeDessert_croissantReturned`() {
        val sampleProductsList = mutableListOf(
            ProductItem(title = "Black tea", price = 3.00, category = "Drinks", R.drawable.black_tea),
            ProductItem(title = "Croissant", price = 7.00, category = "Dessert", R.drawable.croissant),
            ProductItem(title = "Bouillabaisse", price = 20.00, category = "Food", R.drawable.bouillabaisse)
        )

        val dessertList = FilterHelper().filterProducts(FilterType.Dessert, sampleProductsList)

        assertEquals(1, dessertList.size)
        assertEquals(listOf(ProductItem(title="Croissant", price=7.0, category="Dessert", image=2130968581)), dessertList)

        dessertList.contains(ProductItem(title="Croissant", price=7.0, category="Dessert", image=2130968581))
    }
}