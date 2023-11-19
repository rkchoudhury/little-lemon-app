package com.littlelemon.littlelemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.littlelemon.littlelemon.databases.AppDatabaseInstance
import com.littlelemon.littlelemon.databases.MenuItemRoom
import com.littlelemon.littlelemon.navigations.AppNavigation
import com.littlelemon.littlelemon.networks.MenuItemNetwork
import com.littlelemon.littlelemon.networks.MenuNetwork
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }

    private val database by lazy { AppDatabaseInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation(applicationContext)
                }
            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            if (database.isEmptyMenuItems()) {
                val menuItems = fetchMenu()
                Log.d("LITTLE_LEMON", "onCreate: fetched menu items of length ${menuItems.size}")
                saveMenuItems(menuItems)
            } else {
                Log.d("LITTLE_LEMON", "onCreate: menu items are already there in the db")
            }
        }
    }

    private suspend fun fetchMenu(): List<MenuItemNetwork> {
        val url =
            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
        val response = httpClient.get(url).body<MenuNetwork>()

        return response.menu ?: listOf()
    }

    private fun saveMenuItems(menuItems: List<MenuItemNetwork>) {
        val menuItemsRoom = menuItems.map {
            MenuItemRoom(
                id = it.id,
                title = it.title,
                description = it.description,
                price = it.price,
                image = it.image,
                category = it.category,
            )
        }
        database.insertAllMenuItems(menuItemsRoom)
    }
}