package com.woogear.presentation.screen.category.example.timeline

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.woogear.presentation.R
import com.woogear.presentation.screen.category.example.timeline.components.TimelineContainer
import com.woogear.presentation.screen.category.example.timeline.model.TimeLineItem
import com.woogear.presentation.theme.paletteGray500
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun VerticalTimelineScreen(
    modifier: Modifier = Modifier,
    viewModel: VerticalTimelineViewModel,
    onClickExit: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { onClickExit.invoke() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                title = {
                    Text(text = stringResource(R.string.vertical_timeline_title))
                },
                actions = {
                    when (uiState.editMode) {
                        TimelineEditMode.DEFAULT -> {
                            ActionButton(
                                textRes = R.string.timeline_select,
                                contentColor = paletteGray500,
                                onClick = {
                                    viewModel.changeEditMode(TimelineEditMode.SELECT)
                                }
                            )
                        }

                        TimelineEditMode.SELECT -> {
                            ActionButton(
                                textRes = R.string.timeline_cancel,
                                contentColor = Color.Black,
                                onClick = {
                                    viewModel.changeEditMode(TimelineEditMode.DEFAULT)
                                }
                            )
                        }
                    }
                }
            )
        },
    ) {
        TimeLines(
            modifier = Modifier.padding(it),
            items = uiState.items,
            editMode = uiState.editMode,
            selectedLogIds = uiState.selectedTimelineIds,
            onSelectionChanged = viewModel::changeSelectionStateOf,
            onClickTimeLine = {}
        )
    }
}

@Composable
private fun ActionButton(
    textRes: Int,
    contentColor: Color,
    onClick: () -> Unit,
) {
    Text(
        modifier = Modifier
            .padding(all = 10.dp)
            .clickable { onClick() },
        text = stringResource(id = textRes),
        style = MaterialTheme.typography.h5.copy(
            color = contentColor
        )
    )
}

@Composable
private fun TimeLines(
    modifier: Modifier = Modifier,
    items: List<TimeLineItem>,
    editMode: TimelineEditMode,
    selectedLogIds: Set<Long>,
    onSelectionChanged: (id: Long, isSelected: Boolean) -> Unit,
    onClickTimeLine: (data: TimeLineItem) -> Unit,
) {
    val listState = rememberLazyListState()

    Column(
        modifier = modifier
    ) {
        TimeLineItems(
            listState = listState,
            items = items,
            editMode = editMode,
            selectedLogIds = selectedLogIds.toList(),
            onSelectionChanged = onSelectionChanged,
            onClickTimeLine = onClickTimeLine,
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TimeLineItems(
    listState: LazyListState,
    items: List<TimeLineItem>,
    editMode: TimelineEditMode,
    selectedLogIds: List<Long>,
    onSelectionChanged: (id: Long, isSelected: Boolean) -> Unit,
    onClickTimeLine: (data: TimeLineItem) -> Unit,
) {
    LazyColumn(state = listState) {
        val itemCount = items.size

        for (index in 0 until itemCount) {
            val lastLog = if (index == 0) null else items[index - 1]
            val log = items[index]
            val selectionState = selectedLogIds.contains(log.id)

            if (isMonthChanged(lastLog, log)) {
                stickyHeader {
                    TitleWithYearAndMonth(date = log.measuredAt.toLocalDateTime())
                }
            }

            item {
                TimelineContainer(
                    modifier = Modifier
                        .padding(bottom = if (index == itemCount - 1) 90.dp else 0.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = if (editMode.isDelete()) null else LocalIndication.current
                        ) {
                            if (editMode.isDelete()) {
                                onSelectionChanged.invoke(log.id, selectionState.not())
                                return@clickable
                            }

                            onClickTimeLine.invoke(log)
                        },
                    data = log,
                    cardPosition = getIndexState(index, itemCount - 1),
                    showDayOfMonth = items.dateChanged(index),
                    isSelected = selectionState,
                    isSelectable = editMode.isDelete(),
                    showVerticalLine = itemCount > 1,
                )
            }
        }
    }
}

private fun isMonthChanged(
    lastLog: TimeLineItem?,
    currentLog: TimeLineItem?,
): Boolean {
    val lastDate = lastLog?.measuredAt?.toLocalDateTime()?.toLocalDate() ?: return true
    val currentDate = currentLog?.measuredAt?.toLocalDateTime()?.toLocalDate()

    return if (lastDate.year != currentDate?.year) false
    else lastDate.month != currentDate.month
}

@Composable
private fun TitleWithYearAndMonth(modifier: Modifier = Modifier, date: LocalDateTime?) {
    if (date == null) return

    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 24.dp),
        text = date.format(DateTimeFormatter.ofPattern("yyyy.MM")),
        style = MaterialTheme.typography.h5
    )
}

private fun List<TimeLineItem>.dateChanged(index: Int): Boolean {
    if (index == 0) return true

    val prevDate = this[index - 1].measuredAt.toLocalDateTime()
    val currentDate = this[index].measuredAt.toLocalDateTime()

    return prevDate.year != currentDate.year ||
            prevDate.month != currentDate.month ||
            prevDate.dayOfMonth != currentDate.dayOfMonth
}

private fun getIndexState(index: Int, lastIndex: Int): TimeLineCardPosition {
    return when (index) {
        0 -> TimeLineCardPosition.FIRST
        lastIndex -> TimeLineCardPosition.LAST
        else -> TimeLineCardPosition.MIDDLE
    }
}

private fun Instant.toLocalDateTime(
    zoneId: ZoneId = ZoneId.systemDefault(),
): LocalDateTime {
    return LocalDateTime.ofInstant(this, zoneId)
}