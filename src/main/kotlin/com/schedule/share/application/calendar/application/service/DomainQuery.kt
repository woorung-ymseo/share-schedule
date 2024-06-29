package com.schedule.share.application.calendar.application.service

interface DomainQuery<T> {

    fun get(id: Long): T

    fun list(): List<T>
}
