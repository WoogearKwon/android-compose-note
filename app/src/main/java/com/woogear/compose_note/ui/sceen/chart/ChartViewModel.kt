package com.woogear.compose_note.ui.sceen.chart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.woogear.compose_note.ui.component.chart.ChartPoint
import com.woogear.compose_note.ui.component.chart.ChartData
import com.woogear.compose_note.ui.component.chart.ChartDuration

class ChartViewModel: ViewModel() {
    var chartData: ChartData by mutableStateOf(weekData)
    var duration: ChartDuration by mutableStateOf(ChartDuration.WEEK)

    fun updateDuration(duration: ChartDuration) {
        this.duration = duration
        chartData = when(duration) {
            ChartDuration.WEEK -> weekData
            ChartDuration.MONTH -> monthData
            ChartDuration.SIX_MONTHS -> sixMonthData
        }
    }

    companion object {
        private fun randomYValue(): Float = (100f * Math.random()).toFloat() + 75f

        var weekLabel = 1
        val weekData = ChartData(listOf(
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
            ChartPoint(value = randomYValue(), label = (weekLabel++).toString()),
        ))

        var monthLabel = 1
        val monthData = ChartData(listOf(
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
        val sixMonthData = ChartData(listOf(
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