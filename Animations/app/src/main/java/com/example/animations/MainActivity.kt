package com.example.animations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animations.ui.theme.AnimationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Text(
                            text = "Fade In/Out Animations",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 20.dp),
                            fontWeight = FontWeight(500)
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            GreetingWithoutAnimations()
                            GreetingDefaultAnimations()
                            GreetingWithFadeAnimations()
                            GreetingWithFadeAnimationsTime()
                        }
                        Divider(
                            color = Color.Black,
                            thickness = 2.dp,
                            modifier = Modifier.padding(0.dp, 20.dp)
                        )
                        Text(
                            text = "Valued Animation \n\n Click on the image to see the animation",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 20.dp),
                            fontWeight = FontWeight(500)
                        )
                        ValuedImageAnimations()
                    }

                }
            }
        }
    }
}

@Composable
fun GreetingWithoutAnimations() {
    var visible by remember {
        mutableStateOf(true)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(onClick = { visible = !visible }) {
            Text("Button")
        }
        if (visible) {
            Text(text = "Hello, world!")
        }
    }
}

@Composable
fun GreetingDefaultAnimations() {
    var visible by remember {
        mutableStateOf(true)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { visible = !visible }) {
            Text("Button")
        }
        AnimatedVisibility(visible = visible) {
            Text(text = "Hello, world!")
        }
    }
}

@Composable
fun GreetingWithFadeAnimations() {
    var visible by remember {
        mutableStateOf(true)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { visible = !visible }) {
            Text("Button")
        }
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text(text = "Hello, world!")
        }
    }
}

@Composable
fun GreetingWithFadeAnimationsTime() {
    var visible by remember {
        mutableStateOf(true)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { visible = !visible }) {
            Text("Button")
        }
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(2000)),
            exit = fadeOut(animationSpec = tween(2000))
        ) {
            Text(text = "Hello, world!")
        }
    }
}

@Composable
fun ValuedImageAnimations() {
    var alphaImage by remember {
        mutableStateOf(0f)
    }

    val animatedAlphaImage by animateFloatAsState(
        targetValue = alphaImage,
        animationSpec = tween(durationMillis = 4000)
    )

    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable { alphaImage = if (alphaImage == 0f) 1f else 0f }) {
        Image(
            painter = painterResource(id = R.drawable.littlelemontxt),
            contentDescription = "",
            modifier = Modifier.align(Alignment.Center)
        )
        Image(
            painter = painterResource(id = R.drawable.littlelemonimg),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .alpha(alpha = animatedAlphaImage)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimationsTheme {
        GreetingWithoutAnimations()
    }
}