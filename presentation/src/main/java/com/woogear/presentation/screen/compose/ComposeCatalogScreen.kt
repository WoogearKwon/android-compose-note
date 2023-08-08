package com.woogear.presentation.screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.component.Screens
import com.woogear.presentation.model.Screen
import com.woogear.presentation.model.ScreenCategoryType
import com.woogear.presentation.model.ScreenType
import kotlinx.serialization.Serializable

@Composable
fun ComposeCatalogScreen(
    viewModel: ComposeCatalogViewModel,
    onClickExit: () -> Unit,
    onClickComponent: (type: ScreenType) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickExit) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = {
                    Text(text = viewModel.screenCategory.title)
                }
            )
        },
    ) {
        Screens(
            modifier = Modifier.padding(it),
            screens = viewModel.screenCategory.screens,
            onClickCategory = onClickComponent
        )
    }
}

@Serializable
data class ComposeComponentArgs(
    val categoryType: ScreenCategoryType
) {
    companion object {
        const val Key = "ComposeComponentArgs"
    }
}