package com.littlelemon.littlelemon.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItem(title: String, details: String, price: Double, imageUrl: String) {
    Column(
        modifier = Modifier
            .padding(20.dp, 10.dp)
            .wrapContentHeight()
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = LittleLemonColor.charcoal,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(
                    text = details,
                    fontSize = 14.sp,
                    color = LittleLemonColor.charcoal,
                    fontFamily = FontFamily.Serif,
                )
                Text(
                    text = "$${price}",
                    fontSize = 14.sp,
                    color = LittleLemonColor.charcoal,
                    fontFamily = FontFamily.Serif
                )
            }
            GlideImage(
                model = imageUrl,
                contentDescription = "Loading Image",
                modifier = Modifier
                    .size(80.dp),
                contentScale = ContentScale.Crop
            )
        }
        Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewMenuItem() {
    MenuItem("title", "This is a new dish", 50.0, "")
}