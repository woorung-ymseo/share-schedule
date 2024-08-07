package com.schedule.share.calendar.application.service.schedule

import com.schedule.share.calendar.application.port.outbound.ScheduleCommandPort
import com.schedule.share.calendar.application.port.outbound.ScheduleQueryPort
import org.springframework.stereotype.Component

@Component
class ScheduleService(
    private val scheduleQueryPort: ScheduleQueryPort,
    private val scheduleCommandPort: ScheduleCommandPort,
) {
}