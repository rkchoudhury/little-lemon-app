package com.littlelemon.littlelemon.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MenuItemRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuItemDao(): MenuItemDao
}

class AppDatabaseInstance(context: Context) {
    private val databaseInstance = getDatabase(context)

    fun getMenuItems() = databaseInstance.menuItemDao().getAllMenuItems()

    fun insertAllMenuItems(menuItems: List<MenuItemRoom>) =
        databaseInstance.menuItemDao().insertAll(menuItems)

    fun isEmptyMenuItems() = databaseInstance.menuItemDao().isEmpty()

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "little_lemon.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}