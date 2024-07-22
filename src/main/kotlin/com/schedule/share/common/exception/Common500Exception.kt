package com.schedule.share.common.exception

import com.schedule.share.common.exception.code.ResponseCode

class Common500Exception(
    override val message: String = ResponseCode.FAIL.message,
): AbstractException(
        code = ResponseCode.FAIL,
        message = message,
    )