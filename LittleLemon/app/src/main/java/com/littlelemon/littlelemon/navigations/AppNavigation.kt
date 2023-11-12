package com.littlelemon.littlelemon.navigations

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.littlelemon.littlelemon.screens.Dashboard
import com.littlelemon.littlelemon.screens.Onboarding
import com.littlelemon.littlelemon.screens.Profile

@Composable
fun AppNavigation(context: Context) {
    val navController: NavHostController = rememberNavController()
    val startDestination: String =  OnBoarding.route

    NavHost(navController = navController, startDestination) {
        composable(OnBoarding.route) {
            Onboarding(navController, context)
        }

        composable(Dashboard.route) {
            Dashboard()
        }

        composable(Profile.route) {
            Profile(navController, context)
        }
    }
}