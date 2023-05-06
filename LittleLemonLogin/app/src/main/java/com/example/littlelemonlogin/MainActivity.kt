package com.example.littlelemonlogin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        LoginScreen()
                        CityScreen()
                        CityScreenList()
                    }
                }
            }
        }
    }

    @Composable
    fun LoginScreen() {
        var name by rememberSaveable { mutableStateOf("") }
        val (password, setPassword) = remember { mutableStateOf("") }

        Log.d("RKK", "LoginScreen: " + name)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.littlelemonlogo),
                contentDescription = "Logo Image"
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "Username") }
            )
            TextField(
                value = password,
                onValueChange = { setPassword(it) },
                label = { Text(text = "Password") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF495E57)
                )
            ) {
                Text(
                    text = "Login",
                    color = Color(0xFFEDEFEE)
                )
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun PreviewLoginScreen() {
        LoginScreen()
    }

    data class City(val name: String, val country: String)

    val CitySaver = run {
        val nameKey = "Name"
        val countryKey = "Country"
        mapSaver(
            save = { mapOf(nameKey to it.name, countryKey to it.country) },
            restore = { City(it[nameKey] as String, it[countryKey] as String) }
        )
    }

    @Composable
    fun CityScreen() {
        var selectedCity by rememberSaveable(stateSaver = CitySaver) {
            mutableStateOf(City("Madrid", "Spain"))
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Hello, ${selectedCity.name}",
                modifier = Modifier.padding(bottom = 8.dp),
            )
            TextField(
                value = selectedCity.name,
                onValueChange = { selectedCity = City(it, selectedCity.country) },
                label = { Text(text = "City") }
            )
        }
    }

    val CitySaver1 = listSaver<City, Any>(
        save = { listOf(it.name, it.country) },
        restore = { City(it[0] as String, it[1] as String) }
    )

    @Composable
    fun CityScreenList() {
        var selectedCity by rememberSaveable(stateSaver = CitySaver1) {
            mutableStateOf(City("Angul", "Odisha"))
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Hello, ${selectedCity.country}",
                modifier = Modifier.padding(bottom = 8.dp),
            )
            TextField(
                value = selectedCity.country,
                onValueChange = { selectedCity = City(selectedCity.name, it) },
                label = { Text(text = "City") }
            )
        }
    }
}
