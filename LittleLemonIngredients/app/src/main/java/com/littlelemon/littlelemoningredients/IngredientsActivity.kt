package com.littlelemon.littlelemoningredients

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IngredientsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        findViewById<TextView>(R.id.ingredients_list).text =
            "<Your solution here>"
    }
}