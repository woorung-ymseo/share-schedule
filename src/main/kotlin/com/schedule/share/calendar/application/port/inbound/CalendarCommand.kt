package com.schedule.share.calendar.application.port.inbound

import com.schedule.share.calendar.application.service.DomainCommand
import com.schedule.share.calendar.application.service.calendar.vo.CalendarVO

interface CalendarCommand : DomainCommand<CalendarVO.Save>
