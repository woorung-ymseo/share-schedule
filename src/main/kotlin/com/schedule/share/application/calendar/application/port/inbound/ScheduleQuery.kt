package com.schedule.share.application.calendar.application.port.inbound

import com.schedule.share.application.calendar.application.service.DomainQuery
import com.schedule.share.application.calendar.application.service.schedule.vo.ScheduleVO

interface ScheduleQuery : DomainQuery<ScheduleVO.Schedule>
