package com.woogear.presentation.component.chart

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import com.woogear.presentation.component.chart.drawer.ChartDrawer.Companion.CHART_INDEX_0

data class ChartProcessor(
    val chartSize: Size,
    val duration: ChartDuration,
    val chartData: ChartData,
) {
    val dyBaseLine: Float = chartSize.height * BASE_LINE_RATIO
    val labels = mutableListOf<ChartLabel>()
    val offsets0: MutableList<Offset?>? =
        if (chartData.isFirstValueEmpty) null else mutableListOf()
    val offsets1: MutableList<Offset?>? =
        if (chartData.isSecondValueEmpty) null else mutableListOf()
    val allDx = mutableListOf<Float>()
    val status = mutableListOf<ChartStatus?>()
    val maxItemWidth: Float

    private val maxValue: Float = chartData.maxValue
    private val rangeRatio: Float = chartData.rangeRatio
    private val valueRange: Float = chartData.range
    private val horizontalMargin = chartSize.width * HORIZONTAL_MARGIN_RATIO
    private val totalMargin = horizontalMargin * 2
    private val drawableWidth = chartSize.width - totalMargin

    init {
        maxItemWidth = (drawableWidth / duration.valuesPerPage) * 0.8f

        if (chartData != ChartData.EMPTY) {
            calculateLabelPositions()
            calculateOffsets()
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

    private fun calculateLabelPositions() {
        val labelDistance = (chartSize.width - totalMargin) / (duration.labelsPerPage - 1)

        for (i in 0 until duration.labelsPerPage) {
            val dx = labelDistance * i + horizontalMargin
            val index = i * duration.valueInterval
            val name = chartData.points[index].label
            labels.add(ChartLabel(dx, name))
        }
    }

    private fun calculateOffsets() {
        val drawableHeight = dyBaseLine * rangeRatio
        val dyMax = (dyBaseLine - drawableHeight) / 2
        val valueDistance = (chartSize.width - totalMargin) / (duration.valuesPerPage - 1)

        chartData.points.forEachIndexed { index, chartPoint ->
            val dx = horizontalMargin + (valueDistance * index)
            allDx.add(dx)
            status.add(chartPoint.status)

            if (offsets0 != null) {
                if (chartPoint.value != null) {
                    val ratio = (maxValue - chartPoint.value) / valueRange
                    val dy = dyMax + (drawableHeight * ratio)
                    offsets0.add(Offset(dx, dy))
                } else {
                    offsets0.add(null)
                }
            }

            if (offsets1 == null) return@forEachIndexed
            if (chartPoint.value2 != null) {
                val ratio = (maxValue - chartPoint.value2) / valueRange
                val dy = dyMax + (drawableHeight * ratio)
                offsets1.add(Offset(dx, dy))
            } else {
                offsets1.add(null)
            }
        }
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

data class ChartLabel(
    val dx: Float,
    val name: String,
)

enum class ChartDuration(
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