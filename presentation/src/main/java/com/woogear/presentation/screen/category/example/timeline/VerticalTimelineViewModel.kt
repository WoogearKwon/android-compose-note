package com.woogear.presentation.screen.category.example.timeline

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.woogear.presentation.screen.category.example.timeline.model.TimeLineItem
import com.woogear.presentation.theme.paletteGray700
import com.woogear.presentation.theme.paletteGreen100
import com.woogear.presentation.theme.paletteOrange100
import com.woogear.presentation.theme.paletteRed200
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.Instant

class VerticalTimelineViewModel : ViewModel() {
    private val editModeFlow = MutableStateFlow(TimelineEditMode.DEFAULT)
    private val selectedLogIdsFlow = MutableStateFlow<Set<Long>>(setOf())
    val uiState: StateFlow<TimelineUiState> = combine(
        editModeFlow,
        selectedLogIdsFlow,
    ) { editMode, selectedLogIds ->
        TimelineUiState(
            editMode = editMode,
            selectedTimelineIds = selectedLogIds,
            items = timelineItems
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = TimelineUiState()
    )

    fun changeEditMode(mode: TimelineEditMode) = viewModelScope.launch {
        if (mode == TimelineEditMode.DEFAULT) {
            selectedLogIdsFlow.emit(emptySet())
        }

        editModeFlow.emit(mode)
    }

    fun changeSelectionStateOf(id: Long, isSelected: Boolean) = viewModelScope.launch {
        val idsSet = mutableSetOf<Long>().apply {
            addAll(selectedLogIdsFlow.value)

            if (isSelected) add(id) else remove(id)
        }

        selectedLogIdsFlow.emit(idsSet)
    }
}

data class TimelineUiState(
    val editMode: TimelineEditMode = TimelineEditMode.DEFAULT,
    val selectedTimelineIds: Set<Long> = setOf(),
    val items: List<TimeLineItem> = emptyList(),
)

enum class TimelineEditMode {
    DEFAULT,
    SELECT;

    fun isDelete() = this == SELECT
}

enum class TimeLineCardPosition {
    FIRST,
    MIDDLE,
    LAST
}

enum class TimelineFeedback {
    DEFAULT,
    GOOD,
    WARNING,
    BAD;
}

@Composable
fun TimelineFeedback.color(): Color {
    return when (this) {
        TimelineFeedback.DEFAULT -> paletteGray700
        TimelineFeedback.GOOD -> paletteGreen100
        TimelineFeedback.WARNING -> paletteOrange100
        TimelineFeedback.BAD -> paletteRed200
    }
}

private val timelineItems = listOf(
    TimeLineItem(
        id = 1,
        measuredAt = Instant.parse("2023-06-15T01:06:45.549Z"),
        value = 77,
        unit = "unit",
        feedback = TimelineFeedback.GOOD,
    ),
    TimeLineItem(
        id = 2,
        measuredAt = Instant.parse("2023-06-15T01:06:45.549Z"),
        value = 18,
        unit = "unit",
        feedback = TimelineFeedback.WARNING,
    ),
    TimeLineItem(
        id = 3,
        measuredAt = Instant.parse("2023-05-24T01:06:45.549Z"),
        value = 219,
        unit = "unit",
        feedback = TimelineFeedback.BAD,
    ),
    TimeLineItem(
        id = 4,
        measuredAt = Instant.parse("2023-05-24T01:06:45.549Z"),
        value = 134,
        unit = "unit",
        feedback = TimelineFeedback.GOOD,
    ),
    TimeLineItem(
        id = 5,
        measuredAt = Instant.parse("2023-05-24T01:06:45.549Z"),
        value = 48,
        unit = "unit",
        feedback = TimelineFeedback.GOOD,
    ),
    TimeLineItem(
        id = 6,
        measuredAt = Instant.parse("2023-05-24T01:06:45.549Z"),
        value = 19,
        unit = "unit",
        feedback = TimelineFeedback.WARNING,
    ),
    TimeLineItem(
        id = 7,
        measuredAt = Instant.parse("2023-04-19T01:06:45.549Z"),
        value = 294,
        unit = "unit",
        feedback = TimelineFeedback.BAD,
    ),
    TimeLineItem(
        id = 8,
        measuredAt = Instant.parse("2023-04-19T01:06:45.549Z"),
        value = 134,
        unit = "unit",
        feedback = TimelineFeedback.GOOD,
    ),
)