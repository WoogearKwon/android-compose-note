package com.woogear.presentation.screen.category.canvas.progress

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.R
import com.woogear.presentation.theme.paletteBlue010
import com.woogear.presentation.theme.paletteBlue100

@OptIn(ExperimentalTextApi::class)
@Composable
fun CanvasProgressScreen(
    modifier: Modifier = Modifier,
    onClickExit: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onClickExit.invoke() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = {
                    Text(text = stringResource(R.string.canvas_progress_title))
                },
            )
        },
    ) {
        var percentage by remember { mutableStateOf(0f) }

        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            EasyCircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                percentage = 0.7f,
                onChangePercentage = {
                    percentage = it
                }
            )
            Text(
                modifier = Modifier,
                text = "${(percentage * 100).toInt()}%",
                color = paletteBlue100,
                fontSize = 50.sp,
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Black, paletteBlue100, paletteBlue010),
                    ),
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF,
)
@Composable
private fun CanvasProgressScreen_Preview() {
    CanvasProgressScreen(
        onClickExit = {}
    )
}