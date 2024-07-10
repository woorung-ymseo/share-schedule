package com.schedule.share.calendar.application.service.calendar

import com.schedule.share.calendar.application.port.inbound.CalendarQuery
import com.schedule.share.calendar.application.port.inbound.ScheduleQuery
import com.schedule.share.calendar.application.port.outbound.CalendarQueryPort
import com.schedule.share.calendar.application.port.outbound.ScheduleQueryPort
import com.schedule.share.calendar.application.service.calendar.vo.CalendarVO
import com.schedule.share.calendar.application.service.schedule.vo.ScheduleVO
import com.schedule.share.calendar.domain.mapper.toVO
import org.springframework.stereotype.Component

@Component
class CalendarReader(
    private val calendarQueryPort: CalendarQueryPort,
) : CalendarQuery {

    override fun get(
        id: Long
    ): CalendarVO.Calendar = calendarQueryPort.findById(id).toVO()

    override fun list(): List<CalendarVO.Calendar> = calendarQueryPort.findAll().map { it.toVO() }
}