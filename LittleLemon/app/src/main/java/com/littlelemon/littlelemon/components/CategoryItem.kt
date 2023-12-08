package com.littlelemon.littlelemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor

@Composable
fun CategoryItem(label: String, isSelectedItem: Boolean, onPress: () -> Unit) {
    val selectedColor = if (isSelectedItem) {
        LittleLemonColor.pink
    } else {
        LittleLemonColor.cloud
    }

    Box(
        modifier = Modifier
            .padding(0.dp, 0.dp, 15.dp, 0.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable { onPress() }
    ) {
        Text(
            text = label.substring(0, 1).uppercase() + label.substring(1).lowercase(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = LittleLemonColor.green,
            modifier = Modifier
                .background(selectedColor)
                .padding(10.dp)
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewCategoryItem() {
    CategoryItem("Mains", true) {}
}