package com.littlelemon.littlelemoningredients

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.main_dish_1).setOnClickListener {

            //IngredientsActivity.start(this, "Hamburger")

            //Alternative way
            this.startActivity(
                Intent(this, IngredientsActivity::class.java).putExtra(
                    "DishName",
                    "Hamburger"
                )
            )
        }
        findViewById<View>(R.id.main_dish_2).setOnClickListener {
            IngredientsActivity.start(this, "Pasta")
        }

        //Implementation of Button click listeners using lambda expression
        val saveDataButton = findViewById<Button>(R.id.saveDataButton)

//        saveDataButton.setOnClickListener(View.OnClickListener { view ->
//            println(view.id)
//            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
//        })
//
//        saveDataButton.setOnClickListener { view ->
//            println(view.id)
//            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
//        }

        saveDataButton.setOnClickListener {
            println(it.id)
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
        }
    }
}