package com.example.littlelemonlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Column {
        UpperPanel()
        LowerPanel()
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    Column {
        UpperPanel()
        LowerPanel()
    }
}