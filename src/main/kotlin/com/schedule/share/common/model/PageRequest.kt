package com.schedule.share.common.model

data class PageRequest(
    val offset: Int,
    val limit: Int,
    val sort: String,
)