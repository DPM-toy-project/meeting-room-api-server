package com.meetingroom.book.utils.json

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.text.SimpleDateFormat
import java.util.*

object JsonUtils {
    val objectMapper = jacksonObjectMapper()

    init {
        objectMapper.registerModules(JavaTimeModule(), Jdk8Module())
            .enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .setTimeZone(TimeZone.getDefault())
            .setLocale(Locale.getDefault())
            .setDateFormat(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"))
            .setSerializationInclusion(JsonInclude.Include.ALWAYS)
    }

    inline fun <reified T, reified R> convert(data: T): R {
        val json = objectMapper.writeValueAsString(data)
        return objectMapper.readValue(json)
    }
}