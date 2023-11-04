package com.littlelemon.littlelemondashboard

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    val id: Int,
    val title: String,
    val price: String
)

@Serializable
data class MenuNetwork(
   val menu: List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    val id: Int,
    val title: String,
    val price: String
) {
    fun toMenuItemRoom() = MenuItemRoom(
        id = id,
        title = title,
        price = price.toDouble()
    )
}
