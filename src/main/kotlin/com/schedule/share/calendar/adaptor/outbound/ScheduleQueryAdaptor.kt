package com.schedule.share.calendar.adaptor.outbound

import com.schedule.share.calendar.application.port.outbound.ScheduleQueryPort
import com.schedule.share.calendar.domain.Schedule
import com.schedule.share.calendar.domain.mapper.toDomain
import com.schedule.share.infra.rdb.repository.ScheduleRepository
import org.springframework.stereotype.Component

@Component
class ScheduleQueryAdaptor(
    private val scheduleRepository: ScheduleRepository
) : ScheduleQueryPort {
    override fun findAll(): List<Schedule> {
        return scheduleRepository.findAll()
            .map { it.toDomain() }
    }

    override fun findById(id: Long): Schedule {
        return scheduleRepository.findById(id)
            .orElseThrow()
            .toDomain()
    }
}
