package com.woogear.presentation.screen.category.example.timeline.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.woogear.presentation.R
import com.woogear.presentation.helper.format
import com.woogear.presentation.screen.category.example.timeline.TimeLineCardPosition
import com.woogear.presentation.screen.category.example.timeline.TimelineFeedback
import com.woogear.presentation.screen.category.example.timeline.color
import com.woogear.presentation.screen.category.example.timeline.model.TimeLineItem
import com.woogear.presentation.theme.paletteGray700
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun TimelineContainer(
    modifier: Modifier = Modifier,
    contentHeight: Dp = 104.dp,
    data: TimeLineItem,
    cardPosition: TimeLineCardPosition,
    showDayOfMonth: Boolean = false,
    isSelectable: Boolean = false,
    isSelected: Boolean = false,
    showVerticalLine: Boolean = false,
) {
    Row(
        modifier = modifier.height(contentHeight),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TimeLineDateAndDayOfWeek(
            data,
            showDayOfMonth
        )
        TimeLinePointerAndVerticalLine(
            data,
            contentHeight,
            cardPosition,
            isSelectable,
            isSelected,
            showVerticalLine = showVerticalLine,
        )
        TimelineBody(data = data, isSelected = isSelected)
    }
}

@Composable
private fun TimeLineDateAndDayOfWeek(
    data: TimeLineItem,
    showDayOfMonth: Boolean,
) {
    Spacer(modifier = Modifier.width(11.dp))
    Column(
        modifier = Modifier.width(33.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showDayOfMonth) {
            Text(
                text = data.measuredAt.format("dd"),
                style = MaterialTheme.typography.h5
            )
            Text(
                text = data.measuredAt.run {
                    val localDate = LocalDateTime
                        .ofInstant(this, ZoneId.systemDefault())
                        .toLocalDate()

                    localDate.dayOfWeek.getDisplayName(
                        TextStyle.SHORT,
                        Locale.KOREA
                    )
                },
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
private fun TimeLinePointerAndVerticalLine(
    data: TimeLineItem,
    contentsHeight: Dp,
    cardPosition: TimeLineCardPosition,
    isSelectable: Boolean,
    isSelected: Boolean,
    showVerticalLine: Boolean,
) {
    BoxWithConstraints(
        modifier = Modifier
            .width(30.dp)
            .height(contentsHeight)
    ) {
        if (showVerticalLine) {
            TimeLineVerticalRope(
                contentsHeight = contentsHeight,
                cardPosition = cardPosition,
            )
        }

        TimeLinePointer(
            isSelected = isSelected,
            pointerState = data.feedback,
            isSelectable = isSelectable
        )
    }
}

@Composable
private fun BoxWithConstraintsScope.TimeLinePointer(
    pointerState: TimelineFeedback,
    isSelectable: Boolean,
    isSelected: Boolean,
) {
    if (isSelectable) {
        SelectablePointer(isSelected = isSelected)
        return
    }

    DefaultPointer(pointerState = pointerState)
}

@Composable
private fun BoxWithConstraintsScope.SelectablePointer(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
) {
    Box(
        modifier = modifier
            .align(Alignment.Center)
            .background(Color.White)
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_check_round_selected),
            tint = if (isSelected) MaterialTheme.colors.primary else paletteGray700,
            contentDescription = null,
        )
    }
}

@Composable
private fun BoxWithConstraintsScope.DefaultPointer(
    modifier: Modifier = Modifier,
    pointerState: TimelineFeedback,
) {
    val shape = RoundedCornerShape(4.dp)

    Box(
        modifier = modifier
            .align(Alignment.Center)
            .size(14.dp)
            .clip(shape)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .size(10.dp)
                .clip(shape)
                .background(pointerState.color())
        )
    }
}

@Composable
private fun BoxWithConstraintsScope.TimeLineVerticalRope(
    modifier: Modifier = Modifier,
    contentsHeight: Dp,
    cardPosition: TimeLineCardPosition,
) {
    Divider(
        modifier = modifier
            .width(2.dp)
            .height(getRopeHeight(contentsHeight, cardPosition))
            .align(getRopeAlignment(cardPosition)),
        color = paletteGray700
    )
}

private fun getRopeHeight(contentsHeight: Dp, cardPosition: TimeLineCardPosition): Dp {
    return when (cardPosition) {
        TimeLineCardPosition.MIDDLE -> contentsHeight
        else -> contentsHeight / 2
    }
}

private fun getRopeAlignment(cardPosition: TimeLineCardPosition): Alignment {
    return when (cardPosition) {
        TimeLineCardPosition.FIRST -> Alignment.BottomCenter
        TimeLineCardPosition.MIDDLE -> Alignment.Center
        TimeLineCardPosition.LAST -> Alignment.TopCenter
    }
}
