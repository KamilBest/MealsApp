package com.best.mealsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.best.mealsapp.presentation.screen.mealcategorieslist.MealCategoriesScreen
import com.best.mealsapp.presentation.theme.MealsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealsAppTheme {
                MealCategoriesScreen()
            }
        }
    }
}