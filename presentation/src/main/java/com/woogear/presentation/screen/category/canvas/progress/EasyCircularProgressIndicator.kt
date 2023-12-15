package com.woogear.presentation.screen.category.canvas.progress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.woogear.presentation.theme.White
import com.woogear.presentation.theme.paletteBlue010
import com.woogear.presentation.theme.paletteBlue100
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun EasyCircularProgressIndicator(
    modifier: Modifier = Modifier,
    value : Float,
    goalValue: Float,
    progressColor: Color = paletteBlue100,
    backgroundColor: Color = paletteBlue010,
    progressStrokeWidth: Dp = 22.dp,
    backgroundStrokeWidth: Dp = 16.dp,
    pointerColor: Color = White,
    durationInMilliseconds: Int = 1000,
    animDelay: Int = 0,
    startValue: Float = 0f,
    onValueChanged: (Float) -> Unit,
) {
    var animationPlayed by remember { mutableStateOf(false) }
    val animatedValue by animateFloatAsState(
        targetValue = if (animationPlayed) value / goalValue else startValue,
        animationSpec = tween(
            durationMillis = durationInMilliseconds,
            delayMillis = animDelay
        ),
        label = "",
    )

    LaunchedEffect(key1 = true) { animationPlayed = true }
    LaunchedEffect(key1 = animatedValue) {
        onValueChanged(animatedValue)
    }

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .defaultMinSize(
                minWidth = EasyProgressDefaults.minSize,
                minHeight = EasyProgressDefaults.minSize
            )
    ) {
        val diameter = if (size.width < size.height) size.width else size.height
        val radius =
            if (diameter == 0f) EasyProgressDefaults.minRadius
            else (diameter / 2).toDp()

        drawIntoCanvas {
            drawBackgroundCircle(
                radius = radius,
                backgroundColor = backgroundColor,
                backgroundStrokeWidth = backgroundStrokeWidth
            )
            if (animatedValue != 0f) {
                drawProgressArc(
                    radius = radius,
                    color = progressColor,
                    progressValue = animatedValue,
                    progressStrokeWidth = progressStrokeWidth,
                    pointerColor = pointerColor,
                    goalAchieved = animatedValue == goalValue
                )
            }
        }
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
    progressValue: Float,
    progressStrokeWidth: Dp,
    pointerWidth: Dp = progressStrokeWidth / 3,
    pointerColor: Color,
    goalAchieved: Boolean,
) {
    val centerX = size.width / 2
    val centerY = size.height / 2
    val startX = cos(Math.toRadians(180.0)).toFloat() * radius.toPx() + centerX
    val startY = sin(Math.toRadians(-90.0)).toFloat() * radius.toPx() + centerY

    // ex) Math.toRadians(180) == 3.14(π)
    val radians = Math.toRadians(360.0 * progressValue - 90f)
    val cos = cos(radians).toFloat() // radius-height ratio
    val sin = sin(radians).toFloat() // radius-hypotenuse ratio
    val px = cos * radius.toPx() + centerX
    val py = sin * radius.toPx() + centerY

    // pointer shadow
//    drawCircle(
//        brush = Brush.radialGradient(
//            center = Offset(px, py),
//            colors = listOf(
//                Color(0xFF2E2E2E),
//                Color(0x80FFFFFF),
//                Color(0x0DFFFFFF),
//                Color(0x0DFFFFFF),
//                Color(0x00FFFFFF),
//                Color(0x00FFFFFF),
//                Color(0x00FFFFFF),
//            ),
//            tileMode = TileMode.Decal
//        ),
//        radius = 1f,
//        center = Offset(px, py),
//        alpha = 0.2f,
//        style = Stroke(
//            width = progressStrokeWidth.toPx() * 3f,
//            cap = StrokeCap.Round,
//        ),
//    )
    // progressStroke
    drawArc(
        color = color,
        startAngle = -90f,
        sweepAngle = 360 * progressValue,
        useCenter = false,
        topLeft = Offset(startX, startY),
        size = Size(width = radius.toPx() * 2f, height = radius.toPx() * 2f),
        style = Stroke(
            width = progressStrokeWidth.toPx(),
            cap = StrokeCap.Round,
        )
    )
    // pointer
    if (goalAchieved.not()) {
        drawCircle(
            color = pointerColor,
            radius = 1f,
            center = Offset(px, py),
            style = Stroke(
                width = pointerWidth.toPx(),
                cap = StrokeCap.Round,
            ),
        )
    }
}

object EasyProgressDefaults {
    val minSize = 200.dp
    val minRadius = minSize / 2
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF,
)
@Composable
private fun CanvasProgressScreen_Preview() {
    EasyCircularProgressIndicator(
        modifier = Modifier
            .size(200.dp)
            .padding(10.dp),
        value = 70f,
        goalValue = 100f,
        onValueChanged = {}
    )
}