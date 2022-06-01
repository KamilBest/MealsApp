package com.best.mealsapp.data.api

import com.best.mealsapp.data.api.response.MealCategoryResponse
import com.best.mealsapp.data.api.response.MealsCategoriesResponse

class MealsCategoryRepository {
    fun getMealsCategories(): MealsCategoriesResponse = MealsCategoriesResponse(arrayListOf(
        MealCategoryResponse("1", "IceCream", "Yummy", "fakeUrl")
    ))
}
