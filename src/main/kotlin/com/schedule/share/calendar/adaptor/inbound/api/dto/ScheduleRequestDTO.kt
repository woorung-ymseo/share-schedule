package com.schedule.share.calendar.adaptor.inbound.api.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

class ScheduleRequestDTO {

    data class Search(
        val title: String,
    )

    data class Schedule(
        @Schema(required = true)
        val title: String,

        @Schema(required = true)
        val isAllday: Boolean = false,

        @Schema(required = true, description = "yyyy-MM-ddTHH:mm:ss")
        val startDatetime: LocalDateTime,

        @Schema(required = true, description = "yyyy-MM-ddTHH:mm:ss")
        val endDatetime: LocalDateTime,

        val content: String? = null,
        val location: String? = null,
    )
}