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
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainActivity : ComponentActivity() {

    private val responseLiveData = MutableLiveData<String>()
    private val httpClient = HttpClient(Android)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        test()
        testGson()

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

    fun test() {
        val myData = """
        {
           "name": "Rakesh",
           "age": 27,
           "techStack": [
                "React-Native",
                "Javascript",
                "Android"
           ],
           companies: [
                {
                    "name": "Tech Mahindra"
                },
                {
                    "name": "Honeywell"
                }
           ]
           
        }
    """.trimIndent()

        val data = JSONObject(myData) // create JSON obj from string

//        val json2: JSONObject = json.getJSONObject("name") // this will return correct


        println("rkkk $data")
        println("rkkk " + data["name"])
        println("rkkk " + data["techStack"])
        println("rkkk " + data.getJSONArray("techStack"))
//        println("rkkk " + json["companies"][1])

        println("rkkk " + data.getJSONArray("companies"))
        println("rkkk " + data.getJSONArray("companies").get(0))
        println("rkkk " + data.getJSONArray("companies").getJSONObject(0)["name"])
        println("rkkk " + data.getJSONArray("companies")[1])

    }

    fun testGson() {
        val myData = """
        {
           "name": "Rakesh",
           "age": 27,
           "techStack": [
                "React-Native",
                "Javascript",
                "Android"
           ],
           companies: [
                {
                    "name": "Tech Mahindra",
                    "entryYear": 2018,
                    "exitYear": 2021
                },
                {
                    "name": "Honeywell",
                    "entryYear": 2021
                }
           ]
           
        }
    """.trimIndent()

        val gson = Gson()

        val data = gson.fromJson<Profile>(myData, Profile::class.java)

        data.techStack.forEach { println(it) }

        data.companies.forEach {
            println(
                """
            Company Name: ${it.name}
            Entry Year: ${it.entryYear}
            Exit Year: ${it.exitYear}
        """.trimIndent()
            )
        }
    }
}

data class Company(
    val name: String,
    val entryYear: Int,
    val exitYear: Int,
)

data class Profile(
    val name: String,
    val age: Int,
    val techStack: List<String>,
    val companies: List<Company>
)