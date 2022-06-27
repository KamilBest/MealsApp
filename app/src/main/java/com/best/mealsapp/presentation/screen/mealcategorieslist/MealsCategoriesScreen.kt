package com.best.mealsapp.presentation.screen.mealcategorieslist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.best.mealsapp.domain.model.category.MealCategory
import com.best.mealsapp.presentation.screen.mealcategorieslist.viewmodel.MealsCategoriesViewModel
import com.best.mealsapp.presentation.theme.LocalSpacing
import com.best.mealsapp.presentation.theme.MealsAppTheme

@Composable
fun MealCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val mealsCategories = viewModel.mealsCategoriesState.value
    LazyColumn(contentPadding = PaddingValues(LocalSpacing.current.gridNormal100)) {
        items(mealsCategories) { mealCategory ->
            MealCategory(mealCategory)
        }
    }
}

@Composable
fun MealCategory(mealCategory: MealCategory) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = LocalSpacing.current.gridNormal100)
    ) {
        Row {
            AsyncImage(
                model = mealCategory.imageUrl,
                contentDescription = mealCategory.name,
                modifier = Modifier
                    .size(88.dp)
                    .padding(LocalSpacing.current.gridSmall100)
            )
            Column(modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterVertically)
                .padding(LocalSpacing.current.gridNormal100)) {
                Text(text = mealCategory.name, style = MaterialTheme.typography.h6)
            }
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