package com.meetingroom.book.controller.meetingroom.reqeust

import io.swagger.v3.oas.annotations.media.Schema

data class MeetingRoomRequest(
    @Schema(title = "회의실 이름 이름", example = "회의실1", required = true)
    val name: String,
    @Schema(title = "회의실 층 수", example = "12", required = true)
    val floor: Int
)
