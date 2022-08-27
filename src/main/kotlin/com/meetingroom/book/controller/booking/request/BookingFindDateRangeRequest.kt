package com.meetingroom.book.controller.booking.request

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class BookingFindDateRangeRequest(
    @Schema(title = "회의 시작 시간", example = "2022-08-11 13:00:00.000", required = true)
    val startDateTime: LocalDateTime,
    @Schema(title = "회의 종료 시간", example = "2022-08-11 14:00:00.000", required = true)
    val endDateTime: LocalDateTime,
)
