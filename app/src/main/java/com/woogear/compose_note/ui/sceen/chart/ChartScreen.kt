package com.woogear.compose_note.ui.sceen.chart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.woogear.compose_note.ui.component.chart.WooChart
import com.woogear.compose_note.ui.component.chart.WooChartData
import com.woogear.compose_note.ui.component.chart.WooChartDuration
import com.woogear.compose_note.ui.component.chart.drawer.BarChartDrawer
import com.woogear.compose_note.ui.component.chart.drawer.FloatingBarChartDrawer
import com.woogear.compose_note.ui.component.chart.drawer.WooChartDrawer
import com.woogear.compose_note.ui.component.chart.drawer.LineChartDrawer

@Composable
fun ChartScreen(
    viewModel: ChartViewModel,
    onClickExit: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onClickExit.invoke() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = { Text(text = "Chart") }
            )
        },
    ) {
        LineChartScreenContent(
            modifier = Modifier.padding(it),
            data = viewModel.chartData,
            duration = viewModel.duration,
            onDurationChanged = viewModel::updateDuration
        )
    }
}

@Composable
private fun LineChartScreenContent(
    modifier: Modifier = Modifier,
    data: WooChartData,
    duration: WooChartDuration,
    onDurationChanged: (WooChartDuration) -> Unit,
) {
    var focusIndex by remember { mutableStateOf(WooChartDrawer.CHART_INDEX_0) }
    var drawer by remember { mutableStateOf<WooChartDrawer>(LineChartDrawer()) }

    Column(
        modifier = modifier.padding(10.dp)
    ) {
        LineChartRow(focusIndex, drawer, duration, data)
        FocusButtons(onFocusChanged = { focusIndex = it })
        Spacer(modifier = Modifier.height(30.dp))
        DrawerButtons(data, onDrawerChanged = { drawer = it })
        Spacer(modifier = Modifier.height(30.dp))
        DurationButtons(onDurationChanged = onDurationChanged)
    }
}


@Composable
private fun LineChartRow(
    focusIndex: Int,
    drawer: WooChartDrawer,
    duration: WooChartDuration,
    chartData: WooChartData
) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        WooChart(
            chartData = chartData,
            duration = duration,
            chartDrawer = drawer,
            focusIndex = focusIndex
        )
    }
}

@Composable
private fun FocusButtons(onFocusChanged: (Int) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = { onFocusChanged.invoke(WooChartDrawer.CHART_INDEX_0) },
        ) {
            Text("FOCUS 1")
        }
        Button(
            modifier = Modifier.padding(start = 20.dp),
            onClick = { onFocusChanged.invoke(WooChartDrawer.CHART_INDEX_1) },
        ) {
            Text("FOCUS 2")
        }
    }
}

@Composable
private fun DrawerButtons(
    chartData: WooChartData,
    onDrawerChanged: (WooChartDrawer) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        Button(
            onClick = { onDrawerChanged.invoke(LineChartDrawer()) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF91ADFF))
        ) {
            Text("LineChartDrawer")
        }
        Button(
            onClick = { onDrawerChanged.invoke(BarChartDrawer()) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF91ADFF))
        ) {
            Text("BarChartDrawer")
        }
        if (chartData.hasDoubleValue) {
            Button(
                onClick = { onDrawerChanged.invoke(FloatingBarChartDrawer()) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF91ADFF))
            ) {
                Text("FloatingBarChartDrawer")
            }
        }
    }
}

@Composable
private fun DurationButtons(onDurationChanged: (WooChartDuration) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1FFA4)),
            onClick = { onDurationChanged.invoke(WooChartDuration.WEEK) },
        ) {
            Text("WEEK")
        }
        Button(
            modifier = Modifier.padding(start = 10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1FFA4)),
            onClick = { onDurationChanged.invoke(WooChartDuration.MONTH) },
        ) {
            Text("MONTH")
        }
        Button(
            modifier = Modifier.padding(start = 10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA1FFA4)),
            onClick = { onDurationChanged.invoke(WooChartDuration.SIX_MONTHS) },
        ) {
            Text("6_MONTHS")
        }
    }
}