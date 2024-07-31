package com.schedule.share.infra.rdb.entity

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(catalog = "schedule", name = "calendar_tag")
@EntityListeners(AuditingEntityListener::class)
open class CalendarTagEntity(
    id: Long? = null,
    calendarId: Long,
    tag: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = id
        protected set

    open var calendarId: Long = calendarId
        protected set

    open var tag: String = tag
        protected set
}