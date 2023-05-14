package com.example.littlelemonlogin

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.material.TopAppBar
import com.example.littlelemonlogin.ui.theme.Purple500
import com.example.littlelemonlogin.ui.theme.Purple700
import com.example.littlelemonlogin.ui.theme.Teal200
import com.example.littlelemonlogin.ui.theme.Purple200

@Composable
fun MenuContentView() {
    val materialBlue700 = Color(0xFF1976D2)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Orientation changes") },
                contentColor = Color.White,
                backgroundColor = materialBlue700
            )
        },
        content = {
            MenuContent()
        }
    )
}

@Composable
fun MenuContent() {
    Surface {
        val menuPadding = 8.dp
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                Column {
                    Row(modifier = Modifier.weight(1f)) {
                        Text(
                            "A",
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(Purple700)
                                .padding(menuPadding)
                        )
                        Text(
                            "B",
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .padding(menuPadding)
                        )
                    }
                    Row(modifier = Modifier.weight(1f)) {
                        Text(
                            "C",
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(Purple500)
                                .padding(menuPadding)
                        )
                        Text(
                            "D",
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .background(Teal200)
                                .padding(menuPadding)
                        )
                    }
                }
            }
            else -> {
                Column {
                    Text(
                        "A",
                        modifier = Modifier
                            .weight(1f)
                            .background(Purple700)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "B",
                        modifier = Modifier
                            .weight(1f)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "C",
                        modifier = Modifier
                            .weight(1f)
                            .background(Purple500)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "D",
                        modifier = Modifier
                            .weight(1f)
                            .background(Teal200)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
//                    Text(
//                        "E",
//                        modifier = Modifier
//                            .weight(2f)
//                            .background(Purple200)
//                            .padding(menuPadding)
//                            .fillMaxWidth()
//                    )
                }
            }
        }
    }
}