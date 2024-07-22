package com.schedule.share.common.exception

import com.schedule.share.common.exception.code.ResponseCode

class Common400Exception(
    override val code: ResponseCode,
    override val message: String = code.message,
): AbstractException(
        code = code,
        message = message,
    )