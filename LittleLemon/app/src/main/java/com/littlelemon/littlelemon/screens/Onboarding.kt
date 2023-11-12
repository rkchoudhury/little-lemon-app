package com.littlelemon.littlelemon.screens

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.littlelemon.R
import com.littlelemon.littlelemon.components.LittleLemonButton
import com.littlelemon.littlelemon.components.LittleLemonDialog
import com.littlelemon.littlelemon.components.LittleLemonTextInput
import com.littlelemon.littlelemon.navigations.Profile
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun Onboarding(navController: NavHostController, applicationContext: Context) {
    val sharedPreferences by lazy {
        applicationContext.getSharedPreferences("LittleLemon", MODE_PRIVATE)
    }

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    val isButtonDisabled: Boolean = firstName.isBlank() || lastName.isBlank() || email.isBlank()

    var showDialog by remember {
        mutableStateOf(false)
    }

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
            LittleLemonTextInput(
                label = stringResource(id = R.string.first_name),
                onChangeText = { firstName = it })
            LittleLemonTextInput(
                label = stringResource(id = R.string.last_name),
                onChangeText = { lastName = it })
            LittleLemonTextInput(
                label = stringResource(id = R.string.email),
                onChangeText = { email = it })
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(0.dp, 0.dp, 0.dp, 30.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                LittleLemonButton(
                    label = stringResource(id = R.string.register), isEnabled = !isButtonDisabled,
                    onPress = {
                        showDialog = true
//                        sharedPreferences.edit().putString("first_name", firstName)
//                            .putString("last_name", lastName).putString("email", email).apply()

                        sharedPreferences.edit(commit = true) {
                            putString("first_name", firstName)
                            putString("last_name", lastName)
                            putString("email", email)
                        }
                    },
                )
            }
            LittleLemonDialog(
                visibleDialog = showDialog,
                message = stringResource(id = R.string.registration_successful),
                onPressButton = {
                    showDialog = false
                    navController.navigate(Profile.route)
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOnboarding() {
    Onboarding(rememberNavController(), LocalContext.current)
}