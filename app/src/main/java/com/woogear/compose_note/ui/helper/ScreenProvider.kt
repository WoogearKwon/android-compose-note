package com.woogear.compose_note.ui.helper

import com.woogear.presentation.model.Screen
import com.woogear.presentation.model.ScreenCategory
import com.woogear.presentation.model.ScreenCategoryType
import com.woogear.presentation.model.ScreenType

val appScreenCategories
    get() = listOf(
        composCatalogs,
        canvasDrawings,
        composeExamples
    )

private val composCatalogs
    get() = ScreenCategory(
        title = "Compose Catalogs",
        description = "Compose UI Components Catalogs",
        type = ScreenCategoryType.ComposeCatalog,
        screens = listOf(
            Screen(
                title = "Bottom Navigation",
                description = "Bottom Navigation Tab Example",
                type = ScreenType.BottomNavigation
            ),
        )
    )

private val canvasDrawings
    get() = ScreenCategory(
        title = "Canvas Drawings",
        description = "Custom UI Components on Canvas",
        type = ScreenCategoryType.CanvasDrawing,
        screens = listOf(
            Screen(
                title = "Canvas Chart",
                description = "3 Types of Chart Component Draw on Canvas",
                type = ScreenType.CanvasChart
            )
        )
    )

private val composeExamples
    get() = ScreenCategory(
        title = "Compose Examples",
        description = "Example Screens Using Compose",
        type = ScreenCategoryType.Example,
        screens = listOf(
            Screen(
                title = "Unsplash Demo",
                description = "Unsplash Images",
                type = ScreenType.Unsplash,
            )
        )
    )