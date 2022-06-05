package com.best.mealsapp.presentation.screen.meal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.best.mealsapp.domain.model.category.MealCategory
import com.best.mealsapp.presentation.theme.MealsAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

@Composable
fun MealCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val mealsCategories = viewModel.mealsCategoriesState.value
    // Text(text = "Meal categories: ${rememberedMealsCategories.value.joinToString()}")
    LazyColumn {
        items(mealsCategories) { mealCategory ->
            Text(text = mealCategory.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsAppTheme {
        MealCategoriesScreen()
    }
}