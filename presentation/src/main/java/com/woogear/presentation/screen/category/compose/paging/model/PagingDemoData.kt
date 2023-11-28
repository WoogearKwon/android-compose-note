package com.woogear.presentation.screen.category.compose.paging.model

import androidx.compose.ui.graphics.Color
import com.woogear.presentation.theme.backgroundColors

data class PagingDemoData(
    val names: List<BibleName>,
    val page: Int,
    val hasNext: Boolean,
)

data class BibleName(
    val name: String = BibleNames.random,
    val color: Color = Color(backgroundColors.random()),
)
