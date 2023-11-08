package com.woogear.compose_note.ui.helper

import com.woogear.compose_note.R
import com.woogear.presentation.model.Screen
import com.woogear.presentation.model.ScreenCategory
import com.woogear.presentation.model.ScreenCategoryType
import com.woogear.presentation.model.ScreenType
import com.woogear.presentation.theme.backgroundColors

object ScreenProvider {
    val appScreenCategories= listOf(
        composCatalogs,
        canvasDrawings,
        composeExamples
    )
}

private val composCatalogs = ScreenCategory(
    titleRes = R.string.compose_catalogs_title,
    descriptionRes = R.string.compose_catalogs_description,
    type = ScreenCategoryType.ComposeCatalog,
    screens = listOf(
        Screen(
            titleRes = R.string.bottom_navigation_title,
            descriptionRes = R.string.bottom_navigation_description,
            type = ScreenType.BottomNavigation,
            backgroundColor = backgroundColors.random()
        ),
    ),
    backgroundColor = backgroundColors.random()
)

private val canvasDrawings = ScreenCategory(
    titleRes = R.string.canvas_drawings_title,
    descriptionRes = R.string.canvas_drawings_description,
    type = ScreenCategoryType.CanvasDrawing,
    screens = listOf(
        Screen(
            titleRes = R.string.canvas_chart_title,
            descriptionRes = R.string.canvas_chart_description,
            type = ScreenType.CanvasChart,
            backgroundColor = backgroundColors.random()
        )
    ),
    backgroundColor = backgroundColors.random()
)

private val composeExamples = ScreenCategory(
    titleRes = R.string.compose_examples_title,
    descriptionRes = R.string.compose_example_description,
    type = ScreenCategoryType.Example,
    screens = listOf(
        Screen(
            titleRes = R.string.unsplash_demo_title,
            descriptionRes = R.string.unsplash_description,
            type = ScreenType.Unsplash,
            backgroundColor = backgroundColors.random()
        )
    ),
    backgroundColor = backgroundColors.random()
)