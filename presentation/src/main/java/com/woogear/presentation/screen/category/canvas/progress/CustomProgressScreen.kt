package com.woogear.presentation.screen.category.canvas.progress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.R
import com.woogear.presentation.theme.paletteBlue010

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
        CustomProgressBar(
            modifier = Modifier.padding(it),
            percentage = 0.9f,

            )
    }
}

@Composable
private fun CustomProgressBar(
    modifier: Modifier = Modifier,
    percentage: Float,
    radius: Dp = 50.dp,
    color: Color = paletteBlue010,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
) {
    var animationPlayed by remember {
        mutableStateOf(true)
    }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) 0f else percentage,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        ),
        label = ""
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = false
    }

    Box(
        modifier = Modifier.size(radius * 2f),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = modifier
                .padding(all = 22.dp)
                .size(radius * 2f)
                .fillMaxSize()
        ) {

            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (curPercentage.value * 100).toInt().toString(),
            color = Color.Black,
            fontSize = 22.sp
        )
    }

}

@Preview
@Composable
private fun CanvasProgressScreen_Preview() {
    CanvasProgressScreen(
        modifier = Modifier,
        onClickExit = {}
    )
}