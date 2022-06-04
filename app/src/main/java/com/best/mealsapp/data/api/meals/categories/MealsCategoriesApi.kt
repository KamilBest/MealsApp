package com.best.mealsapp.data.api.meals.categories

import com.best.mealsapp.data.api.meals.categories.response.MealsCategoriesResponse
import retrofit2.http.GET


interface MealsCategoriesApi {
    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse
}
