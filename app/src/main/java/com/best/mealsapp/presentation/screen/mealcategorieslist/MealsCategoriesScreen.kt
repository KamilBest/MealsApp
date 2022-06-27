package com.best.mealsapp.presentation.screen.mealcategorieslist

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.best.mealsapp.R
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
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = LocalSpacing.current.gridNormal100)
    ) {
        Row(modifier = Modifier.animateContentSize()) {
            AsyncImage(
                model = mealCategory.imageUrl,
                contentDescription = mealCategory.name,
                modifier = Modifier
                    .size(88.dp)
                    .padding(LocalSpacing.current.gridSmall100)
                    .align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8F)
                    .align(Alignment.CenterVertically)
                    .padding(LocalSpacing.current.gridNormal100)
            ) {
                Text(text = mealCategory.name, style = MaterialTheme.typography.h6)
                Text(
                    text = mealCategory.description,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.subtitle2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = if (isExpanded) 10 else 4
                )
            }
            Icon(
                imageVector = getProperArrowImageVector(isExpanded),
                contentDescription = stringResource(R.string.expand_icon_content_descr),
                modifier = Modifier
                    .padding(
                        LocalSpacing.current.gridNormal100
                    )
                    .align(if (isExpanded) Alignment.Bottom else Alignment.CenterVertically)
                    .clickable {
                        isExpanded = !isExpanded
                    }
            )
        }
    }
}

private fun getProperArrowImageVector(isExpanded: Boolean): ImageVector {
    return if (isExpanded) {
        Icons.Filled.KeyboardArrowUp
    } else Icons.Filled.KeyboardArrowDown
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsAppTheme {
        MealCategoriesScreen()
    }
}