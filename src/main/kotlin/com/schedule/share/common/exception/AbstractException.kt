package com.schedule.share.common.exception

import com.schedule.share.common.exception.code.ResponseCode

abstract class AbstractException(
    open val code: ResponseCode,
    override val message: String = code.message,
): RuntimeException()