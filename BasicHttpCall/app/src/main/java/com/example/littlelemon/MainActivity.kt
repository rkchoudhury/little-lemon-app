package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private var responseLiveData = MutableLiveData<String>()
    private val httpClient = HttpClient(Android)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val responseState = responseLiveData.observeAsState("").value
                    Column {
                        Button(
                            onClick = {
                                lifecycleScope.launch {
                                    val response = fetchContent()
                                    runOnUiThread {
                                        responseLiveData.value = response
                                    }
                                }
                            }
                        ) {
                            Text(text = "Download")
                        }
                        Text(text = responseState.toString())
                    }
                }
            }
        }
    }

    private suspend fun fetchContent(): String {
        val response: HttpResponse =
            httpClient.get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/littleLemonMenu.json")
        return response.bodyAsText()
    }
}
