package com.woogear.compose_note.ui.component.chart.drawer

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.woogear.compose_note.ui.component.chart.ChartProcessor
import com.woogear.compose_note.ui.component.chart.drawer.ChartDrawer.Companion.CHART_INDEX_0

class BarChartDrawer(
    private val barWidth: Dp = 10.dp,
    private val barRadius: Dp = 4.dp,
    private val barColor: Color = Color(0xFF5C5C5C),
) : ChartDrawer {

    private val barPainter = Paint().apply {
        this.color = barColor
        this.style = PaintingStyle.Fill
        this.isAntiAlias = true
    }

    override fun drawChart(
        canvas: Canvas,
        drawScope: DrawScope,
        chartProcessor: ChartProcessor,
        tapOffset: Offset?,
        pointerOffset: Offset?,
        onDrawSelectionMarker: (offset: Offset, index: Int) -> Unit,
    ) = with(drawScope) {
        val optimalWidth = if (barWidth.toPx() > chartProcessor.maxItemWidth)
            chartProcessor.maxItemWidth else barWidth.toPx()
        val halfWidth = optimalWidth / 2
        val topRadius = barRadius.toPx()
        val cornerRadius = CornerRadius(topRadius, topRadius)

        drawSelectionMarker(canvas, chartProcessor, pointerOffset, true)

        val offsets = if (chartProcessor.focusIndex == CHART_INDEX_0) chartProcessor.offsets0
        else chartProcessor.offsets1
        offsets?.forEachIndexed { index, offset ->
            if (offset == null) return@forEachIndexed

            tapOffset.checkSelection(offset, halfWidth, index, onDrawSelectionMarker)

            val rect = Rect(
                topLeft = Offset(offset.x - halfWidth, offset.y),
                bottomRight = Offset(offset.x + halfWidth, chartProcessor.dyBaseLine)
            )
            val roundRect = RoundRect(
                rect = rect,
                topLeft = cornerRadius,
                topRight = cornerRadius,
            )
            val path = Path().apply { addRoundRect(roundRect) }
            canvas.drawPath(path, barPainter)
        }

        return@with
    }
}