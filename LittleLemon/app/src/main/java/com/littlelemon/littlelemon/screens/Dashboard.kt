package com.littlelemon.littlelemon.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Dashboard() {
    Column() {
        Text(text = "Dashboard")
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewDashboard() {
    Dashboard()
}