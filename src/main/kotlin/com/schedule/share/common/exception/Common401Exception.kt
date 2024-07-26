package com.schedule.share.common.exception

import com.schedule.share.common.exception.code.ResponseCode

class Common401Exception(
    override val message: String = ResponseCode.UNAUTHORIZED.message,
): AbstractException(
        code = ResponseCode.NOT_FOUND,
        message = message,
    )