package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    /*
    * Implementation of scrollable grid using Column and Row
    */
    // ScrollableGalleryScreen()

    /*
    * Implementation of Nested scrolling
    */
    // ScrollableColumn()

    /*
    * Implementation of LazyRow and LazyColumn
    */
    // MenuListScreen()

    /*
    * Implementation of state in LazyRow and LazyColumn
    * Remembering the scroll position over orientation changes
    */
    // LazyColumnRememberedState()

    /*
    * Implementation of LazyGrid with Fixed and Adaptive mode
    */
    LazyGrid()
}

