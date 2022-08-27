package com.meetingroom.book.controller.meetingroom.response

import com.meetingroom.book.domain.MeetingRoom
import io.swagger.v3.oas.annotations.media.Schema

data class MeetingRoomResponse(
    @Schema(title = "회의실 id", example = "1")
    val id: Long,
    @Schema(title = "회의실 이름 이름", example = "회의실1")
    val name: String,
    @Schema(title = "회의실 층 수", example = "12")
    val floor: Int,
) {
    companion object {
        fun of(meetingRoom: MeetingRoom) = with(meetingRoom) {
            MeetingRoomResponse(
                id = id!!,
                name = name,
                floor = floor,
            )
        }
    }
}
