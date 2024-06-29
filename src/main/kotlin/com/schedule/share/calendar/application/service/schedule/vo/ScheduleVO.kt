package com.schedule.share.calendar.application.service.schedule.vo

import java.time.LocalDateTime

class ScheduleVO {

    data class Schedule(
        val id: Long? = null,
        val calendarId: Long,
        val userId: Long,
        val title: String,
        val isAllDay: Boolean = false,
        val startDatetime: LocalDateTime,
        val endDatetime: LocalDateTime,
        val content: String? = null,
        val location: String? = null,
        val createdAt: LocalDateTime? = null,
        val modifiedAt: LocalDateTime? = null,
        val isDeleted: Boolean = false
    )

    data class Save(
        val calendarId: Long,
        val userId: Long,
        val title: String,
        val isAllDay: Boolean = false,
        val startDatetime: LocalDateTime,
        val endDatetime: LocalDateTime,
        val content: String? = null,
        val location: String? = null,
    )
}