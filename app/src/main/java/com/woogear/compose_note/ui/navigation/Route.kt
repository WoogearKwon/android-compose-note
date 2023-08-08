package com.woogear.compose_note.ui.navigation

import androidx.compose.foundation.layout.imePadding
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.woogear.presentation.screen.canvas.CanvasComponentsScreen
import com.woogear.presentation.screen.canvas.chart.ChartScreen
import com.woogear.presentation.screen.compose.bottomnav.BottomNavScreen
import com.woogear.presentation.model.ScreenCategoryType
import com.woogear.presentation.model.ScreenType
import com.woogear.presentation.screen.category.CategoriesScreen
import com.woogear.presentation.screen.compose.ComposeCatalogScreen
import com.woogear.presentation.screen.compose.ComposeComponentArgs

sealed class Route(val routePath: String) {

    object Categories : Route(
        routePath = "/categories",
    ) {
        fun NavGraphBuilder.categoriesScreen(navController: NavController) {
            composable(route = routePath) {
                CategoriesScreen(
                    modifier = Modifier.imePadding(),
                    viewModel = hiltViewModel(),
                    onClickCategory = { category ->
                        when (category.type) {
                            ScreenCategoryType.ComposeCatalog -> {
                                navController.navigate(ComposeCatalog.routePath)
                            }
                            ScreenCategoryType.CanvasDrawing -> {
                                navController.navigate(CanvasDrawing.routePath)
                            }
                        }
                    }
                )
            }
        }
    }

    object ComposeCatalog : Route(routePath = "/compose/{${ComposeComponentArgs.Key}}") {

        fun NavGraphBuilder.composeCatalogScreen(navController: NavController) {
            composable(
                route = routePath,
            ) {
                ComposeCatalogScreen(
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack,
                    onClickComponent = { screenType ->
                        when (screenType) {
                            ScreenType.BottomNavigation -> navController.navigate(BottomNav.routePath)
                            else -> {}
                        }
                    }
                )
            }
        }
    }

    object CanvasDrawing : Route(routePath = "/canvas") {

        fun NavGraphBuilder.canvasScreen(navController: NavController) {
            composable(route = routePath) {
                CanvasComponentsScreen(
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack,
                    onClickComponent = { screenType ->
                        when (screenType) {
                            ScreenType.CanvasChart -> navController.navigate(CanvasChart.routePath)
                            else -> {}
                        }
                    })
            }
        }
    }

    object CanvasChart : Route(routePath = "/canvas/chart") {
        fun NavGraphBuilder.canvasChart(navController: NavController) {
            composable(route = routePath) {
                ChartScreen(
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object BottomNav: Route(routePath = "/compose/bottom_nav") {
        fun NavGraphBuilder.bottomNav(navController: NavController) {
            composable(route = routePath) {
                BottomNavScreen()
            }
        }
    }

    companion object {
        val initialPath = Categories.routePath
    }
}
