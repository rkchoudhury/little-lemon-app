package com.example.littlelemonlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Order("Android")

                    //State management
//                    Column() {
//                        CityInput()
//                        CountryTextInput()
//                        StateInput()
//                    }

                    //Orientation Changes
//                    MenuContentView()
                }
            }
        }
    }
}

@Composable
fun Order(name: String) {
    Column(
        modifier = Modifier.fillMaxWidth()

//            .background(Color(0xFF49D548))
    ) {
        Text(
            text = stringResource(id = R.string.little_lemon),
            fontSize = 32.sp,
            color = Color(0xFFF4CE14)
        )
        Text(
            text = stringResource(id = R.string.chicago),
            fontSize = 24.sp
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()

        ) {
            Column(
//                verticalArrangement = Arrangement.SpaceBetween,
//                horizontalAlignment = Alignment.Start,
//                modifier = Modifier.fillMaxHeight()

            ) {
                Text(text = "Some messages", fontSize = 18.sp)
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Order")
                }

            }
            Image(
                painter = painterResource(id = R.drawable.littlelemonlogo),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOrder() {
    LittleLemonLoginTheme {
        Order("Android")
    }
}