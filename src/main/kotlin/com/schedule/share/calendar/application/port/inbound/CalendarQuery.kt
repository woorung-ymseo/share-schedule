package com.schedule.share.calendar.application.port.inbound

import com.schedule.share.calendar.application.service.DomainQuery
import com.schedule.share.calendar.application.service.calendar.vo.CalendarVO
import com.schedule.share.calendar.application.service.schedule.vo.ScheduleVO

interface CalendarQuery : DomainQuery<CalendarVO.Calendar>
