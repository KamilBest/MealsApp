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
    val rememberedMealsCategories: MutableState<List<MealCategory>> =
        remember { mutableStateOf(emptyList()) }
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = "GET_MEALS") {
        coroutineScope.launch(Dispatchers.IO) {
            val mealCategories = viewModel.getMealsCategories()
            rememberedMealsCategories.value = mealCategories
        }
    }
    // Text(text = "Meal categories: ${rememberedMealsCategories.value.joinToString()}")
    LazyColumn {
        items(rememberedMealsCategories.value) { mealCategory ->
            Text(text = mealCategory.toString())
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