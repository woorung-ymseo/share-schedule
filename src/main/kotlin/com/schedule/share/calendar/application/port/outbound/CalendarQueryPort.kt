package com.schedule.share.calendar.application.port.outbound

import com.schedule.share.calendar.domain.Calendar

interface CalendarQueryPort {
    fun findAll(): List<Calendar>

    fun findById(id: Long): Calendar
}
