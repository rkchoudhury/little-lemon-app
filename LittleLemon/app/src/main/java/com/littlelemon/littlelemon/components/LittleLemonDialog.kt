package com.littlelemon.littlelemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.littlelemon.littlelemon.R
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor

@Composable
fun LittleLemonDialog(
    visibleDialog: Boolean,
    message: String,
    buttonLabel: String = stringResource(id = R.string.okay),
    onPressButton: () -> Unit = {}
) {
    if (visibleDialog) {
        Dialog(onDismissRequest = {}) {
            Column(
                modifier = Modifier
                    .background(LittleLemonColor.white)
                    .padding(20.dp, 20.dp)
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = message,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 30.dp)
                )
                Button(onClick = {
                    onPressButton()
                }) {
                    Text(text = buttonLabel.uppercase())
                }
            }
        }
    }

}

@Composable
@Preview(showSystemUi = true)
fun PreviewLittleLemonDialog() {
    LittleLemonDialog(true, "Success", "Okay")
}