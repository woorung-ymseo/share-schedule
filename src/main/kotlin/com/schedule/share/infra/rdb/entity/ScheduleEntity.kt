package com.schedule.share.infra.rdb.entity

import com.schedule.share.common.utils.DateUtil
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(catalog = "schedule", name = "schedule")
@SQLRestriction("deleted_at is null")
@EntityListeners(AuditingEntityListener::class)
open class ScheduleEntity(
    id: Long? = null,
    calendarId: Long,
    userId: Long,
    title: String,
    isAllday: Boolean = false,
    startDatetime: LocalDateTime,
    endDatetime: LocalDateTime,
    content: String? = null,
    location: String? = null,
    createdAt: LocalDateTime? = DateUtil.now(),
    modifiedAt: LocalDateTime? = DateUtil.now(),
    deletedAt: LocalDateTime? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = id
        protected set

    open var calendarId: Long = calendarId
        protected set

    open var userId: Long = userId
        protected set

    open var title: String = title
        protected set

    open var isAllday: Boolean = isAllday
        protected set

    open var startDatetime: LocalDateTime = startDatetime
        protected set

    open var endDatetime: LocalDateTime = endDatetime
        protected set

    open var content: String? = content
        protected set

    open var location: String? = location
        protected set

    @CreatedDate
    open var createdAt: LocalDateTime? = createdAt
        protected set

    @LastModifiedDate
    open var modifiedAt: LocalDateTime? = modifiedAt
        protected set

    open var deletedAt: LocalDateTime? = deletedAt

    fun delete(): ScheduleEntity {
        this.deletedAt = DateUtil.now()

        return this
    }
}
