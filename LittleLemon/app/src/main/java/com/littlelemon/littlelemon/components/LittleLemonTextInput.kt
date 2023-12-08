package com.littlelemon.littlelemon.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LittleLemonTextInput(label: String, onChangeText: (String) -> Unit = {}, maxLength: Int = 50) {
    var text by remember {
        mutableStateOf("")
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 12.dp)
    ) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    text = it
                    onChangeText(it)
                }
            },
            singleLine = true,
            label = {
                Text(text = label)
            },
            modifier = Modifier
                .width(TextFieldDefaults.MinWidth)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOnboarding() {
    LittleLemonTextInput("Name", {})
}