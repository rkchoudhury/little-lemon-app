package com.littlelemon.littlelemoningredients

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IngredientsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        val dishName = intent.getStringExtra(EXTRA_DISH_NAME_KEY)
        findViewById<TextView>(R.id.ingredients_list).text = getDishIngredients(dishName)
    }

    private fun getDishIngredients(dishName: String?): String {
        val ingredients = when (dishName) {
            "Hamburger" -> "Minced meat\nBun\nTomato"
            "Pasta" -> "Spaghetti\nTomato\nParmesan"
            else -> "Unknown dish"
        }
        return ingredients
    }

    companion object {
        private const val EXTRA_DISH_NAME_KEY = "DishName"

        fun start(context: Context, dishName: String) {
            val intent = Intent(context, IngredientsActivity::class.java)
            intent.putExtra(EXTRA_DISH_NAME_KEY, dishName)

            //Alternative way to adding the value
//            val intent = Intent(context, IngredientsActivity::class.java).apply {
//                putExtra(EXTRA_DISH_NAME_KEY, dishName)
//            }
            
            //Alternative way to adding the value
//            val intent = Intent(context, IngredientsActivity::class.java).putExtra(
//                EXTRA_DISH_NAME_KEY,
//                dishName
//            )

            context.startActivity(intent)
        }
    }
}