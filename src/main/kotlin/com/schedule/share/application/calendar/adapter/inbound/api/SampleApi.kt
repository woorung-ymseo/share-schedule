package com.schedule.share.application.calendar.adapter.inbound.api

import com.schedule.share.application.calendar.application.port.inbound.SampleCommand
import com.schedule.share.application.calendar.application.port.inbound.SampleQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleApi(
    private val sampleQuery: SampleQuery,
    private val sampleCommand: SampleCommand,
) {

    @GetMapping("/test")
    fun test(): String = sampleQuery.get()
}