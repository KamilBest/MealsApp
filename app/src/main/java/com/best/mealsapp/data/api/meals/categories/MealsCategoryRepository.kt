package com.best.mealsapp.data.api.meals.categories

import com.best.mealsapp.data.api.meals.categories.response.MealsCategoriesResponse

class MealsCategoryRepository(private val mealsCategoryService: MealsCategoryService = MealsCategoryService()) {
    suspend fun getMealsCategories(): MealsCategoriesResponse {
        return mealsCategoryService.getMealsCategories()
    }
}
