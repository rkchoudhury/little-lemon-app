package com.example.littlelemon

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyCard(number: Int) {
    Card(
        elevation = 16.dp,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = number.toString(),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ScrollableColumn() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        ScrollableRow()
        repeat(20) {
            MyCard(number = it)
        }
    }
}

@Composable
fun ScrollableRow() {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        repeat(20) {
            MyCard(number = it)
        }
    }
}