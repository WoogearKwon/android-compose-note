package com.woogear.compose_note.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.woogear.compose_note.ui.navigation.Route.CanvasPainting.paintingScreen
import com.woogear.compose_note.ui.navigation.Route.Categories.categoriesScreen
import com.woogear.compose_note.ui.navigation.Route.ComponentCatalog.catalogScreen

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
        catalogScreen(navController = navController)
        paintingScreen(navController = navController)
    }
}