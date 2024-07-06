package com.schedule.share.calendar.adaptor.inbound.api.dto

import java.time.LocalDateTime

class ScheduleResponseDTO {

    data class Response(
        val id: Long,
        val calendarId: Long,
        val userId: Long,
        val title: String,
        val isAllday: Boolean = false,
        val startDatetime: LocalDateTime,
        val endDatetime: LocalDateTime,
        val content: String? = null,
        val location: String? = null,
        val createdAt: LocalDateTime,
        val modifiedAt: LocalDateTime,
    )
}