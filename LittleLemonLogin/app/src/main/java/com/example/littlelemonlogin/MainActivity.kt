package com.example.littlelemonlogin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
        val context: Context = LocalContext.current
        var name by rememberSaveable { mutableStateOf("") }
        val (password, setPassword) = remember { mutableStateOf("") }

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
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.padding(10.dp)
            )
            Button(
                onClick = { handleLogin(context, name, password) },
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

    private fun handleLogin(context: Context, userName: String, password: String) {
        Log.d("RKKK", "handleLogin: userName $userName ${userName == "raka"}")
        Log.d("RKKK", "handleLogin: password $password ${password == "1234"}")
        if (userName == "raka" && password == "1234") {
            Toast.makeText(context, "Welcome to Little Lemon!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Invalid credentials. Please try again.", Toast.LENGTH_LONG)
                .show()
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun PreviewLoginScreen() {
        LoginScreen()
    }
}
