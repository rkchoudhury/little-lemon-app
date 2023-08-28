package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyGrid() {
    /*
    * When the device is in portrait orientation, items are displayed in each column.
    * On rotating the device, the number of items remains the same, but the size of the items has increased.
    * This is because you used the fixed count for the Grid Cells.
    */

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(1000) { MyGridCell() }
    }

    /*
    * The number of columns is two in portrait orientation, but this time the number of items will change, maintaining the minimum size of items the same.
    * Note: The number of items in adaptive grid cells will change with different screen sizes as well
    */

//    LazyVerticalGrid(columns = GridCells.Adaptive(140.dp)) {
//        items(1000) { MyGridCell() }
//    }

    /* Horizontal Grid */
//    LazyHorizontalGrid(rows = GridCells.Fixed(2)) {
//        items(1000) { MyGridCell() }
//    }

//    LazyHorizontalGrid(rows = GridCells.Adaptive(200.dp)) {
//        items(1000) { MyGridCell() }
//    }
}

@Composable
fun MyGridCell() {
    Card(
        elevation = 16.dp, modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.greeksalad),
                contentDescription = "Greek Salad",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Greek Salad",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .align(Alignment.TopStart)

            )
            Text(
                text = "$12.99",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color.White)
                    .padding(start = 4.dp, end = 4.dp)
                    .align(Alignment.BottomEnd)

            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewMyGridCell() {
    MyGridCell()
}

@Composable
@Preview(showSystemUi = true)
fun PreviewLazyGrid() {
    LazyGrid()
}