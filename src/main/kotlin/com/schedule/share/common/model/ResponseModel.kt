package com.schedule.share.common.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.schedule.share.common.exception.AbstractException
import org.apache.commons.lang3.StringUtils

@JsonInclude(JsonInclude.Include.NON_NULL)
class ResponseModel<T>(
    val data: T? = null,
    val code: String? = null,
    val message: String? = null,
    val pagination: Pagination? = null,

    ) {
    companion object {
        fun <T> of(
            data: T? = null,
            total: Long = 0,
            limit: Int = 1,
            offset: Int = 0,
        ) = ResponseModel(
            data = data,
            pagination = Pagination(
                total = total,
                limit = limit,
                offset = offset,
            ).calc()
        )

        fun of(
            exception: AbstractException
        ) = ResponseModel<Any>(
            code = exception.code.code,
            message = if (StringUtils.isBlank(exception.message)) exception.message else exception.message,
        )
    }

    class Pagination(
        val total: Long = 0,
        val limit: Int = 1,
        val offset: Int = 0,
        var sort: String? = null,
    ) {
        var totalPages: Int = 0
        var page: Int = 0
        var size: Int = 0
        var isFirst: Boolean = true
        var isLast: Boolean = true

        fun calc(): Pagination {
            totalPages = (total / limit + if (total % limit == 0L) 0 else 1).toInt()
            page = (offset / limit) + 1
            size = limit
            isFirst = page == 1
            isLast = page == totalPages

            return this
        }
    }
}

