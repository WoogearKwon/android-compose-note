package com.woogear.compose_note.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.woogear.compose_note.ui.sceen.CategoriesScreen

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

    object ComponentCatalog : Route(
        routePath = "component_catalogs",
        name = "Component Catalogs",
        description = "Compose UI Components Catalogs"
    ) {
        fun NavGraphBuilder.catalogScreen(navController: NavController) {
            composable(route = routePath) {

            }
        }
    }

    object CanvasPainting : Route(
        routePath = "canvas_drawings",
        name = "Canvas Drawings",
        description = "Custom UI Components on Canvas"
    ) {
        fun NavGraphBuilder.paintingScreen(navController: NavController) {
            composable(route = routePath) {

            }
        }
    }

    companion object {
        val initialPath = Categories.routePath
    }
}
