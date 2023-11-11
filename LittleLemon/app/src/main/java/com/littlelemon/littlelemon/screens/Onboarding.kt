package com.littlelemon.littlelemon.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.littlelemon.littlelemon.R
import com.littlelemon.littlelemon.components.LittleLemonButton
import com.littlelemon.littlelemon.components.LittleLemonTextInput
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun Onboarding() {
    LittleLemonTheme {
        Column {
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
            Text(
                text = stringResource(id = R.string.personal_information),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 30.dp),
                fontSize = 16.sp,
                color = LittleLemonColor.charcoal,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            LittleLemonTextInput(stringResource(id = R.string.first_name))
            LittleLemonTextInput(stringResource(id = R.string.last_name))
            LittleLemonTextInput(stringResource(id = R.string.email))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(0.dp, 0.dp, 0.dp, 30.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                LittleLemonButton(label = stringResource(id = R.string.register))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOnboarding() {
    Onboarding()
}