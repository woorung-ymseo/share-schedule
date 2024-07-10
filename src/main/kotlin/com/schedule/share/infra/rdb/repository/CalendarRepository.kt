package com.schedule.share.infra.rdb.repository

import com.schedule.share.infra.rdb.entity.CalendarEntity
import com.schedule.share.infra.rdb.entity.ScheduleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CalendarRepository : JpaRepository<CalendarEntity, Long>
