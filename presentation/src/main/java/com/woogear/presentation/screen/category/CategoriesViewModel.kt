package com.woogear.presentation.screen.category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.woogear.presentation.model.ScreenCategory
import com.woogear.presentation.model.appScreenCategories

class CategoriesViewModel : ViewModel() {
    val screenCategories: List<ScreenCategory> by mutableStateOf(appScreenCategories)
}