package com.schedule.share.calendar.adaptor.inbound.api.dto

import java.time.LocalDateTime

class CalendarResponseDTO {

    data class Response(
        val id: Long? = null,
        val isPublic: Boolean = false,
        val title: String,
        val content: String? = null,
        val image: ByteArray? = null,
        val createdBy: Long? = null,
        val createdAt: LocalDateTime? = null,
        val modifiedAt: LocalDateTime? = null
    )
}