package com.schedule.share.calendar.domain.mapper

import com.schedule.share.calendar.application.service.calendar.vo.CalendarVO
import com.schedule.share.calendar.domain.Calendar
import com.schedule.share.infra.rdb.entity.CalendarEntity

fun CalendarVO.Save.toDomain(
    id: Long? = null,
): Calendar =
    Calendar(
        id = id,
        isPublic = isPublic,
        title = title,
        createdBy = createdBy,
        content = content,
        image = image,
    )

fun CalendarEntity.toDomain(): Calendar =
    Calendar(
        id = id,
        isPublic = isPublic,
        title = title,
        content = content,
        image = image,
        createdBy = createdBy,
        createdAt = createdAt!!,
        modifiedAt = modifiedAt!!,
    )

fun Calendar.toEntity(): CalendarEntity =
    CalendarEntity(
        id = id,
        isPublic = isPublic,
        title = title,
        content = content,
        image = image,
        createdBy = createdBy
    )


fun Calendar.toVO(): CalendarVO.Calendar =
    CalendarVO.Calendar(
        id = id,
        isPublic = isPublic,
        title = title,
        content = content,
        image = image,
        createdBy = createdBy,
        createdAt = createdAt,
        modifiedAt = modifiedAt,
    )
