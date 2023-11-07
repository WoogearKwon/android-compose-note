package com.woogear.presentation.model

import androidx.compose.ui.graphics.Color
import com.woogear.presentation.theme.basicColors

data class ScreenCategory(
    val title: String,
    val description: String,
    val type: ScreenCategoryType,
    val color: Color = basicColors.random(),
    val screens: List<Screen>,
)

enum class ScreenCategoryType {
    ComposeCatalog,
    CanvasDrawing,
}

data class Screen(
    val title: String,
    val description: String,
    val type: ScreenType,
    val color: Color = basicColors.random()
)

enum class ScreenType {
    BottomNavigation,
    Unsplash,
    CanvasChart,
}

val appScreenCategories get() = listOf(
    composCatalogs,
    canvasDrawings,
)

val composCatalogs get() = ScreenCategory(
    title = "Compose Catalogs",
    description = "Compose UI Components Catalogs",
    type = ScreenCategoryType.ComposeCatalog,
    screens = listOf(
        Screen(
            title = "Bottom Navigation",
            description = "Bottom Navigation Tab Example",
            type = ScreenType.BottomNavigation
        ),
        Screen(
            title = "Unsplash Demo",
            description = "Unsplash Images",
            type = ScreenType.Unsplash,
        )
    )
)

val canvasDrawings get() = ScreenCategory(
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
