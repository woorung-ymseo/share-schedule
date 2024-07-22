package com.schedule.share.common.exception.handler

import com.schedule.share.common.exception.*
import com.schedule.share.common.exception.code.ResponseCode
import com.schedule.share.common.model.ResponseModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class CommonExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [Common400Exception::class])
    fun handler400(ex: AbstractException): ResponseModel<Any> {
        return response(ex)
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = [Common401Exception::class])
    fun handler401(ex: AbstractException): ResponseModel<Any> {
        return response(ex)
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = [Common403Exception::class])
    fun handler403(ex: AbstractException): ResponseModel<Any> {
        return response(ex)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [Common404Exception::class])
    fun handler404(ex: AbstractException): ResponseModel<Any> {
        return response(ex)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [RuntimeException::class])
    fun native400(ex: RuntimeException): ResponseModel<Any> {
        ex.printStackTrace()

        return ResponseModel.of(
            exception = Common400Exception(
                code = ResponseCode.NOT_FOUND,
                message = ex.message ?: ResponseCode.NOT_FOUND.message,
            )
        )
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = [Exception::class, Common500Exception::class])
    fun handler500(ex: Exception): ResponseModel<Any> {
        ex.printStackTrace()

        return ResponseModel.of(
            exception = Common500Exception(
                message = ex.message ?: ResponseCode.FAIL.message,
            )
        )
    }

    private fun response(ex: AbstractException): ResponseModel<Any> {
        ex.printStackTrace()

        return ResponseModel.of(
            exception = ex
        )
    }
}