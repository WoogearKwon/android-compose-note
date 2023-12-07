package com.woogear.presentation.helper

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Instant.format(
    formatString: String,
    zoneId: ZoneId = ZoneId.systemDefault(),
): String {
    return toLocalDateTime(zoneId)
        .format(DateTimeFormatter.ofPattern(formatString))
}

fun Instant.toLocalDateTime(
    zoneId: ZoneId = ZoneId.systemDefault(),
): LocalDateTime {
    return LocalDateTime.ofInstant(this, zoneId)
}

fun Instant.isSameDay(
    other: Instant,
    zoneId: ZoneId = ZoneId.systemDefault(),
): Boolean {
    return LocalDateTime.ofInstant(this, zoneId).toLocalDate() ==
            LocalDateTime.ofInstant(other, zoneId).toLocalDate()
}

fun LocalDate.formatString(format: String): String {
    val dateFormatter = DateTimeFormatter.ofPattern(format)
    return this.format(dateFormatter)
}

fun LocalTime.formatString(format: String): String {
    val timeFormatter = DateTimeFormatter.ofPattern(format)
    return this.format(timeFormatter)
}
