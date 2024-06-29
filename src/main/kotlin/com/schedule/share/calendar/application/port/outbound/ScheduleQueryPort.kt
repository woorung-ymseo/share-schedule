package com.schedule.share.calendar.application.port.outbound

import com.schedule.share.calendar.domain.Schedule

interface ScheduleQueryPort {
    fun findAll(): List<Schedule>

    fun findById(id: Long): Schedule
}
