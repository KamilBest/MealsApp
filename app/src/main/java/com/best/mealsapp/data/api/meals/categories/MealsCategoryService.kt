package com.best.mealsapp.data.api.meals.categories

import com.best.mealsapp.data.api.RetrofitApiClient
import com.best.mealsapp.data.api.meals.categories.response.MealsCategoriesResponse

class MealsCategoryService {
    private var api: MealsCategoriesApi =
        RetrofitApiClient.getInstance().create(MealsCategoriesApi::class.java)

    suspend fun getMealsCategories(): MealsCategoriesResponse {
        return api.getMeals()
    }
}