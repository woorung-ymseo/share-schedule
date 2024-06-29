package com.schedule.share.common.utils

import com.schedule.share.common.enum.DatePatternEnum
import com.schedule.share.common.utils.CollectionUtil.multipleLet
import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

object DateUtil {
    /**
     * 기존 "yyyyMMdd" 등 DateTimeFormatter pattern 상수 DatePatternEnum.kt 으로 이동
     */

    const val ZERO_DATE_TIME_STRING = "0000-00-00 00:00:00"
    const val LOCAL_TIME_ZONE: String = "Asia/Seoul"
    val ZONE_OFFSET_KST: ZoneOffset = ZoneOffset.of("+09:00")

    fun toLocalDate(
        strDate: String,
        format: String,
    ): LocalDate {
        val formatter = DateTimeFormatter.ofPattern(format)
        return LocalDate.parse(strDate, formatter)
    }

    fun toLocalDateTime(
        strDate: String?,
        format: String,
    ): LocalDateTime? {
        if (strDate.isNullOrBlank() || isZeroDateTime(strDate)) {
            return null
        }

        val formatter = DateTimeFormatter.ofPattern(format)
        return LocalDateTime.parse(strDate, formatter)
    }

    fun toLocalDateTimeWithoutException(
        strDate: String?,
        format: String,
    ): LocalDateTime? =
        runCatching {
            toLocalDateTime(strDate, format)
        }.getOrNull() // Exception null 처리

    fun toLocalDateTimeWithoutException(epochSecond: Long): LocalDateTime? =
        runCatching {
            LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSecond), ZoneId.of(LOCAL_TIME_ZONE))
        }.getOrNull() // Exception null 처리

    fun now(): LocalDateTime = LocalDateTime.now(ZoneId.of(LOCAL_TIME_ZONE))

    fun min(): LocalDateTime = LocalDateTime.of(1000, 1, 1, 0, 0, 0)

    fun max(): LocalDateTime = LocalDateTime.of(9999, 12, 31, 23, 59, 59)

    fun nowLocalDateToString(format: String): String {
        val formatter = DateTimeFormatter.ofPattern(format)
        return now().format(formatter)
    }

    fun getLocalDate(date: String): LocalDate {
        val temp = date.split("-")
        return if (temp.size < 3) {
            LocalDate.parse(date)
        } else {
            LocalDate.of(temp[0].toInt(), temp[1].toInt(), temp[2].toInt())
        }
    }

    fun convertDateWithMinus(
        localDate: LocalDate?,
        minusDays: Int,
    ): String {
        return (localDate ?: now().toLocalDate())
            .atStartOfDay()
            .minusDays(minusDays.toLong())
            .format(
                DateTimeFormatter.ofPattern(DatePatternEnum.FORMAT_DATE_MIN.pattern),
            )
    }

    fun convertDateTimeWithDefault(
        dateTime: LocalDateTime?,
        defaultValue: String,
    ): String {
        return dateTime?.let { convert(it, DatePatternEnum.FORMAT_YYYYMMDDHHMM.pattern) } ?: defaultValue
    }

    fun convert(
        dateTime: LocalDateTime?,
        pattern: String,
    ): String {
        return dateTime?.let { DateTimeFormatter.ofPattern(pattern).format(it) }.orEmpty()
    }

    fun convertPastDateTime(dateTime: LocalDateTime): String = convertPastDateTime(dateTime, null, null)

    fun convertPastDateTime(
        dateTime: LocalDateTime,
        pattern: String?,
        daysLimit: Int?,
    ): String {
        val dateDiff = Duration.between(dateTime, now())

        if (pattern != null && daysLimit != null && dateDiff.toDays() > daysLimit) {
            return convert(dateTime, pattern)
        }

        val days = dateDiff.toDays()
        val hours = dateDiff.toHours()
        val minutes = dateDiff.toMinutes()

        return when {
            days > 0 -> "${days}일 전"
            hours > 0 -> "${hours}시간 전"
            minutes > 0 -> "${minutes}분 전"
            else -> "1분 전"
        }
    }

    fun isBetweenDateByCurrent(
        startDate: LocalDateTime?,
        endDate: LocalDateTime?,
    ): Boolean = isBetweenDate(now(), startDate, endDate)

    /**
     * startDate '이상', endDate '미만' 인지 확인
     */
    fun isBetweenDate(
        searchDate: LocalDateTime,
        startDate: LocalDateTime?,
        endDate: LocalDateTime?,
    ): Boolean =
        multipleLet(startDate, endDate) { (startDate, endDate) ->
            searchDate in startDate..<endDate
        } ?: false

    /**
     * startDate '초과', endDate '미만' 인지 확인
     */
    fun isBetweenDateExclusiveStart(
        searchDate: LocalDateTime,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
    ): Boolean = searchDate.isAfter(startDate) && searchDate.isBefore(endDate)

    fun isZeroDateTime(date: String): Boolean = ZERO_DATE_TIME_STRING == date

    fun convertEpochMilli(date: LocalDateTime?): Long? = date?.toInstant(ZONE_OFFSET_KST)?.toEpochMilli()

    fun convertEpochMilli(date: LocalDateTime): Long = date.toInstant(ZONE_OFFSET_KST).toEpochMilli()

    /***********************************************
     * LocalTime
     */
    fun nowTime(): LocalTime = LocalTime.now(ZoneId.of(LOCAL_TIME_ZONE))

    fun toLocalTime(
        strTime: String,
        format: String,
    ): LocalTime {
        val formatter = DateTimeFormatter.ofPattern(format)
        return LocalTime.parse(strTime, formatter)
    }

    fun getMinuteDelimiter(minute: Int): Int {
        return if (minute > 0) now().minute / minute else 0
    }
}
