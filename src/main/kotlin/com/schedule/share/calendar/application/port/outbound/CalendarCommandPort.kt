package com.schedule.share.calendar.application.port.outbound

import com.schedule.share.calendar.domain.Calendar

interface CalendarCommandPort {
    fun create(param: Calendar): Long

    fun update(param: Calendar)

    fun delete(id: Long)
}
