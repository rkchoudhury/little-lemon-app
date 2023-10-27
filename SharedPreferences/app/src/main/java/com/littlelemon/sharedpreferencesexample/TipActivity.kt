package com.littlelemon.sharedpreferencesexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import com.littlelemon.sharedpreferencesexample.ui.theme.SharedPreferencesExampleTheme

class TipActivity : ComponentActivity() {

    private val sharedPreferences by lazy {
        getSharedPreferences("LittleLemon", MODE_PRIVATE)
    }

    private val tipMenuLiveData = MutableLiveData<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tipMenuLiveData.value = sharedPreferences.getBoolean("Tip", false)

        setContent {
            SharedPreferencesExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Add Tip?")

                        val selected = tipMenuLiveData.observeAsState(false)
                        Switch(checked = selected.value, onCheckedChange = {
//                            sharedPreferences.edit().putBoolean("Tip", it).apply()
                            sharedPreferences.edit(commit = true) { putBoolean("Tip", it) } //alternative way
                            runOnUiThread { tipMenuLiveData.value = it } //Update in the live value in switch UI
                        })
                    }
                }
            }
        }
    }
}