package com.schedule.share.application.calendar.application.port.outbound

import com.schedule.share.application.calendar.domain.Schedule

interface ScheduleCommandPort {
    fun create(param: Schedule): Long

    fun update(param: Schedule)

    fun delete(id: Long)
}
