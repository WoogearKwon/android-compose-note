package com.woogear.compose_note.ui.component.chart

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import com.woogear.compose_note.ui.component.chart.drawer.WooChartDrawer.Companion.CHART_INDEX_0

data class WooChartHelper(
    val chartSize: Size,
    val duration: WooChartDuration,
    val chartData: WooChartData,
) {
    val dyBaseLine: Float = chartSize.height * BASE_LINE_RATIO
    val labels = mutableListOf<WooChartLabel>()
    val offsets0: List<Offset?>
    val offsets1: MutableList<Offset?>?

    private val maxValue: Float
    private val rangeRatio: Float
    private val valueRange: Float

    init {
        offsets0 = mutableListOf()
        offsets1 = if (chartData.hasDoubleValue) mutableListOf() else null
        maxValue = chartData.maxValue
        rangeRatio = chartData.rangeRatio
        valueRange = chartData.range

        val horizontalMargin = chartSize.width * HORIZONTAL_MARGIN_RATIO
        val totalMargin = horizontalMargin * 2
        val labelDistance = (chartSize.width - totalMargin) / (duration.labelsPerPage - 1)

        for (i in 0 until duration.labelsPerPage) {
            val dx = labelDistance * i + horizontalMargin
            val index = i * duration.valueInterval
            val name = chartData.points[index].label
            labels.add(WooChartLabel(dx, name))
        }

        val drawableHeight = dyBaseLine * chartData.rangeRatio
        val dyMax = (dyBaseLine - drawableHeight) / 2
        val valueDistance = (chartSize.width - totalMargin) / (duration.valuesPerPage - 1)

        chartData.points.forEachIndexed { index, chartPoint ->
            val dx = horizontalMargin + (valueDistance * index)

            if (chartPoint.value != null) {
                val ratio = (chartData.maxValue - chartPoint.value) / chartData.range
                val dy = dyMax + (drawableHeight * ratio)
                offsets0.add(Offset(dx, dy))
            } else {
                offsets0.add(null)
            }

            if (offsets1 == null) return@forEachIndexed
            if (chartPoint.value2 != null) {
                val ratio = (chartData.maxValue - chartPoint.value2) / chartData.range
                val dy = dyMax + (drawableHeight * ratio)
                offsets1.add(Offset(dx, dy))
            } else {
                offsets1.add(null)
            }
        }
    }

    var focusIndex: Int = CHART_INDEX_0
        private set

    fun setFocusIndex(index: Int) {
        focusIndex = index
    }

    fun calculatePaths(offsets: List<Offset?>): Pair<Path, Path> {
        val baseLine: Float = dyBaseLine

        val linePath = Path()
        val shaderPath = Path()
        val firstOffset = offsets.firstNotNullOf { it }
        val firstItemIndex = offsets.indexOfFirst { it != null }

        shaderPath.moveTo(firstOffset.x, baseLine)

        offsets.forEachIndexed { index, offset ->
            if (offset == null) return@forEachIndexed

            shaderPath.lineTo(offset.x, offset.y)

            if (index == firstItemIndex) {
                linePath.moveTo(offset.x, offset.y)
            } else {
                linePath.lineTo(offset.x, offset.y)
            }
        }

        val lastOffset = offsets.lastNotNull { it }
        shaderPath.lineTo(lastOffset.x, baseLine)

        return linePath to shaderPath
    }

    fun getDyFrom(value: Float): Float {
        val drawableHeight = dyBaseLine * rangeRatio
        val dyMax = (dyBaseLine - drawableHeight) / 2
        val ratio = (maxValue - value) / valueRange

        return dyMax + (drawableHeight * ratio)
    }

    private fun <T, R : Any> Iterable<T>.lastNotNull(transform: (T) -> R?): R {
        var last: R? = null
        for (element in this) {
            val result = transform(element)
            if (result != null) {
                last = result
            }
        }

        return last ?: throw IllegalStateException(
            "No element of the collection was transformed to a non-null value."
        )
    }

    companion object {
        private const val BASE_LINE_RATIO = 0.9f
        private const val HORIZONTAL_MARGIN_RATIO = 0.08f
    }
}

data class WooChartLabel(
    val dx: Float,
    val name: String,
)

enum class WooChartDuration(
    val valuesPerPage: Int,
    val labelsPerPage: Int,
    val pageCount: Int,
) {
    WEEK(7, 7, 4),
    MONTH(29, 5, 6),
    SIX_MONTHS(25, 7, 4);

    val valueInterval: Int
        get() {
            return when (this) {
                WEEK -> valuesPerPage / labelsPerPage
                else -> (valuesPerPage - 1) / (labelsPerPage - 1)
            }
        }
}