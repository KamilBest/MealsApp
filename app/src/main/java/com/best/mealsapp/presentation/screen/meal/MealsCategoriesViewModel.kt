package com.best.mealsapp.presentation.screen.meal

import androidx.lifecycle.ViewModel
import com.best.mealsapp.data.api.MealsCategoryRepository
import com.best.mealsapp.domain.model.category.MealCategory
import com.best.mealsapp.domain.model.category.toDomain

class MealsCategoriesViewModel(private val repository: MealsCategoryRepository = MealsCategoryRepository()) :
    ViewModel() {
    fun getMealsCategories(): List<MealCategory> {
        return repository.getMealsCategories().toDomain()
    }
}