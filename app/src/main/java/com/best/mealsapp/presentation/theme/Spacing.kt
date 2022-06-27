package com.best.mealsapp.presentation.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val noSpacing: Dp = 0.dp,

    val gridSmall100: Dp = 4.dp,
    val gridSmall125: Dp = 8.dp,
    val gridSmall150: Dp = 12.dp,

    val gridNormal100: Dp = 16.dp,
    val gridNormal125: Dp = 20.dp,
    val gridNormal150: Dp = 24.dp,
    val gridNormal175: Dp = 28.dp,

    val gridLarge100: Dp = 32.dp,
    val gridLarge125: Dp = 36.dp,
    val gridLarge150: Dp = 40.dp,
    val gridLarge175: Dp = 44.dp,
)

val LocalSpacing = compositionLocalOf { Spacing() }
