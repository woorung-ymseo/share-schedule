package com.schedule.share.calendar.adaptor.inbound.api

import com.schedule.share.calendar.adaptor.inbound.api.dto.CalendarRequestDTO
import com.schedule.share.calendar.adaptor.inbound.api.dto.CalendarResponseDTO
import com.schedule.share.calendar.adaptor.inbound.api.mapper.toResponse
import com.schedule.share.calendar.adaptor.inbound.api.mapper.toVO
import com.schedule.share.calendar.application.port.inbound.CalendarCommand
import com.schedule.share.calendar.application.port.inbound.CalendarQuery
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/calendars")
class CalendarApi(
    private val calendarQuery: CalendarQuery,
    private val calendarCommand: CalendarCommand,
) {
    @Operation(summary = "캘린더 단건 조회 API", description = "캘린더 단건 조회 API")
    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long,
    ): CalendarResponseDTO.Response =
        calendarQuery.get(id = id).toResponse()

    @Operation(summary = "캘린더 조회 API", description = "캘린더 조회 API")
    @GetMapping
    fun getList(): List<CalendarResponseDTO.Response> =
        calendarQuery.list().map { it.toResponse() }

    @Operation(summary = "캘린더 등록 API", description = "캘린더 등록 API")
    @PostMapping(
        consumes = [MediaType.MULTIPART_FORM_DATA_VALUE],)
    fun post(
        @RequestPart body: CalendarRequestDTO.Calendar,
        @RequestPart(required = false) image: MultipartFile
    ): Long = calendarCommand.create(
        param = body.toVO(
            createdBy = 1L,
            image
        )
    )

    @Operation(summary = "캘린더 수정 API", description = "캘린더 수정 API")
    @PutMapping("/{id}")
    fun put(
        @PathVariable id: Long,
        @RequestPart body: CalendarRequestDTO.Calendar,
        @RequestPart(required = false) image: MultipartFile
    ) {
        calendarCommand.update(
            id = id,
            param = body.toVO(
                createdBy = 1L,
                image
            )
        )
    }
}
