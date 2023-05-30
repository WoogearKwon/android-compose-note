package com.woogear.compose_note.ui.component.chart.drawer

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.woogear.compose_note.ui.component.chart.WooChartHelper

class FloatingBarChartDrawer(
    private val barWidth: Dp = 10.dp,
    private val barRadius: Dp = 4.dp,
    private val colorSafe: Color = Color(0xFF66D758),
    private val colorAlert: Color = Color(0xFFFFB430),
    private val colorBad: Color = Color(0xFFEC5C5C),
) : WooChartDrawer {

    private val paint = Paint().apply {
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
        val optimalWidth = if (barWidth.toPx() > chartHelper.maxItemWidth)
            chartHelper.maxItemWidth else barWidth.toPx()
        val halfWidth = optimalWidth / 2
        val radius = barRadius.toPx()

        drawSelectionMarker(canvas, chartHelper, pointerOffset, true)

        val offsets1 = chartHelper.offsets0
        val offsets2 =
            chartHelper.offsets1 ?: throw IllegalStateException("offset2 should not be null")

        offsets1.forEachIndexed { index, offset ->
            if (offset == null) return@forEachIndexed
            if (offsets2[index] == null) return@forEachIndexed

            offsets2[index]?.let { offset2 ->
                if (offset.y > offset2.y) return@forEachIndexed
            }

            tapOffset.checkSelection(offset, halfWidth, index, onDrawSelectionMarker)

            val n = index % 3
            val color = when (n) {
                0 -> colorSafe
                1 -> colorAlert
                else -> colorBad
            }
            paint.color = color

            canvas.drawRoundRect(
                left = offset.x - halfWidth,
                top = offset.y,
                right = offset.x + halfWidth,
                bottom = offsets2[index]?.y ?: (offset.y * 1.3f),
                radiusX = radius,
                radiusY = radius,
                paint = paint
            )
        }
    }
}