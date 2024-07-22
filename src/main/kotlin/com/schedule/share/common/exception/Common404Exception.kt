package com.schedule.share.common.exception

import com.schedule.share.common.exception.code.ResponseCode

class Common404Exception(
    override val message: String = ResponseCode.NOT_FOUND.message,
): AbstractException(
        code = ResponseCode.NOT_FOUND,
        message = message,
    )