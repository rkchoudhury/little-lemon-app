package com.littlelemon.roommenuapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class, MenuItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun menuDao(): MenuDao

}

class AppDB(context: Context) {
    private val database = getDatabase(context)

    fun getAllUsers() = database.userDao().getAll()

    fun insertNewUser(user: User) = database.userDao().insert(user)

    fun getMenuItems() = database.menuDao().getAllMenuItems()

    fun saveMenuItem(item: MenuItem) = database.menuDao().saveMenuItem(item)

    fun deleteMenuItem(item: MenuItem) = database.menuDao().deleteMenuItem(item)

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
                    context.applicationContext, AppDatabase::class.java, "app_database.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}