package com.schedule.share.common.model.response

class Response<T>(
    val data: T? = null,
    val pagination: Pagination?,
) {

    class Pagination {
        val total: Long = 0
        val totalPages: Long = 0
        val page: Int = 0
        val size: Int = 0
        val isFirst: Boolean = true
        val isLast: Boolean = true
        val limit: Int = 0
        val offset: Int = 0
        val sort: String? = null
    }
}

