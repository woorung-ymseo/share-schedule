package com.schedule.share.calendar.domain.mapper

import com.schedule.share.calendar.application.service.schedule.vo.ScheduleVO
import com.schedule.share.calendar.domain.Schedule
import com.schedule.share.infra.rdb.entity.ScheduleEntity

fun ScheduleVO.Save.toDomain(
    id: Long? = null,
): Schedule =
    Schedule(
        id = id,
        calendarId = calendarId,
        userId = userId,
        title = title,
        isAllday = isAllday,
        startDatetime = startDatetime,
        endDatetime = endDatetime,
        content = content,
        location = location,
    )

fun ScheduleEntity.toDomain(): Schedule =
    Schedule(
        id = id,
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
        isDeleted = deletedAt != null,
    )

fun Schedule.toEntity(): ScheduleEntity =
    ScheduleEntity(
        id = id,
        calendarId = calendarId,
        userId = userId,
        title = title,
        isAllday = isAllday,
        startDatetime = startDatetime,
        endDatetime = endDatetime,
        content = content,
        location = location,
    )


fun Schedule.toVO(): ScheduleVO.Schedule =
    com.schedule.share.calendar.application.service.schedule.vo.ScheduleVO.Schedule(
        id = id,
        calendarId = calendarId,
        userId = userId,
        title = title,
        isAllday = isAllday,
        startDatetime = startDatetime,
        endDatetime = endDatetime,
        content = content,
        location = location,
        createdAt = createdAt,
        modifiedAt = modifiedAt,
        isDeleted = isDeleted,
    )
