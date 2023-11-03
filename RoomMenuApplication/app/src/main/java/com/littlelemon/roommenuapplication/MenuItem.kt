package com.littlelemon.roommenuapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "menu_table")
data class MenuItem(
    @PrimaryKey val id: String,
    val name: String,
    val price: Double
)

@Dao
interface MenuDao {
    @Query("SELECT * FROM menu_table")
    fun getAllMenuItems(): LiveData<List<MenuItem>>

    @Insert
    fun saveMenuItem(item: MenuItem)

    @Delete
    fun deleteMenuItem(item: MenuItem)
}