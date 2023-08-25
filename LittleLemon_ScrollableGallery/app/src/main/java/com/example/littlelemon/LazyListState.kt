package com.example.littlelemon

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyColumnRememberedState() {
    LazyColumn(state = rememberLazyListState()) {
        item { LazyRowRememberedState() }
        items(1000) {
            MyCardView(number = it)
        }
    }
}

@Composable
fun LazyRowRememberedState() {
    LazyRow(state = rememberLazyListState()) {
        items(1000) {
            MyCardView(number = it)
        }
    }
}

@Composable
fun MyCardView(number: Int) {
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
@Preview(showSystemUi = true)
fun PreviewLazyColumn() {
    LazyColumnRememberedState()
}