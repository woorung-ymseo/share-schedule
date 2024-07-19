package com.schedule.share.infra.rdb.repository

import com.schedule.share.calendar.domain.Calendar
import com.schedule.share.infra.rdb.entity.CalendarEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CalendarRepository : JpaRepository<CalendarEntity, Long> {
    fun findAllByDeletedAtIsNull(): List<CalendarEntity>
}
