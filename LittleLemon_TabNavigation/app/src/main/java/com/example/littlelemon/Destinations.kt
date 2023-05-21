package com.example.littlelemon

interface Destinations {
    val route: String
    val title: String
    val icon: Int
}

object Home : Destinations {
    override val route: String = "Home"
    override val title: String = "Home"
    override val icon: Int = R.drawable.ic_home
}

object Menu : Destinations {
    override val route: String = "Menu"
    override val title: String = "Menu"
    override val icon: Int = R.drawable.ic_menu
}

object Location : Destinations {
    override val route: String = "Location"
    override val title: String = "Location"
    override val icon: Int = R.drawable.ic_location
}