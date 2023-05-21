package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    //NavController must be created at the top of the composable hierarchy
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home.route) {
        composable(Home.route) {
            HomeScreen(navController)
        }
        composable(MenuList.route + "/{${MenuList.argOrderNo}}",
            arguments = listOf(
                navArgument(MenuList.argOrderNo) { type = NavType.IntType }
            )) {
            MenuListScreen(it.arguments?.getInt(MenuList.argOrderNo))
//            Text(text = "rkkkkk") //This will be also visible in the screen/UI
        }

//        composable(MenuList.route + "/{${MenuList.argOrderNo}}",
//            arguments = listOf(
//                navArgument(MenuList.argOrderNo) { type = NavType.IntType }
//            )) { backStackEntry ->
//            MenuListScreen(backStackEntry.arguments?.getInt(MenuList.argOrderNo))
//        }
    }
}