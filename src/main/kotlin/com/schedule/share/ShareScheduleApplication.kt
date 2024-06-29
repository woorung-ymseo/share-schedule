package com.schedule.share

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class ShareScheduleApplication

fun main(args: Array<String>) {
    runApplication<ShareScheduleApplication>(*args)
}
