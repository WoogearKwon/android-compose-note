package com.woogear.compose_note.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.woogear.compose_note.ui.navigation.Route.BottomNav.bottomNav
import com.woogear.compose_note.ui.navigation.Route.CanvasChart.canvasChart
import com.woogear.compose_note.ui.navigation.Route.CanvasDrawing.canvasScreen
import com.woogear.compose_note.ui.navigation.Route.Categories.categoriesScreen
import com.woogear.compose_note.ui.navigation.Route.ComposeCatalog.composeCatalogScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Route.initialPath
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        categoriesScreen(navController = navController)
        composeCatalogScreen(navController = navController)
        canvasScreen(navController = navController)
        canvasChart(navController = navController)
        bottomNav(navController = navController)
    }
}