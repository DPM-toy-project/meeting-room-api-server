package com.meetingroom.book.controller.booking.response

import com.meetingroom.book.constant.EntryStatus
import com.meetingroom.book.controller.meetingroom.response.MeetingRoomResponse
import com.meetingroom.book.controller.user.response.UserResponse
import com.meetingroom.book.domain.Booking
import com.meetingroom.book.domain.MeetingEntry
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

data class BookingResponse(
    @Schema(title = "예약 id", example = "1")
    val id: Long,
    @Schema(title = "주최자 id", example = "1")
    val owner: UserResponse,
    @Schema(title = "참가자 id 목록")
    val entries: List<MeetingEntryResponse> = listOf(),
    @Schema(title = "회의실 id", example = "1")
    val meetingRoom: MeetingRoomResponse,
    @Schema(title = "회의 시작 시간", example = "2022-08-11 13:00:00.000")
    val startDateTime: LocalDateTime,
    @Schema(title = "회의 종료 시간", example = "2022-08-11 14:00:00.000")
    val endDateTime: LocalDateTime,
    @Schema(title = "회의 상세내용", example = "1")
    val description: String = "",
    @Schema(title = "회의 시작 알림 여부", example = "true")
    val notify: Boolean = false,
) {
    companion object {
        fun of(booking: Booking) = with(booking) {
            BookingResponse(
                id = id!!,
                owner = UserResponse.of(owner),
                entries = entries.map { MeetingEntryResponse.of(it) },
                meetingRoom = MeetingRoomResponse.of(meetingRoom),
                startDateTime = startDateTime,
                endDateTime = endDateTime,
                description = description,
                notify = notify
            )
        }
    }

    data class MeetingEntryResponse(
        @Schema(title = "회의 참가자 id", example = "1")
        val id: Long,
        @Schema(title = "회의 참가자 정보")
        val user: UserResponse,
        @Schema(title = "회의 참석 여부", example = "READY")
        val status: EntryStatus,
    ) {
        companion object {
            fun of(meetingEntry: MeetingEntry) = with(meetingEntry) {
                MeetingEntryResponse(
                    id = id!!,
                    user = UserResponse.of(user),
                    status = status,
                )
            }
        }
    }
}
