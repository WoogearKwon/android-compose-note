package com.woogear.compose_note.ui.component.chart.drawer

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woogear.compose_note.ui.component.chart.ChartProcessor

interface ChartDrawer {

    fun drawLabelGroup(
        canvas: Canvas,
        drawScope: DrawScope,
        chartHelper: ChartProcessor,
        lineWidth: Dp = 1.dp,
        lineColor: Color = Color(0xFFF5F5F5),
    ) {
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f, 10f), 0f)

        with(drawScope) {
            val textPaint = android.graphics.Paint().apply {
                isAntiAlias = true
                textSize = 14.sp.toPx()
                textAlign = android.graphics.Paint.Align.CENTER
            }

            chartHelper.labels.forEach { label ->
                val dy = chartHelper.dyBaseLine
                drawLine(
                    start = Offset(label.dx, 0f),
                    end = Offset(label.dx, dy),
                    color = lineColor,
                    strokeWidth = lineWidth.toPx(),
                    pathEffect = pathEffect
                )

                canvas.nativeCanvas.drawText(label.name, label.dx, size.height, textPaint)
            }
        }
    }

    fun drawDangerArea(
        drawScope: DrawScope,
        canvas: Canvas,
        chartHelper: ChartProcessor,
        areaRadius: Dp = 8.dp,
        areaColor: Color = Color(0xFFFAFAFA),
        safeLimitHigh: Float? = null,
        safeLimitLow: Float? = null,
    ) = with(drawScope) {
        if (safeLimitHigh == null) return
        val radius = areaRadius.toPx()
        val paint = Paint().apply {
            color = areaColor
        }

        val dySafeLimitHigh = chartHelper.getDyFrom(safeLimitHigh)
        if (dySafeLimitHigh > 0f) {
            canvas.drawRoundRect(
                left = 0f,
                right = chartHelper.chartSize.width,
                top = 0f,
                bottom = dySafeLimitHigh,
                radiusX = radius,
                radiusY = radius,
                paint = paint
            )
        }

        if (safeLimitLow == null) return
        val dyBaseLine = chartHelper.dyBaseLine
        val dySafeLimitLow = chartHelper.getDyFrom(safeLimitLow)
        if (dySafeLimitLow > dyBaseLine) return

        canvas.drawRoundRect(
            left = 0f,
            right = chartHelper.chartSize.width,
            top = dySafeLimitLow,
            bottom = chartHelper.dyBaseLine,
            radiusX = radius,
            radiusY = radius,
            paint = paint
        )
    }

    fun DrawScope.drawSelectionMarker(
        canvas: Canvas,
        chartHelper: ChartProcessor,
        pointerOffset: Offset?,
        isFocused: Boolean,
        markerWidth: Dp = 2.dp,
    ) = with(this) {
        if (isFocused.not() || pointerOffset == null) return

        val paint = Paint().apply {
            isAntiAlias = true
            color = Color.Black
            style = PaintingStyle.Stroke
            strokeWidth = markerWidth.toPx()
        }
        val p1 = Offset(pointerOffset.x, 0f)
        val p2 = Offset(pointerOffset.x, chartHelper.dyBaseLine)
        canvas.drawLine(p1, p2, paint)
    }

    fun drawChart(
        canvas: Canvas,
        drawScope: DrawScope,
        chartProcessor: ChartProcessor,
        tapOffset: Offset?,
        pointerOffset: Offset?,
        onDrawSelectionMarker: (offset: Offset, index: Int) -> Unit,
    )

    fun Offset?.checkSelection(
        centerOffset: Offset,
        xRange: Float,
        index: Int,
        onDrawSelectionMarker: (offset: Offset, index: Int) -> Unit,
    ) {
        if (this != null && isSelected(centerOffset.x, this.x, xRange)) {
            onDrawSelectionMarker.invoke(centerOffset, index)
        }
    }

    private fun isSelected(dx: Float, tapX: Float, xRange: Float): Boolean {
        return dx >= tapX - xRange && dx <= tapX + xRange
    }

    companion object {
        internal const val CHART_INDEX_0 = 0
        internal const val CHART_INDEX_1 = 1
    }
}