package com.woogear.compose_note.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.woogear.compose_note.ui.navigation.Route.AutoSizingText.autoSizingText
import com.woogear.compose_note.ui.navigation.Route.BottomNav.bottomNav
import com.woogear.compose_note.ui.navigation.Route.CanvasChart.canvasChart
import com.woogear.compose_note.ui.navigation.Route.CircularCanvasProgress.circularCanvasProgress
import com.woogear.compose_note.ui.navigation.Route.Category.composeCatalogScreen
import com.woogear.compose_note.ui.navigation.Route.GradientSlider.gradientSlider
import com.woogear.compose_note.ui.navigation.Route.Home.homeScreen
import com.woogear.compose_note.ui.navigation.Route.PagingDemo.pagingDemo
import com.woogear.compose_note.ui.navigation.Route.StickyHeader.stickyHeader
import com.woogear.compose_note.ui.navigation.Route.TopTabsWithColumn.topTabsWithColumn
import com.woogear.compose_note.ui.navigation.Route.Unsplash.unsplash
import com.woogear.compose_note.ui.navigation.Route.VerticalTimeline.verticalTimeline

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Route.initialPath,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeScreen(navController = navController)
        composeCatalogScreen(navController = navController)

        bottomNav(navController = navController)
        topTabsWithColumn(navController = navController)
        autoSizingText(navController = navController)
        stickyHeader(navController = navController)
        pagingDemo(navController = navController)
        canvasChart(navController = navController)
        circularCanvasProgress(navController = navController)
        gradientSlider(navController = navController)
        unsplash(navController = navController)
        verticalTimeline(navController = navController)
    }
}