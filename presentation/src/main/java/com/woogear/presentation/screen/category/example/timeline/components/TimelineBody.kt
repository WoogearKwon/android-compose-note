package com.woogear.presentation.screen.category.example.timeline.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.woogear.presentation.helper.format
import com.woogear.presentation.screen.category.example.timeline.model.TimeLineItem
import com.woogear.presentation.theme.paletteGray100
import com.woogear.presentation.theme.paletteGray500

@Composable
fun TimelineBody(
    modifier: Modifier = Modifier,
    data: TimeLineItem,
    isSelected: Boolean,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 4.dp)
            .padding(end = 12.dp)
            .clip(shape = RoundedCornerShape(corner = CornerSize(size = 30f)))
            .background(color = if (isSelected) MaterialTheme.colors.primary else paletteGray500)
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = data.measuredAt.format(TimeLineBodyFormats.TIME),
                    color = if (isSelected) Color.White.copy(alpha = 0.8f) else paletteGray100,
                    style = MaterialTheme.typography.caption
                )
            }
            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth(),
                text = "Item",
                color = if (isSelected) Color.White else Color.Black,
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Row(
                modifier = Modifier.align(Alignment.BottomEnd),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.value.toString(),
                    color = if (isSelected) Color.White else Color.Black,
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = data.unit,
                    color = if (isSelected) Color.White.copy(alpha = 0.8f) else paletteGray100,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}

private object TimeLineBodyFormats {
    const val TIME = "a hh:mm"
}