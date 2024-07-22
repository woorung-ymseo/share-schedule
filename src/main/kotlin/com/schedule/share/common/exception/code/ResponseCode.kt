package com.schedule.share.common.exception.code

/**
 * 0000 : 성공
 * 9999 : 실패
 * 0001 ~ 0999 : 공통 에러 코드
 * 0100 ~ 0199 : 캘린더 에러 코드
 * 0200 ~ 0299 : 스케쥴 에러 코드
 */
enum class ResponseCode(
    val code: String,
    val message: String,
) {
    SUCCESS("0000", "성공"),
    UNAUTHORIZED("0001", "인증 실패"),
    FORBIDDEN("0002", "권한 없음"),
    BAD_REQUEST("0003", "잘못된 요청입니다."),
    NOT_FOUND("0004", "조회된 데이터가 없습니다."),
    FAIL("9999", "ERROR"),



}