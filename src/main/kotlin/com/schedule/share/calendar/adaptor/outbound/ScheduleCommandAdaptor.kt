package com.schedule.share.calendar.adaptor.outbound

import com.schedule.share.calendar.application.port.outbound.ScheduleCommandPort
import com.schedule.share.calendar.domain.Schedule
import com.schedule.share.calendar.domain.mapper.toEntity
import com.schedule.share.infra.rdb.repository.ScheduleRepository
import org.springframework.stereotype.Component

@Component
class ScheduleCommandAdaptor(
    private val scheduleRepository: ScheduleRepository
) : ScheduleCommandPort {
    override fun create(param: Schedule): Long {
        return scheduleRepository.save(param.toEntity()).id!!
    }

    override fun update(param: Schedule) {
        scheduleRepository.save(param.toEntity())
    }

    override fun delete(id: Long) {
        scheduleRepository.findById(id).orElseThrow().delete()
            .let {
                scheduleRepository.save(it)
            }
    }
}