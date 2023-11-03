package com.littlelemon.roommenuapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class User(
    @PrimaryKey
    val id: String,
    val name: String
)

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM User")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM User WHERE name = :name1")
    fun getAllUsersWithName(name1: String): Array<User>
}