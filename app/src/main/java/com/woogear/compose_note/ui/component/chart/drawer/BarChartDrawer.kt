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
import com.woogear.compose_note.ui.component.chart.WooChartHelper
import com.woogear.compose_note.ui.component.chart.drawer.WooChartDrawer.Companion.CHART_INDEX_0

class BarChartDrawer(
    private val barWidth: Dp = 10.dp,
    private val barColor: Color = Color(0xFF5C5C5C),
) : WooChartDrawer {

    private val barPainter = Paint().apply {
        this.color = barColor
        this.style = PaintingStyle.Fill
        this.isAntiAlias = true
    }

    override fun drawChart(
        canvas: Canvas,
        drawScope: DrawScope,
        chartHelper: WooChartHelper,
        tapOffset: Offset?,
        pointerOffset: Offset?,
        onDrawSelectionMarker: (offset: Offset, index: Int) -> Unit,
    ) = with(drawScope) {
        val halfWidth = barWidth.toPx() / 2
        val topRadius = 4.dp.toPx()
        val cornerRadius = CornerRadius(topRadius, topRadius)

        drawSelectionMarker(canvas, chartHelper, pointerOffset, true)

        val offsets = if (chartHelper.focusIndex == CHART_INDEX_0) chartHelper.offsets0
        else chartHelper.offsets1
        offsets?.forEachIndexed { index, offset ->
            if (offset == null) return@forEachIndexed

            tapOffset.checkSelection(offset, halfWidth, index, onDrawSelectionMarker)

            val rect = Rect(
                topLeft = Offset(offset.x - halfWidth, offset.y),
                bottomRight = Offset(offset.x + halfWidth, chartHelper.dyBaseLine)
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