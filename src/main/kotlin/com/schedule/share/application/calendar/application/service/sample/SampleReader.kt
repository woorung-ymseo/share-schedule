package com.schedule.share.application.calendar.application.service.sample

import com.schedule.share.application.calendar.application.port.inbound.SampleQuery
import com.schedule.share.application.calendar.application.port.outbound.SamplePort
import org.springframework.stereotype.Component

@Component
class SampleReader(
    private val samplePort: SamplePort,
) : SampleQuery {

    override fun get(): String {
        return samplePort.getDbData().plus(" > 서비스리턴")
    }
}