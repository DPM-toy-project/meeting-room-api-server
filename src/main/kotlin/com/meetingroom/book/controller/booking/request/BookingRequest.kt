package com.meetingroom.book.controller.booking.request

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class BookingRequest(
    @Schema(title = "주최자 id", example = "1", required = true)
    val ownerId: Long,
    @Schema(title = "참가자 id 목록", example = "[2,3,4]")
    val entriesIds: List<Long> = listOf(),
    @Schema(title = "회의실 id", example = "1", required = true)
    val meetingRoomId: Long,
    @Schema(title = "회의 시작 시간", example = "2022-08-11 13:00:00.000", required = true)
    val startDateTime: LocalDateTime,
    @Schema(title = "회의 종료 시간", example = "2022-08-11 14:00:00.000", required = true)
    val endDateTime: LocalDateTime,
    @Schema(title = "회의 상세내용", example = "1")
    val description: String = "",
    @Schema(title = "회의 시작 알림 여부", example = "true")
    val notify: Boolean = false,
)
