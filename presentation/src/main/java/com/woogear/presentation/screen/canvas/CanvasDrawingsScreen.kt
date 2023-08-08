package com.woogear.presentation.screen.canvas

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.woogear.presentation.component.Screens
import com.woogear.presentation.model.ScreenType

@Composable
fun CanvasDrawingScreen(
    viewModel: CanvasDrawingsViewModel,
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