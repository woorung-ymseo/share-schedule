package com.schedule.share.calendar.adaptor.inbound.api.dto

import java.time.LocalDateTime

class ScheduleRequestDTO {

    data class Search(
        val title: String,
    )

    data class Schedule(
        val title: String,
        val isAllDay: Boolean = false,
        val startDatetime: LocalDateTime,
        val endDatetime: LocalDateTime,
        val content: String? = null,
        val location: String? = null,
    )
}