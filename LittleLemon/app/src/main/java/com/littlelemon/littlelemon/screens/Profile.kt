package com.littlelemon.littlelemon.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.littlelemon.littlelemon.R
import com.littlelemon.littlelemon.components.LittleLemonButton

@Composable
fun Profile() {
    Column {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(0.dp, 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                LabelRow(
                    label = stringResource(id = R.string.full_name),
                    value = "Rakesh Choudhury"
                )
                LabelRow(
                    label = stringResource(id = R.string.email),
                    value = "rkChoudhury@gmail.com"
                )
            }
            LittleLemonButton(label = stringResource(id = R.string.logout))
        }

    }
}

@Composable
fun LabelRow(label: String, value: String) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp, 25.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = label,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Text(
                text = value, fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
        Divider()
    }

}

@Composable
@Preview(showSystemUi = true)
fun PreviewProfile() {
    Profile()
}