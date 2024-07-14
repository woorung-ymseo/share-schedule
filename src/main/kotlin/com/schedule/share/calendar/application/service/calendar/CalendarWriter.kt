package com.schedule.share.calendar.application.service.calendar

import com.schedule.share.calendar.application.port.inbound.CalendarCommand
import com.schedule.share.calendar.application.port.outbound.CalendarCommandPort
import com.schedule.share.calendar.application.service.calendar.vo.CalendarVO
import com.schedule.share.calendar.domain.mapper.toDomain
import org.springframework.stereotype.Component

@Component
class CalendarWriter(
    private val calendarCommandPort: CalendarCommandPort,
) : CalendarCommand {
    override fun create(param: CalendarVO.Save): Long {
        return calendarCommandPort.create(param.toDomain())
    }

    override fun update(id: Long, param: CalendarVO.Save) {
        calendarCommandPort.update(param.toDomain(id))
    }

    override fun delete(id: Long) {
        calendarCommandPort.delete(id)
    }
}