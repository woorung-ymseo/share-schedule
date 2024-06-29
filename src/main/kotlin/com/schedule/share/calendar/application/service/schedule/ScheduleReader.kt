package com.schedule.share.calendar.application.service.schedule

import com.schedule.share.calendar.application.port.inbound.ScheduleQuery
import com.schedule.share.calendar.application.port.outbound.ScheduleQueryPort
import com.schedule.share.calendar.application.service.schedule.vo.ScheduleVO
import com.schedule.share.calendar.domain.mapper.toVO
import org.springframework.stereotype.Component

@Component
class ScheduleReader(
    private val scheduleQueryPort: ScheduleQueryPort,
) : ScheduleQuery {

    override fun get(
        id: Long
    ): ScheduleVO.Schedule = scheduleQueryPort.findById(id).toVO()

    override fun list(): List<ScheduleVO.Schedule> = scheduleQueryPort.findAll().map { it.toVO() }
}