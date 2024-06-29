package com.schedule.share.calendar.application.port.outbound

import com.schedule.share.calendar.domain.Schedule

interface ScheduleCommandPort {
    fun create(param: Schedule): Long

    fun update(param: Schedule)

    fun delete(id: Long)
}
