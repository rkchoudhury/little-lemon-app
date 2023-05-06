package com.example.littlelemonlogin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

data class City(val name: String, val country: String)

// Saving the value using map for the configuration change
val citySaver = run {
    val nameKey = "Name"
    val countryKey = "Country"
    mapSaver(
        save = { mapOf(nameKey to it.name, countryKey to it.country) },
        restore = { City(it[nameKey] as String, it[countryKey] as String) }
    )
}

@Composable
fun CityInput() {
    var selectedCity by rememberSaveable(stateSaver = citySaver) {
        mutableStateOf(City("Madrid", "Spain"))
    }

    Column(
        modifier = Modifier.padding(16.dp),
    ) {
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

// Saving the value using list for the configuration change
val CitySaverList = listSaver<MainActivity.City, Any>(
    save = { listOf(it.name, it.country) },
    restore = { MainActivity.City(it[0] as String, it[1] as String) }
)

@Composable
fun CountryTextInput() {
    var selectedCity by rememberSaveable(stateSaver = CitySaverList) {
        mutableStateOf(MainActivity.City("Angul", "India"))
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, ${selectedCity.country}",
            modifier = Modifier.padding(bottom = 8.dp),
        )
        TextField(
            value = selectedCity.country,
            onValueChange = { selectedCity = MainActivity.City(selectedCity.name, it) },
            label = { Text(text = "City") }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCity() {
    Column {
        CityInput()
        CountryTextInput()
    }
}

