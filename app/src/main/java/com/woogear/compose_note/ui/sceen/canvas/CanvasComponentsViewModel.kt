package com.woogear.compose_note.ui.sceen.canvas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.woogear.compose_note.ui.navigation.Route

class CanvasComponentsViewModel : ViewModel() {
    val routes: List<Route> by mutableStateOf(CANVAS_ROUTES)

    companion object {
        val CANVAS_ROUTES: List<Route> = listOf(
            Route.CanvasChart
        )
    }
}