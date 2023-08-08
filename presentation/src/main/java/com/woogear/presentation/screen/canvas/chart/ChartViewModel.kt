package com.woogear.presentation.screen.canvas.chart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.woogear.presentation.component.chart.ChartPoint
import com.woogear.presentation.component.chart.ChartData
import com.woogear.presentation.component.chart.ChartDuration
import com.woogear.presentation.component.chart.ChartStatus

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
        private fun random(): Float = (100f * Math.random()).toFloat() + 75f
        private fun randomStatus() = ChartStatus.values()[(0..2).random()]

        var weekLabel = 1
        val weekData = ChartData(listOf(
            ChartPoint(random(), null, randomStatus(), (weekLabel++).toString()),
            ChartPoint(random(), null, randomStatus(), (weekLabel++).toString()),
            ChartPoint(random(), null, randomStatus(), (weekLabel++).toString()),
            ChartPoint(random(), null, randomStatus(), (weekLabel++).toString()),
            ChartPoint(random(), null, randomStatus(), (weekLabel++).toString()),
            ChartPoint(random(), null, randomStatus(), (weekLabel++).toString()),
            ChartPoint(random(), null, randomStatus(), (weekLabel++).toString()),
        ))

        var monthLabel = 1
        val monthData = ChartData(listOf(
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (monthLabel++).toString()),
        ))

        var sixMonthsLabel = 1
        val sixMonthData = ChartData(listOf(
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
            ChartPoint(random(), random(), randomStatus(), (sixMonthsLabel++).toString()),
        ))
    }

}