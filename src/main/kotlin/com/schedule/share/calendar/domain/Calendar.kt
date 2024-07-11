package com.schedule.share.calendar.domain

import java.time.LocalDateTime

class Calendar(
    val id: Long? = null,
    val isPublic: Boolean = false,
    val title: String,
    val content: String? =null,
    val image: ByteArray? = null,
    val createdBy: Long? = null,
    val createdAt: LocalDateTime? = null,
    val modifiedAt: LocalDateTime? = null
)