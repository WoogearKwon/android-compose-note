package com.woogear.compose_note.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.woogear.compose_note.ui.sceen.CategoriesScreen

sealed class Route(
    val routePath: String,
    val description: String? = null
    ) {
    fun name(): String = javaClass.simpleName

    object Categories : Route(routePath = "categories") {

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

    object ComponentCatalog : Route(routePath = "componentCatalog") {
        fun NavGraphBuilder.catalogScreen(navController: NavController) {
            composable(route = routePath) {

            }
        }
    }

    object CanvasPainting : Route(routePath = "canvasPainting") {
        fun NavGraphBuilder.paintingScreen(navController: NavController) {
            composable(route = routePath) {

            }
        }
    }

    companion object {
        val initialPath = Categories.routePath
    }
}
