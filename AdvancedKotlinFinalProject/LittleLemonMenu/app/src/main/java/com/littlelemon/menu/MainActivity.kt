package com.littlelemon.menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.view.MenuCompat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainActivity : ComponentActivity() {

    val productsList = mutableListOf(
        ProductItem("Black tea", 3.00, "Drinks", R.drawable.black_tea),
        ProductItem("Green tea", 3.00, "Drinks", R.drawable.green_tea),
        ProductItem("Espresso", 5.00, "Drinks", R.drawable.espresso),
        ProductItem("Cappuccino", 8.00, "Drinks", R.drawable.cappuccino),
        ProductItem("Latte", 8.00, "Drinks", R.drawable.latte),
        ProductItem("Mocha", 10.00, "Drinks", R.drawable.mocha),
        ProductItem("Boeuf bourguignon", 15.00, "Food", R.drawable.boeuf_bourguignon),
        ProductItem("Bouillabaisse", 20.00, "Food", R.drawable.bouillabaisse),
        ProductItem("Lasagna", 15.00, "Food", R.drawable.lasagna),
        ProductItem("Onion soup", 12.00, "Food", R.drawable.onion_soup),
        ProductItem("Salmon en papillote", 25.00, "Food", R.drawable.salmon_en_papillote),
        ProductItem("Quiche Lorraine", 17.00, "Dessert", R.drawable.quiche_lorraine),
        ProductItem("Custard tart", 14.00, "Dessert", R.drawable.custard_tart),
        ProductItem("Croissant", 7.00, "Dessert", R.drawable.croissant),
    )

    private val productsState: MutableStateFlow<Products> =
        MutableStateFlow(Products(productsList))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { InitUI() }
    }

    @Composable
    fun InitUI() {
        val products by productsState.collectAsState()
        ProductsGrid(products = products)
    }

    private fun startProductActivity(productItem: ProductItem) {
        //TODO instantiate intent and pass extra parameter from product
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.products_menu, menu)
        MenuCompat.setGroupDividerEnabled(menu, true)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.groupId == R.id.sorting) {
            val type = when (item.itemId) {
                R.id.sort_a_z -> SortType.Alphabetically
                R.id.sort_price_asc -> SortType.PriceAsc
                R.id.sort_price_desc -> SortType.PriceDesc
                else -> SortType.Alphabetically
            }
            productsState.update {
                Products(
                    SortHelper().sortProducts(
                        type,
                        productsList
                    )
                )
            }
        } else if (item.groupId == R.id.filter) {
            val type = when (item.itemId) {
                R.id.filter_all -> FilterType.All
                R.id.filter_drinks -> FilterType.Drinks
                R.id.filter_food -> FilterType.Food
                R.id.filter_dessert -> FilterType.Dessert
                else -> FilterType.All
            }
            productsState.update {
                Products(
                    FilterHelper().filterProducts(
                        type,
                        productsList
                    )
                )
            }
        }
        return true
    }
}