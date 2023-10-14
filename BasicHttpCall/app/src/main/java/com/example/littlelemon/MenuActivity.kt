package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
class MenuCategory(
    val menu: List<String>
)


class MenuActivity : ComponentActivity() {
    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }
    private val responseLiveData = MutableLiveData<List<String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val responseState = responseLiveData.observeAsState(emptyList()).value
                    Column {
                        Button(
                            onClick = {
                                lifecycleScope.launch {
                                    val menuItems = getMenu("Salads")
                                    runOnUiThread {
                                        responseLiveData.value = menuItems
                                    }
                                }
                            }
                        ) {
                            Text(text = "Download")
                        }
                        MenuItems(responseState)
                    }
                }
            }
        }
    }

    private suspend fun getMenu(category: String): List<String> {
        val response: Map<String, MenuCategory> =
            httpClient.get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/littleLemonMenu.json")
                .body()
        return response[category]?.menu ?: listOf()
    }
}

@Composable
fun MenuItems(items: List<String>) {
    items.forEach {
        MenuItem(item = it)
    }
}

@Composable
fun MenuItem(item: String) {
    Text(text = item)
}