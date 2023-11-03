package com.littlelemon.room

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.room.*
import com.littlelemon.room.ui.theme.RoomTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*


class BasicActivity : ComponentActivity() {
    // Get the database instance
    private val database by lazy {
        AppDatabase.getDatabase(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Get a list of users from the database as Compose state
                    val users by database.userDao().getAll().observeAsState(emptyList())

                    Greeting("Android, \nThe total number of user added is ${users.size}")
                    Button(
                        modifier = Modifier
                            .padding(100.dp),
                        onClick = {
                            val newUser = User(
                                id = UUID.randomUUID().toString(),
                                name = "Rakesh",
                            )

                            lifecycleScope.launch {
                                withContext(Dispatchers.IO) {
                                    database.userDao().insert(newUser)
                                }
                            }
                        }
                    ) {
                        Text("Add user")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey
    var id: String,
    var name: String
)

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM user_table")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE name = :name")
    fun getAllUsersWithName(name: String): Array<User>
}

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

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

// Database migration code - not tested

//@Database(
//    version = 2,
//    entities = [User::class],
//    autoMigrations = [
//        AutoMigration (from = 1, to = 2)
//    ]
//)
