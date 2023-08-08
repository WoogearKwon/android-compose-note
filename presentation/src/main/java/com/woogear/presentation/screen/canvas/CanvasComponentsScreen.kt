package com.woogear.presentation.screen.canvas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.model.ScreenType
import com.woogear.presentation.theme.RetroBlue03Basic

@Composable
fun CanvasComponentsScreen(
    viewModel: CanvasComponentsViewModel,
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
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(viewModel.screenCategory.screens) { screen ->
                Card(
                    elevation = 10.dp,
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable { onClickComponent(screen.type) },
                    backgroundColor = RetroBlue03Basic
                ) {
                    Row(
                        modifier = Modifier.padding(18.dp),
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = screen.title,
                            textAlign = TextAlign.Start,
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            modifier = Modifier.weight(2f),
                            text = screen.description,
                            textAlign = TextAlign.Start,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}