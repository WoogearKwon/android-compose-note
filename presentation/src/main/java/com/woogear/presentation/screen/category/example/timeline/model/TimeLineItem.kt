package com.woogear.presentation.screen.category.example.timeline.model

import com.woogear.presentation.screen.category.example.timeline.TimelineFeedback
import java.time.Instant

data class TimeLineItem(
    val id: Long,
    val measuredAt: Instant,
    val value: Int,
    val unit: String,
    val feedback: TimelineFeedback,
)
