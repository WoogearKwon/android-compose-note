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
import com.woogear.presentation.screen.category.canvas.progress.CanvasProgressScreen
import com.woogear.presentation.screen.category.compose.autosizingtext.AutoSizingTextScreen
import com.woogear.presentation.screen.category.compose.bottomnav.BottomNavScreen
import com.woogear.presentation.screen.category.compose.paging.PagingDemoScreen
import com.woogear.presentation.screen.category.compose.toptabs.TopTabsWithColumnScreen
import com.woogear.presentation.screen.category.example.unsplash.UnsplashPhotosScreen
import com.woogear.presentation.screen.category.compose.stickyheader.StickyHeaderScreen
import com.woogear.presentation.screen.category.example.timeline.VerticalTimelineScreen
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
            composable(route = routePath) { backStackEntry ->
                val args: CategoryArgs = backStackEntry.getRequiredArgument(CategoryArgs.Key)

                CategoryScreen(
                    modifier = Modifier.imePadding(),
                    screenCategory = args.categoryType,
                    onClickExit = navController::popBackStack,
                    onClickComponent = { screenType ->
                        when (screenType) {
                            // Compose Catalogs
                            ScreenType.BottomNavigation -> {
                                navController.navigate(BottomNav.getPath())
                            }

                            ScreenType.TopTabsWithColumn -> {
                                navController.navigate(TopTabsWithColumn.getPath())
                            }

                            ScreenType.AutoSizingText -> {
                                navController.navigate(AutoSizingText.getPath())
                            }

                            ScreenType.StickyHeader -> {
                                navController.navigate(StickyHeader.getPath())
                            }

                            ScreenType.PagingDemo -> {
                                navController.navigate(PagingDemo.getPath())
                            }

                            // Canvas
                            ScreenType.ChartView -> {
                                navController.navigate(CanvasChart.getPath())
                            }

                            ScreenType.ProgressView -> {
                                navController.navigate(CanvasProgress.getPath())
                            }

                            // Compose demo
                            ScreenType.Unsplash -> {
                                navController.navigate(Unsplash.getPath())
                            }

                            ScreenType.VerticalTimeline -> {
                                navController.navigate(VerticalTimeline.getPath())
                            }
                        }
                    }
                )
            }
        }
    }

    object BottomNav : Route(routePath = "/compose/bottom_nav") {
        fun getPath() = routePath

        fun NavGraphBuilder.bottomNav(navController: NavController) {
            composable(route = routePath) {
                BottomNavScreen(
                    modifier = Modifier.imePadding(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object TopTabsWithColumn : Route(routePath = "/compose/top_tabs_with_column") {
        fun getPath() = routePath

        fun NavGraphBuilder.topTabsWithColumn(navController: NavController) {
            composable(route = routePath) {
                TopTabsWithColumnScreen(
                    modifier = Modifier.imePadding(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object AutoSizingText : Route(routePath = "/compose/auto_sizing_text") {
        fun getPath() = routePath

        fun NavGraphBuilder.autoSizingText(navController: NavController) {
            composable(route = routePath) {
                AutoSizingTextScreen(
                    modifier = Modifier.imePadding(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object StickyHeader : Route(routePath = "/compose/sticky_header") {
        fun getPath() = routePath

        fun NavGraphBuilder.stickyHeader(navController: NavController) {
            composable(route = routePath) {
                StickyHeaderScreen(
                    modifier = Modifier.imePadding(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object PagingDemo : Route(routePath = "/compose/paging") {
        fun getPath() = routePath

        fun NavGraphBuilder.pagingDemo(navController: NavController) {
            composable(route = routePath) {
                PagingDemoScreen(
                    modifier = Modifier.imePadding(),
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }


    object CanvasChart : Route(routePath = "/canvas/chart") {
        fun getPath() = routePath

        fun NavGraphBuilder.canvasChart(navController: NavController) {
            composable(route = routePath) {
                ChartScreen(
                    modifier = Modifier.imePadding(),
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object CanvasProgress : Route(routePath = "/canvas/progress") {
        fun getPath() = routePath

        fun NavGraphBuilder.canvasProgress(navController: NavController) {
            composable(route = routePath) {
                CanvasProgressScreen(
                    modifier = Modifier.imePadding(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object Unsplash : Route(routePath = "/example/unsplash") {
        fun getPath() = routePath

        fun NavGraphBuilder.unsplash(navController: NavController) {
            composable(route = routePath) {
                UnsplashPhotosScreen(
                    modifier = Modifier.imePadding(),
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    object VerticalTimeline : Route(routePath = "/example/vertical_timeline") {
        fun getPath() = routePath

        fun NavGraphBuilder.verticalTimeline(navController: NavController) {
            composable(route = routePath) {
                VerticalTimelineScreen(
                    modifier = Modifier.imePadding(),
                    viewModel = hiltViewModel(),
                    onClickExit = navController::popBackStack
                )
            }
        }
    }

    companion object {
        val initialPath = Home.routePath
    }
}
