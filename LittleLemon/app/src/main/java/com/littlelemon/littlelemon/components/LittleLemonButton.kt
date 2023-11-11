package com.littlelemon.littlelemon.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor
import com.littlelemon.littlelemon.ui.theme.Shapes

@Composable
fun LittleLemonButton(label: String, onPress: () -> Unit = {}, isEnabled: Boolean = true) {
    Button(
        onClick = { onPress() },
        shape = Shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp, 10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = LittleLemonColor.yellow),
        enabled = isEnabled,
    ) {
        Text(
            text = label.uppercase(),
            modifier = Modifier.padding(0.dp, 10.dp),
            color = LittleLemonColor.charcoal
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewLittleLemonButton() {
    LittleLemonButton("Text")
}