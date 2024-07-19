package com.schedule.share.calendar.application.port.inbound

import com.schedule.share.calendar.application.service.DomainQuery
import com.schedule.share.calendar.application.service.calendar.vo.CalendarVO

interface CalendarQuery : DomainQuery<CalendarVO.Calendar>
