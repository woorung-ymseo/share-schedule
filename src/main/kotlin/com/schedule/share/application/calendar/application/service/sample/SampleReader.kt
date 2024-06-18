package com.schedule.share.application.calendar.application.service.sample

import com.schedule.share.application.calendar.application.port.inbound.SampleQuery
import org.springframework.stereotype.Component

@Component
class SampleReader : SampleQuery {

    override fun get(): String {
        TODO("Not yet implemented")
    }
}