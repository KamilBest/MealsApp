package com.best.mealsapp.presentation.screen.meal

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.best.mealsapp.data.api.meals.categories.MealsCategoryRepository
import com.best.mealsapp.domain.model.category.MealCategory
import com.best.mealsapp.domain.model.category.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsCategoryRepository = MealsCategoryRepository()) :
    ViewModel() {

    val mealsCategoriesState: MutableState<List<MealCategory>> = mutableStateOf(emptyList())

    init {
        launchGetMealsCategoriesCoroutine()
    }

    private fun launchGetMealsCategoriesCoroutine() {
        viewModelScope.launch(Dispatchers.IO) {
            val mealCategories = getMealsCategories()
            mealsCategoriesState.value = mealCategories
        }
    }

    private suspend fun getMealsCategories(): List<MealCategory> {
        return repository.getMealsCategories().toDomain()
    }
}