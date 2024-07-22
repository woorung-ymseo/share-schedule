package com.schedule.share.calendar.adaptor.inbound.api.mapper

import com.schedule.share.calendar.adaptor.inbound.api.dto.ScheduleRequestDTO
import com.schedule.share.calendar.adaptor.inbound.api.dto.ScheduleResponseDTO
import com.schedule.share.calendar.application.service.schedule.vo.ScheduleVO

fun ScheduleRequestDTO.Schedule.toVO(
    userId: Long,
    calendarId: Long,
): ScheduleVO.Save =
    ScheduleVO.Save(
        calendarId = calendarId,
        userId = userId,
        title = title,
        isAllday = isAllday,
        startDatetime = startDatetime,
        endDatetime = endDatetime,
        content = content,
        location = location,
    )


fun ScheduleVO.Schedule.toResponse(): ScheduleResponseDTO.Response =
    ScheduleResponseDTO.Response(
        id = id!!,
        calendarId = calendarId,
        userId = userId,
        title = title,
        isAllday = isAllday,
        startDatetime = startDatetime,
        endDatetime = endDatetime,
        content = content,
        location = location,
        createdAt = createdAt!!,
        modifiedAt = modifiedAt!!,
    )