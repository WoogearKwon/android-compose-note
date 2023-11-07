package com.woogear.presentation.model

import kotlinx.serialization.Serializable

@Serializable
data class ScreenCategory(
    val title: String,
    val description: String,
    val type: ScreenCategoryType,
    val screens: List<Screen>,
)

enum class ScreenCategoryType {
    ComposeCatalog,
    CanvasDrawing,
    Example,
}

@Serializable
data class Screen(
    val title: String,
    val description: String,
    val type: ScreenType,
)

enum class ScreenType {
    BottomNavigation,
    CanvasChart,
    Unsplash,
}
