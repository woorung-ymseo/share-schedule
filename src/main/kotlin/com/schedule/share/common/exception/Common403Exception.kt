package com.schedule.share.common.exception

import com.schedule.share.common.exception.code.ResponseCode

class Common403Exception(
    override val message: String = ResponseCode.FORBIDDEN.message,
): AbstractException(
        code = ResponseCode.NOT_FOUND,
        message = message,
    )