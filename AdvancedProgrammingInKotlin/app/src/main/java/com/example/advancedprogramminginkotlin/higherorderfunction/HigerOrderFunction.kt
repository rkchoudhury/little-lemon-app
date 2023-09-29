package com.example.advancedprogramminginkotlin.higherorderfunction

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun HigherOrderFunctionExample(context: Context) {
    Column {
        Text(text = "\nHigher Order Function Example\n")

        Button1 {
            Toast.makeText(context, "Button 1 pressed", Toast.LENGTH_LONG)
                .show()
        }

        Button2(onClickBtn2 = { count ->
            Toast.makeText(
                context,
                "Button 2 is pressed $count times",
                Toast.LENGTH_LONG
            )
                .show()
        })
    }
}

@Composable
fun Button1(onClickBtn1: () -> Unit) {
    Button(onClick = onClickBtn1) {
        Text(text = "Button 1")
    }
}

@Composable
fun Button2(onClickBtn2: (Int) -> Unit) {
    var count: Int = 0
    Button(onClick = { onClickBtn2(++count) }) {
        Text(text = "Button 2")
    }
}