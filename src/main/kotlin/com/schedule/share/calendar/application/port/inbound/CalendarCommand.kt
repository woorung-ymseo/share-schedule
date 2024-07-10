package com.schedule.share.calendar.application.port.inbound

import com.schedule.share.calendar.application.service.DomainCommand
import com.schedule.share.calendar.application.service.calendar.vo.CalendarVO
import com.schedule.share.calendar.application.service.schedule.vo.ScheduleVO

interface CalendarCommand : DomainCommand<CalendarVO.Save>
