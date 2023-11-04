package com.littlelemon.littlelemondashboard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.littlelemon.littlelemondashboard.ui.theme.Grey
import com.littlelemon.littlelemondashboard.ui.theme.LittleLemonDashboardTheme
import com.littlelemon.littlelemondashboard.ui.theme.Purple200
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

    private val database by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database").build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonDashboardTheme {
                // add databaseMenuItems code here
                val databaseMenuItems by database.menuItemDao().getAll().observeAsState(emptyList())

                // add orderMenuItems variable here
                val orderMenuItems = remember {
                    mutableStateOf(false)
                }

                // add menuItems variable here
                var menuItems = if (orderMenuItems.value) {
                    databaseMenuItems.sortedBy { it.title }
                } else {
                    databaseMenuItems
                }

                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo",
                        modifier = Modifier.padding(50.dp)
                    )
                    Button(onClick = { orderMenuItems.value = true }) {
                        Text(text = "Tap to Order By Name")
                    }

                    // add searchPhrase variable here
                    val searchPhrase = remember {
                        mutableStateOf("")
                    }

                    // Add OutlinedTextField
                    OutlinedTextField(
                        value = searchPhrase.value,
                        onValueChange = { searchPhrase.value = it },
                        placeholder = { Text(text = "Enter name...") },
                        singleLine = true,
                        label = { Text(text = "Search") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Purple200,
                            unfocusedBorderColor = Grey,
                            unfocusedLabelColor = Grey,
                            placeholderColor = Grey
                        )
                    )

                    // add is not empty check here
                    if (searchPhrase.value != "") {
                        val filteredMenuItems = menuItems.filter {
                            it.title.lowercase().contains(searchPhrase.value.lowercase())
                        }
                        menuItems = filteredMenuItems
                    }

                    MenuItemsList(menuItems)

                }
            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            if (database.menuItemDao().isEmpty()) {
                val menuItems = fetchMenu()
                saveMenuToDatabase(menuItems)
            }
        }
    }

    private suspend fun fetchMenu(): List<MenuItemNetwork> {
        val url =
            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/littleLemonSimpleMenu.json"
        val response = httpClient.get(url).body<MenuNetwork>()
        // val response: MenuNetwork = httpClient.get(url).body() // Alternative way
        val menuItems: List<MenuItemNetwork> = response.menu ?: listOf()

        Log.d("rkkkkkk", "fetchMenu: ${menuItems.size}")
        return menuItems
    }

    private fun saveMenuToDatabase(menuItemsNetwork: List<MenuItemNetwork>) {
        val menuItemsRoom = menuItemsNetwork.map { it.toMenuItemRoom() }
        database.menuItemDao().insertAll(*menuItemsRoom.toTypedArray())
    }
}

@Composable
private fun MenuItemsList(items: List<MenuItemRoom>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 20.dp)
    ) {
        items(
            items = items,
            itemContent = { menuItem ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(menuItem.title)
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(5.dp),
                        textAlign = TextAlign.Right,
                        text = "%.2f".format(menuItem.price)
                    )
                }
            }
        )
    }
}