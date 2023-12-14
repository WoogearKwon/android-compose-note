package com.woogear.presentation.screen.category.canvas.progress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.presentation.R
import com.woogear.presentation.theme.White
import com.woogear.presentation.theme.paletteBlue010
import com.woogear.presentation.theme.paletteBlue100
import kotlin.math.cos
import kotlin.math.sin

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
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            percentage = 0.7f,
        )
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
private fun CustomProgressBar(
    modifier: Modifier = Modifier,
    percentage: Float,
    radius: Dp = 100.dp,
    progressColor: Color = paletteBlue100,
    backgroundColor: Color = paletteBlue010,
    progressStrokeWidth: Dp = 20.dp,
    backgroundStrokeWidth: Dp = 16.dp,
    pointerRadius: Float = 1f,
    pointerColor: Color = White,
    animDuration: Int = 1000,
    animDelay: Int = 0,
    startPercentage: Float = 0f,
) {
    var animationPlayed by remember { mutableStateOf(false) }
    val curPercentage by animateFloatAsState(
        targetValue = if (animationPlayed) percentage else startPercentage,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        ),
        label = "",
    )

    LaunchedEffect(key1 = true) { animationPlayed = true }

    Box(
        modifier = modifier.size(radius * 2f),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(radius * 2f)
                .fillMaxSize()
        ) {
            drawIntoCanvas {
                drawBackgroundCircle(
                    radius = radius,
                    backgroundColor = backgroundColor,
                    backgroundStrokeWidth = backgroundStrokeWidth
                )
                drawProgressArc(
                    radius = radius,
                    color = progressColor,
                    curPercentage = curPercentage,
                    progressStrokeWidth = progressStrokeWidth,
                    pointerColor = pointerColor,
                    pointerRadius = pointerRadius
                )
            }
        }
        Text(
            text = (curPercentage * 100).toInt().toString(),
            color = progressColor,
            fontSize = 60.sp,
            style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                brush = Brush.linearGradient(
                    colors = listOf(Color.Black, progressColor, backgroundColor),
                )
            )
        )
    }
}

fun DrawScope.drawBackgroundCircle(
    radius: Dp,
    backgroundColor: Color,
    backgroundStrokeWidth: Dp,
) {
    drawCircle(
        color = backgroundColor,
        radius = radius.toPx(),
        style = Stroke(
            width = backgroundStrokeWidth.toPx(),
            cap = StrokeCap.Round,
        )
    )
}

fun DrawScope.drawProgressArc(
    radius: Dp,
    color: Color,
    curPercentage: Float,
    progressStrokeWidth: Dp,
    pointerColor: Color,
    pointerRadius: Float
) {
    drawArc(
        color = color,
        startAngle = -90f,
        sweepAngle = 360 * curPercentage,
        useCenter = false,
        style = Stroke(
            width = progressStrokeWidth.toPx(),
            cap = StrokeCap.Round,
        )
    )

    val centerX = size.width / 2
    val centerY = size.height / 2
    // ex) Math.toRadians(180) == 3.14(π)
    val radians = Math.toRadians(360.0 * curPercentage - 90f)
    val cos = cos(radians).toFloat() // radius-height ratio
    val sin = sin(radians).toFloat() // radius-hypotenuse ratio
    val px = cos * radius.toPx() + centerX
    val py = sin * radius.toPx() + centerY

    drawCircle(
        color = pointerColor,
        radius = pointerRadius,
        center = Offset(px, py),
        style = Stroke(
            width = (progressStrokeWidth / 3).toPx(),
            cap = StrokeCap.Round,
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun CanvasProgressScreen_Preview() {
    CustomProgressBar(
        modifier = Modifier.padding(10.dp),
        percentage = 0.7f,
        startPercentage = 0.5f
    )
}