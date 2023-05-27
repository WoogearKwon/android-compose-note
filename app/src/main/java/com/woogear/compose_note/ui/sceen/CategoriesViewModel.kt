package com.woogear.compose_note.ui.sceen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.woogear.compose_note.ui.navigation.Route

class CategoriesViewModel : ViewModel() {
    val routes: List<Route> by mutableStateOf(CATEGORY_ROUTES)

    companion object {
        val CATEGORY_ROUTES: List<Route> = listOf(
            Route.ComponentCatalog,
            Route.CanvasPainting
        )
    }
}