package com.littlelemon.littlelemon.navigations

interface Destinations {
    val route: String
}

object OnBoardingDestination: Destinations {
    override val route: String = "OnBoarding"

}

object ProfileDestination: Destinations {
    override val route: String = "Profile"

}