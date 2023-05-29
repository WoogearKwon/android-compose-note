package com.woogear.compose_note.ui.sceen.chart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.woogear.compose_note.ui.component.chart.ChartPoint
import com.woogear.compose_note.ui.component.chart.WooChartData
import com.woogear.compose_note.ui.component.chart.WooChartDuration

class ChartViewModel: ViewModel() {
    var chartData: WooChartData by mutableStateOf(weekData)
    var duration: WooChartDuration by mutableStateOf(WooChartDuration.WEEK)

    fun updateDuration(duration: WooChartDuration) {
        this.duration = duration
        chartData = when(duration) {
            WooChartDuration.WEEK -> weekData
            WooChartDuration.MONTH -> monthData
            WooChartDuration.SIX_MONTHS -> sixMonthData
        }
    }

    companion object {
        private fun randomYValue(): Float = (100f * Math.random()).toFloat() + 75f

        var weekLabel = 1
        val weekData = WooChartData(listOf(
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
        ))

        var monthLabel = 1
        val monthData = WooChartData(listOf(
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (monthLabel++).toString()),
        ))

        var sixMonthsLabel = 1
        val sixMonthData = WooChartData(listOf(
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
            ChartPoint(value = randomYValue(), value2 = randomYValue(), label = (sixMonthsLabel++).toString()),
        ))
    }

}