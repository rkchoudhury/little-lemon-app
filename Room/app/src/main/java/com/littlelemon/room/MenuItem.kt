package com.littlelemon.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

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

@Database(entities = [MenuItem::class], version = 1, exportSchema = false)
abstract class MenuDatabase : RoomDatabase() {
    abstract fun menuDao(): MenuDao
}