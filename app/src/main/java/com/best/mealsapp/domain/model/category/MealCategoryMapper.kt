package com.best.mealsapp.domain.model.category

import com.best.mealsapp.data.api.meals.categories.response.MealCategoryResponse
import com.best.mealsapp.data.api.meals.categories.response.MealsCategoriesResponse

fun MealsCategoriesResponse.toDomain(): List<MealCategory> =
    categories.map { MealCategory(it.id, it.name, it.description, it.imageUrl) }

fun MealCategoryResponse.toDomain() = MealCategory(id, name, description, imageUrl)
