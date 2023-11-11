package com.littlelemon.littlelemon.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.littlelemon.littlelemon.screens.Onboarding
import com.littlelemon.littlelemon.screens.Profile

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    val startDestination: String =  OnBoarding.route

    NavHost(navController = navController, startDestination) {
        composable(OnBoarding.route) {
            Onboarding(navController)
        }

        composable(Profile.route) {
            Profile()
        }
    }
}