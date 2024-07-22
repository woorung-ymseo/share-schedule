package com.schedule.share.calendar.adaptor.inbound.api

import com.schedule.share.calendar.adaptor.inbound.api.dto.ScheduleRequestDTO
import com.schedule.share.calendar.adaptor.inbound.api.dto.ScheduleResponseDTO
import com.schedule.share.calendar.adaptor.inbound.api.mapper.toResponse
import com.schedule.share.calendar.adaptor.inbound.api.mapper.toVO
import com.schedule.share.calendar.application.port.inbound.ScheduleCommand
import com.schedule.share.calendar.application.port.inbound.ScheduleQuery
import com.schedule.share.calendar.application.service.schedule.ScheduleService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/schedules")
class ScheduleApi(
    private val scheduleQuery: ScheduleQuery,
    private val scheduleCommand: ScheduleCommand,
    private val scheduleService: ScheduleService,
) {
    @Operation(summary = "스케줄 단건 조회 API - 커밋 테스트", description = "스케줄 단건 조회 API")
    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long,
    ): ScheduleResponseDTO.Response = scheduleQuery.get(id = id).toResonse()

    @Operation(summary = "스케쥴 조회 API", description = "스토어 조회 API")
    @GetMapping("/schedules")
    fun getList(): List<ScheduleResponseDTO.Response> =
        scheduleQuery.list().map { it.toResponse() }

    @Operation(summary = "스케쥴 등록 API", description = "스토어 등록 API")
    @PostMapping("/schedules/calendars/{calendarId}")
    fun post(
        @PathVariable calendarId: Long,
        @RequestBody body: ScheduleRequestDTO.Schedule,
    ): Long = scheduleCommand.create(
        param = body.toVO(
            userId = 1L,
            calendarId = calendarId,
        )
    )

    @Operation(summary = "스케쥴 수정 API", description = "스토어 수정 API")
    @PutMapping("/{id}")
    fun put(
        @PathVariable id: Long,
        @PathVariable calendarId: Long,
        @RequestBody body: ScheduleRequestDTO.Schedule,
    ) {
        scheduleCommand.update(
            id = id,
            param = body.toVO(
                userId = 1L,
                calendarId = calendarId,
            )
        )
    }

    @Operation(summary = "스케쥴 삭제 API", description = "스토어 삭제 API")
    @DeleteMapping("/{id}")
    fun put(
        @PathVariable id: Long,
    ) {
        scheduleCommand.delete(id = id)
    }
}
