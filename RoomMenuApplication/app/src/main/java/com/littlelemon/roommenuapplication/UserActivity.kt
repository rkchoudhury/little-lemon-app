package com.littlelemon.roommenuapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.littlelemon.roommenuapplication.ui.theme.RoomMenuApplicationTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class UserActivity : ComponentActivity() {
    // Get the database instance
    private val database by lazy {
        AppDB(applicationContext) // or pass only 'this'
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomMenuApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Get a list of users from the database as Compose state
                    val users by database.getAllUsers().observeAsState(emptyList())

                    Greeting("Android, \n\nThe total number of user added is ${users.size}")
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
                                    database.insertNewUser(newUser)
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