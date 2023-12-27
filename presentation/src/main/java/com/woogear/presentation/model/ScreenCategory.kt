package com.woogear.presentation.model

import androidx.annotation.StringRes
import kotlinx.serialization.Serializable

@Serializable
data class ScreenCategory(
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int,
    val type: ScreenCategoryType,
    val screens: List<Screen>,
    val backgroundColor: ULong,
)

enum class ScreenCategoryType {
    ComposeCatalog,
    CanvasDrawing,
    Example,
}

@Serializable
data class Screen(
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int,
    val type: ScreenType,
    val backgroundColor: ULong,
)

enum class ScreenType {
    // Compose
    BottomNavigation,
    TopTabsWithColumn,
    AutoSizingText,
    StickyHeader,
    PagingDemo,
    // Canvas
    Chart,
    CircularProgress,
    GradientSlider,
    // Smaple
    Unsplash,
    VerticalTimeline,
}
