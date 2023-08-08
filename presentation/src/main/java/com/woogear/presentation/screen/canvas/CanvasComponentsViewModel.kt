package com.woogear.presentation.screen.canvas

import androidx.lifecycle.ViewModel
import com.woogear.presentation.model.ScreenCategoryType
import com.woogear.presentation.model.canvasDrawings

class CanvasComponentsViewModel : ViewModel() {
    val categoryType = ScreenCategoryType.ComposeCatalog
    val screenCategory =  canvasDrawings
}