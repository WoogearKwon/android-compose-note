package com.woogear.presentation.model

data class ScreenCategory(
    val title: String,
    val description: String,
    val type: ScreenCategoryType,
    val screens: List<Screen>,
)

enum class ScreenCategoryType {
    ComposeCatalog,
    CanvasDrawing
}

data class Screen(
    val title: String,
    val description: String,
    val type: ScreenType
)

enum class ScreenType {
    BottomNavigation,
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