package com.littlelemon.littlelemon.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.littlelemon.littlelemon.screens.Onboarding
import com.littlelemon.littlelemon.screens.Profile

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = OnBoardingDestination.route) {
        composable(OnBoardingDestination.route) {
            Onboarding()
        }

        composable(ProfileDestination.route) {
            Profile()
        }
    }
}