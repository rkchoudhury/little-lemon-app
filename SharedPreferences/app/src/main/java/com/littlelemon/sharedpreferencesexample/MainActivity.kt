package com.littlelemon.sharedpreferencesexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.littlelemon.sharedpreferencesexample.ui.theme.SharedPreferencesExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharedPreferencesExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        val sharedPreferences = getSharedPreferences("LittleLemon", MODE_PRIVATE)
        val lastCount = sharedPreferences.getInt("StartCount", 0)
        val newCount = lastCount + 1

        Log.d("StartCount", "New Count: $newCount")
        sharedPreferences.edit().putInt("StartCount", newCount).apply()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    SharedPreferencesExampleTheme {
        Greeting("Android")
    }
}