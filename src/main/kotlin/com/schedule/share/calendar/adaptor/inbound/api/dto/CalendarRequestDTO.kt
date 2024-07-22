package com.schedule.share.calendar.adaptor.inbound.api.dto

class CalendarRequestDTO {

    data class Search(
        val title: String,
    )

    data class Calendar(
        val isPublic: Boolean = false,
        val title: String,
        val content: String,
       // val image: MultipartFile?= null,
        //val image: ByteArray? = null,
    )
}