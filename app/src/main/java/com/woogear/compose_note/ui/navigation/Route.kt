package com.woogear.compose_note.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.woogear.compose_note.ui.screen.components.bottomnav.BottomNavScreen
import com.woogear.compose_note.ui.screen.canvas.CanvasComponentsScreen
import com.woogear.compose_note.ui.screen.category.CategoriesScreen
import com.woogear.compose_note.ui.screen.canvas.chart.ChartScreen
import com.woogear.compose_note.ui.screen.components.ComposeCatalogScreen

sealed class Route(
    val routePath: String,
    val name: String = "no name",
    val description: String = "no description"
    ) {

    object Categories : Route(
        routePath = "categories",
        "Categories",
    ) {
        fun NavGraphBuilder.categoriesScreen(navController: NavController) {
            composable(route = routePath) {
                CategoriesScreen(
                    viewModel = hiltViewModel(),
                    onClickCategory = { path ->
                        navController.navigate(path)
                    }
                )
            }
        }
    }

    object ComposeCatalog : Route(
        routePath = "compose_catalogs",
        name = "Compose Catalogs",
        description = "Compose UI Components Catalogs"
    ) {
        fun NavGraphBuilder.composeCatalogScreen(navController: NavController) {
            composable(route = routePath) {
                ComposeCatalogScreen(
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack,
                    onClickComponent = { path ->
                        navController.navigate(path)
                    }
                )
            }
        }
    }

    object CanvasPainting : Route(
        routePath = "canvas_drawings",
        name = "Canvas Drawings",
        description = "Custom UI Components on Canvas"
    ) {
        fun NavGraphBuilder.canvasScreen(navController: NavController) {
            composable(route = routePath) {
                CanvasComponentsScreen(
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack,
                    onClickComponent = { path ->
                        navController.navigate(path)
                    })
            }
        }
    }

    object CanvasChart : Route(
        routePath = "canvas_chart",
        name = "Canvas Chart",
        description = "3 Types of Chart Component Drawn on Canvas"
    ) {
        fun NavGraphBuilder.canvasChart(navController: NavController) {
            composable(route = routePath) {
                ChartScreen(
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object BottomNav: Route(
        routePath = "bottom_nav",
        name = "Bottom Navigation",
        description = "Bottom Navigation Tab Example"
    ) {
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
