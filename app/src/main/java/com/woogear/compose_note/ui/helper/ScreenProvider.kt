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
        Screen(
            titleRes = R.string.top_tabs_title,
            descriptionRes = R.string.top_tabs_description,
            type = ScreenType.TopTabsWithColumn,
            backgroundColor = backgroundColors.random()
        ),
        Screen(
            titleRes = R.string.auto_sized_text_title,
            descriptionRes = R.string.auto_sized_text_description,
            type = ScreenType.AutoSizingText,
            backgroundColor = backgroundColors.random()
        ),
        Screen(
            titleRes = R.string.sticky_header_title,
            descriptionRes = R.string.sticky_header_description,
            type = ScreenType.StickyHeader,
            backgroundColor = backgroundColors.random()
        ),
        Screen(
            titleRes = R.string.paging_demo_title,
            descriptionRes = R.string.paging_demo_description,
            type = ScreenType.PagingDemo,
            backgroundColor = backgroundColors.random()
        )
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
            type = ScreenType.ChartView,
            backgroundColor = backgroundColors.random()
        ),
        Screen(
            titleRes = R.string.canvas_progress_title,
            descriptionRes = R.string.canvas_progress_description,
            type = ScreenType.ProgressView,
            backgroundColor = backgroundColors.random()
        ),
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
        ),
        Screen(
            titleRes = R.string.vertical_timeline_title,
            descriptionRes = R.string.vertical_timeline_description,
            type = ScreenType.VerticalTimeline,
            backgroundColor = backgroundColors.random()
        )

    ),
    backgroundColor = backgroundColors.random()
)