package com.schedule.share.common.enum

// TODO : 사용 안하는거 다 정리필요
enum class DatePatternEnum(val pattern: String) {
    FORMAT_DATE_MIN(DatePattern.FORMAT_DATE_MIN),
    FORMAT_DATE_TIME_MIN(DatePattern.FORMAT_DATE_TIME_MIN),
    FORMAT_YYYYMMDDHHMM(DatePattern.FORMAT_YYYYMMDDHHMM),
    FORMAT_DATE_TIME_MIN_SEC(DatePattern.FORMAT_DATE_TIME_MIN_SEC),

    FORMAT_YYYYMMDD(DatePattern.FORMAT_YYYYMMDD),
    FORMAT_YYYYMMDD_HHMMSS(DatePattern.FORMAT_YYYYMMDD_HHMMSS),

    FORMAT_YYMMDD_DOT(DatePattern.FORMAT_YYMMDD_DOT),
    FORMAT_HHMMSS(DatePattern.FORMAT_HHMMSS),
}

object DatePattern {
    const val FORMAT_DATE_MIN = "yyyyMMdd"
    const val FORMAT_DATE_TIME_MIN = "yyyyMMddHH"
    const val FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm"
    const val FORMAT_DATE_TIME_MIN_SEC = "yyyyMMddHHmmss"
    const val FORMAT_YYYYMMDD = "yyyy-MM-dd"
    const val FORMAT_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss"
    const val FORMAT_YYYYMMDD_HHMMSS_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss"
    const val FORMAT_YYMMDD_DOT = "YY.MM.dd"
    const val FORMAT_HHMMSS = "HHmmss"
    const val FORMAT_MMDDHHMM_DOT = "MM.dd HH:dd 기준"
    const val FORMAT_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ssXXX"
}
