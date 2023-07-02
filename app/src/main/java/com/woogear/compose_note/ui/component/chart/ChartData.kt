package com.woogear.compose_note.ui.component.chart

data class ChartData(
    val points: List<ChartPoint>,
) {
    val maxValue: Float
    val minValue: Float
    val range: Float
    val rangeRatio: Float
    val hasDoubleValue: Boolean

    init {
        require(points.isNotEmpty()) { "Points should have at least one item. But it's empty" }

        val values = points.map { it.value }
        val values2 = points.map { it.value2 }
        val maxValue1 = values.maxByOrNull { it ?: 0f }
            ?: throw IllegalStateException("All items are null")
        val minValue1 = values.minOrNull()
            ?: throw IllegalStateException("All items are null")
        val maxValue2: Float? = values2.maxByOrNull { it ?: 0f }
        val minValue2: Float? = values2.minOrNull()

        maxValue = if (maxValue2 == null) maxValue1 else maxOf(maxValue1, maxValue2)
        minValue = if (minValue2 == null) minValue1 else minOf(minValue1, minValue2)
        range = maxValue - minValue
        rangeRatio = minValue / maxValue
        hasDoubleValue = maxValue2 != null

        println("woogear max = $maxValue :: min = $minValue")
    }
}

data class ChartPoint(
    val value: Float? = null,
    val value2: Float? = null,
    val label: String,
)

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
