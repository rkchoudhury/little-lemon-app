package com.littlelemon.sharedpreferencesexample

import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import com.littlelemon.sharedpreferencesexample.ui.theme.SharedPreferencesExampleTheme

/*
* Allow user to toggle between breakfast and launch menu
* Save user response on breakfast and launch menu
*/
class MenuActivity : ComponentActivity() {

    private val sharedPreferences by lazy {
        getSharedPreferences("LittleLemon", MODE_PRIVATE)
    }

    private val showLunchMenuLiveData = MutableLiveData<Boolean>()

    private val sharedPreferencesListener =
        OnSharedPreferenceChangeListener { sharedPreferences, key ->
            if (key == "LunchMenu") {
                showLunchMenuLiveData.value = sharedPreferences.getBoolean(key, false)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showLunchMenuLiveData.value = sharedPreferences.getBoolean("LunchMenu", false)
        sharedPreferences.registerOnSharedPreferenceChangeListener(sharedPreferencesListener)

        setContent {
            SharedPreferencesExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        val selected = showLunchMenuLiveData.observeAsState(false)

                        Greeting2("Save user response on breakfast and launch menu")
                        Switch(checked = selected.value, onCheckedChange = {
                            sharedPreferences.edit().putBoolean("LunchMenu", it).apply()
                        })
                        Title(showLunchMenu = selected.value)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = name)
}

@Composable
fun Title(showLunchMenu: Boolean) {
    val text = if (showLunchMenu) {
        "Lunch Menu"
    } else {
        "Breakfast Menu"
    }

    Text(text = text)
}

