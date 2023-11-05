package com.littlelemon.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Onboarding() {
    Column() {
        Image(
            painter = painterResource(R.drawable.little_lemon_logo),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier.padding(100.dp, 20.dp),
        )
        Text(
            text = stringResource(id = R.string.on_boarding_know_you),
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    LittleLemonColor.green
                )
                .padding(100.dp, 40.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = LittleLemonColor.white
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOnboarding() {
    Onboarding()
}