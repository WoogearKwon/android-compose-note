package com.woogear.compose_note.ui.screen.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.woogear.compose_note.ui.navigation.Route

class ComposeCatalogViewModel : ViewModel() {
    val routes: List<Route> by mutableStateOf(CATALOG_ROUTES)

    companion object {
        val CATALOG_ROUTES: List<Route> = listOf(
            Route.BottomNav
        )
    }
}