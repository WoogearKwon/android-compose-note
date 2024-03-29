package com.woogear.presentation.component.chart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.input.pointer.pointerInput
import com.woogear.presentation.component.chart.drawer.ChartDrawer

@Composable
fun EasyChart(
    modifier: Modifier = Modifier,
    duration: ChartDuration,
    chartData: ChartData,
    chartDrawer: ChartDrawer,
    focusIndex: Int,
) {
    var tapOffset by remember { mutableStateOf<Offset?>(null) }
    var pointerOffset by remember { mutableStateOf<Offset?>(null) }

    var chartSize by remember { mutableStateOf(Size(0f, 0f)) }
    val chartProcessor by remember(chartData, chartSize) {
        mutableStateOf(ChartProcessor(chartSize, duration, chartData))
    }
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    tapOffset = it
                }
            }
    ) {
        chartSize = size

        drawIntoCanvas { canvas ->
            chartProcessor.setFocusIndex(focusIndex)
            chartDrawer.drawDangerArea(
                canvas = canvas,
                drawScope = this,
                chartProcessor = chartProcessor,
                safeLimitHigh = 120f,
                safeLimitLow = 50f
            )
            chartDrawer.drawLabelGroup(
                canvas = canvas,
                drawScope = this,
                chartProcessor = chartProcessor
            )
            chartDrawer.drawChart(
                canvas = canvas,
                drawScope = this,
                chartProcessor = chartProcessor,
                tapOffset = tapOffset,
                pointerOffset = pointerOffset,
            ) { offset, index ->
                pointerOffset = offset
            }
        }
    }
}
