package com.example.littlelemonlogin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme

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
                    LoginScreen()
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
                contentDescription = "Logo Image",
                modifier = Modifier.padding(10.dp)
            )
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "Username") },
                modifier = Modifier.padding(10.dp)
            )
            TextField(
                value = password,
                onValueChange = { setPassword(it) },
                label = { Text(text = "Password") },
                modifier = Modifier.padding(10.dp)
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF495E57)
                ),
                modifier = Modifier.padding(10.dp)
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
}
