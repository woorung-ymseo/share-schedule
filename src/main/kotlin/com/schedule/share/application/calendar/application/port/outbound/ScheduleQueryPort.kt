package com.schedule.share.application.calendar.application.port.outbound

import com.schedule.share.application.calendar.domain.Schedule

interface ScheduleQueryPort {
    fun findAll(): List<Schedule>

    fun findById(id: Long): Schedule
}
