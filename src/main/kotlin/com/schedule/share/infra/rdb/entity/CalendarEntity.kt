package com.schedule.share.infra.rdb.entity

import com.schedule.share.common.utils.DateUtil
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(catalog = "schedule", name = "calendar")
@EntityListeners(AuditingEntityListener::class)
open class CalendarEntity(
    id: Long? = null,
    isPublic: Boolean = false,
    title: String,
    content: String? = null,
    image: ByteArray? = null,
    createdBy: Long? = null,
    createdAt: LocalDateTime? = DateUtil.now(),
    modifiedAt: LocalDateTime? = DateUtil.now(),
    deletedAt: LocalDateTime? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = id
        protected set

    open var isPublic: Boolean = isPublic
        protected set

    open var title: String = title
        protected set

    open var content: String? = content
        protected set

    open var image: ByteArray? = image
        protected set

    open var createdBy: Long? = createdBy
        protected set

    @CreatedDate
    open var createdAt: LocalDateTime? = createdAt
        protected set

    @LastModifiedDate
    open var modifiedAt: LocalDateTime? = modifiedAt
        protected set

    open var deletedAt: LocalDateTime? = deletedAt

    fun delete(): CalendarEntity {
        this.deletedAt = DateUtil.now()

        return this
    }
}