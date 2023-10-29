package com.littlelemon.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign.Companion.Right
import androidx.compose.ui.unit.dp
import com.littlelemon.room.ui.theme.RoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val menuItems by remember {
                        mutableStateOf(emptyList<MenuItem>())
                    }
                    Column {
                        var dishName by remember { mutableStateOf("") }
                        var priceInput by remember { mutableStateOf("") }
                        Row(modifier = Modifier.padding(16.dp)) {
                            TextField(
                                modifier = Modifier.weight(.6f),
                                value = dishName,
                                onValueChange = { value -> dishName = value },
                                label = { Text("Dish name") }
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            TextField(
                                modifier = Modifier.weight(.4f),
                                value = priceInput,
                                onValueChange = { value -> priceInput = value },
                                label = { Text("Price") }
                            )
                        }
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            onClick = {
                                dishName = ""
                                priceInput = ""
                            }
                        ) {
                            Text("Add dish")
                        }
                        ItemsList(menuItems)
                    }
                }
            }
        }
    }

    @Composable
    private fun ItemsList(menuItems: List<MenuItem>) {
        if (menuItems.isEmpty()) {
            Text(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp),
                text = "The menu is empty"
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                items(
                    items = menuItems,
                    itemContent = { menuItem ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(menuItem.name)
                            Text(
                                modifier = Modifier.weight(1f),
                                textAlign = Right,
                                text = "%.2f".format(menuItem.price)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Button(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.delete_icon),
                                    contentDescription = "Delete"
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}
