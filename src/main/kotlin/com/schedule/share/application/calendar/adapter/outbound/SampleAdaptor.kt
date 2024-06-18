package com.schedule.share.application.calendar.adapter.outbound

import com.schedule.share.application.calendar.application.port.outbound.SamplePort
import org.springframework.stereotype.Component

@Component
class SampleAdaptor() : SamplePort {
    override fun getDbData(): String {
        return "db 에서 조회"
    }
}