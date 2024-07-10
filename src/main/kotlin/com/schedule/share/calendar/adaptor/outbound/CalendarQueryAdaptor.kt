package com.schedule.share.calendar.adaptor.outbound

import com.schedule.share.calendar.application.port.outbound.CalendarQueryPort
import com.schedule.share.calendar.application.port.outbound.ScheduleQueryPort
import com.schedule.share.calendar.domain.Calendar
import com.schedule.share.calendar.domain.Schedule
import com.schedule.share.calendar.domain.mapper.toDomain
import com.schedule.share.infra.rdb.repository.CalendarRepository
import com.schedule.share.infra.rdb.repository.ScheduleRepository
import org.springframework.stereotype.Component

@Component
class CalendarQueryAdaptor(
    private val calendarRepository: CalendarRepository
) : CalendarQueryPort {
    override fun findAll(): List<Calendar> {
        return calendarRepository.findAll()
            .map { it.toDomain() }
    }

    override fun findById(id: Long): Calendar {
        return calendarRepository.findById(id)
            .orElseThrow()
            .toDomain()
    }
}
