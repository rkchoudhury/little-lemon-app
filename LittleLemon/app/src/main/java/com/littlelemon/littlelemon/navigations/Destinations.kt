package com.littlelemon.littlelemon.navigations

interface Destinations {
    val route: String
}

object OnBoarding: Destinations {
    override val route: String = "OnBoarding"

}

object Profile: Destinations {
    override val route: String = "Profile"

}