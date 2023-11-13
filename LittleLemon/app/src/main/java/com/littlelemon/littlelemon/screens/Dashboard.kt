package com.littlelemon.littlelemon.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.littlelemon.R
import com.littlelemon.littlelemon.navigations.Profile

@Composable
fun Dashboard(navController: NavHostController) {
    Column {
        HeaderView(navController)

    }
}

@Composable
fun HeaderView(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.little_lemon_logo),
            contentDescription = "little_lemon_logo",
            modifier = Modifier
                .weight(1f)
                .size(40.dp),
            alignment = Alignment.Center
        )
        Image(
            painter = painterResource(id = R.drawable.profile_icon),
            contentDescription = "profile_icon",
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    navController.navigate(Profile.route)
                }
            
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewDashboard() {
    Dashboard(rememberNavController())
}