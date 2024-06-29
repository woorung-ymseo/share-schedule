package com.schedule.share.application.calendar.application.port.inbound

import com.schedule.share.application.calendar.application.service.DomainCommand
import com.schedule.share.application.calendar.application.service.schedule.vo.ScheduleVO

interface ScheduleCommand : DomainCommand<ScheduleVO.Save>
