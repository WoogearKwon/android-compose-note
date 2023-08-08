package com.woogear.presentation.component.chart

data class ChartData(
    val points: List<ChartPoint>,
) {
    val maxValue: Float
    val minValue: Float
    val range: Float
    val rangeRatio: Float
    val hasDoubleValue: Boolean
    val isFirstValueEmpty: Boolean
    val isSecondValueEmpty: Boolean

    init {
        val values = points.map { it.value }
        val values2 = points.map { it.value2 }
        val maxValue1 = values.maxByOrNull { it ?: 0f }
        val minValue1 = values.minOrNull()
            isFirstValueEmpty = maxValue1 == null
        val maxValue2: Float? = values2.maxByOrNull { it ?: 0f }
        val minValue2: Float? = values2.minOrNull()
        isSecondValueEmpty = maxValue2 == null

        maxValue = getMaxValueOf(maxValue1, maxValue2)
        minValue = getMinValueOf(minValue1, minValue2)
        range = maxValue - minValue
        rangeRatio = minValue / maxValue
        hasDoubleValue = maxValue2 != null
    }

    private fun getMaxValueOf(maxValue1: Float?, maxValue2: Float?): Float {
        if (maxValue1 != null && maxValue2 != null) {
            return maxOf(maxValue1, maxValue2)
        }

        return (maxValue1 ?: maxValue2) ?: 0f
    }

    private fun getMinValueOf(minValue1: Float?, minValue2: Float?): Float {
        if (minValue1 != null && minValue2 != null) {
            return minOf(minValue1, minValue2)
        }

        return (minValue1 ?: minValue2) ?: 0f
    }

    companion object {
        val EMPTY = ChartData(listOf())
    }
}

data class ChartPoint(
    val value: Float? = null,
    val value2: Float? = null,
    val status: ChartStatus? = null,
    val label: String,
)

enum class ChartStatus(val score: Int) {
    GOOD(3),
    ALERT(2),
    BAD(1)
}

private fun <T : Comparable<T>> Iterable<T?>.minOrNull(): T? {
    val iterator = iterator()
    if (iterator.hasNext().not()) return null

    var minElem = iterator.next()
    if (iterator.hasNext().not()) return minElem

    do {
        val e = iterator.next()

        if (minElem != null && e != null) {
            if (minElem > e) {
                minElem = e
            }
            continue
        }

        if (e != null) {
            minElem = e
        }
    } while (iterator.hasNext())

    return minElem
}
