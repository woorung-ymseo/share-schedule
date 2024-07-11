package com.schedule.share.calendar.adaptor.outbound

import com.schedule.share.calendar.application.port.outbound.CalendarCommandPort
import com.schedule.share.calendar.domain.Calendar
import com.schedule.share.calendar.domain.mapper.toEntity
import com.schedule.share.infra.rdb.repository.CalendarRepository
import org.springframework.stereotype.Component

@Component
class CalendarCommandAdaptor(
    private val calendarRepository: CalendarRepository
) : CalendarCommandPort {
    override fun create(param: Calendar): Long {
        return calendarRepository.save(param.toEntity()).id!!
    }

    override fun update(param: Calendar) {
        calendarRepository.save(param.toEntity())
    }
}