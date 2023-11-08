package com.woogear.compose_note.ui.navigation

import androidx.compose.foundation.layout.imePadding
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.woogear.compose_note.ui.helper.ScreenProvider
import com.woogear.compose_note.ui.helper.encodeArgument
import com.woogear.compose_note.ui.helper.getRequiredArgument
import com.woogear.presentation.model.ScreenCategory
import com.woogear.presentation.model.ScreenType
import com.woogear.presentation.screen.category.CategoryArgs
import com.woogear.presentation.screen.category.CategoryScreen
import com.woogear.presentation.screen.category.canvas.chart.ChartScreen
import com.woogear.presentation.screen.category.compose.bottomnav.BottomNavScreen
import com.woogear.presentation.screen.category.example.unsplash.UnsplashScreen
import com.woogear.presentation.screen.home.HomeScreen

sealed class Route(val routePath: String) {

    object Home : Route(routePath = "/home") {
        fun NavGraphBuilder.homeScreen(navController: NavController) {
            composable(route = routePath) {
                HomeScreen(
                    modifier = Modifier.imePadding(),
                    screenCategories = ScreenProvider.appScreenCategories,
                    onClickCategory = { category ->
                        navController.navigate(route = Category.getPath(category))
                    }
                )
            }
        }
    }

    object Category : Route(routePath = "/category/{${CategoryArgs.Key}}") {
        fun getPath(screenCategory: ScreenCategory): String {
            val encoded = encodeArgument(CategoryArgs(categoryType = screenCategory))

            return "/category/$encoded"
        }

        fun NavGraphBuilder.composeCatalogScreen(navController: NavController) {
            composable(
                route = routePath,
            ) { backStackEntry ->
                val args: CategoryArgs = backStackEntry.getRequiredArgument(CategoryArgs.Key)

                CategoryScreen(
                    screenCategory = args.categoryType,
                    onClickExit = navController::popBackStack,
                    onClickComponent = { screenType ->
                        when (screenType) {
                            ScreenType.BottomNavigation -> {
                                navController.navigate(BottomNav.getPath())
                            }
                            ScreenType.CanvasChart -> {
                                navController.navigate(CanvasChart.getPath())
                            }
                            ScreenType.Unsplash -> {
                                navController.navigate(Unsplash.getPath())
                            }
                        }
                    }
                )
            }
        }
    }

    object CanvasChart : Route(routePath = "/canvas/chart") {
        fun getPath() = routePath

        fun NavGraphBuilder.canvasChart(navController: NavController) {
            composable(route = routePath) {
                ChartScreen(
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object BottomNav : Route(routePath = "/compose/bottom_nav") {
        fun getPath() = routePath

        fun NavGraphBuilder.bottomNav(navController: NavController) {
            composable(route = routePath) {
                BottomNavScreen(
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object Unsplash : Route(routePath = "/compose/unsplash") {
        fun getPath() = routePath

        fun NavGraphBuilder.unsplash(navController: NavController) {
            composable(route = routePath) {
                UnsplashScreen(
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    companion object {
        val initialPath = Home.routePath
    }
}
