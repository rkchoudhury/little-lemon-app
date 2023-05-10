package com.example.littlelemonlogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.littlelemonlogo),
                contentDescription = "menu icon",
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
            )
        }
        Text(
            text = "Dashboard",
            modifier = Modifier.fillMaxWidth(0.5F),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.littlelemonlogo),
                contentDescription = "cart icon",
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewTopAppBar() {
    TopAppBar()
}