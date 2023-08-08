package com.woogear.presentation.screen.compose

import androidx.lifecycle.ViewModel
import com.woogear.presentation.model.ScreenCategoryType
import com.woogear.presentation.model.composCatalogs

class ComposeCatalogViewModel : ViewModel() {
    val categoryType = ScreenCategoryType.ComposeCatalog
    val screenCategory = composCatalogs
}