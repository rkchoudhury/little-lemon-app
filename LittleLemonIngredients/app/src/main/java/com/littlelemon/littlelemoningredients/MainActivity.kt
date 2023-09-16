package com.littlelemon.littlelemoningredients

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.main_dish_1).setOnClickListener {
            // Your solution here.
        }
        findViewById<View>(R.id.main_dish_2).setOnClickListener {
            // Your solution here.
        }
    }
}