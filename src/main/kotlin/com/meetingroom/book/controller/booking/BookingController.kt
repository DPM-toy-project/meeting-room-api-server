package com.meetingroom.book.controller.booking

import com.meetingroom.book.controller.booking.request.BookingFindDateRangeRequest
import com.meetingroom.book.controller.booking.request.BookingRequest
import com.meetingroom.book.controller.booking.response.BookingResponse
import com.meetingroom.book.domain.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@Tag(name = "예약 관리 API")
@RestController
class BookingController {
    @Operation(summary = "회의실 예약")
    @PostMapping("/v1/bookings")
    suspend fun create(@RequestBody request: BookingRequest): Long {
        return 1L
    }

    @Operation(summary = "예약정보 수정")
    @PutMapping("/v1/bookings")
    suspend fun modify(@RequestBody request: BookingRequest): Long {
        return 1L
    }

    @Operation(summary = "예약 취소")
    @DeleteMapping("/v1/bookings/{bookingId}")
    suspend fun delete(@PathVariable bookingId: Long): Long {
        return bookingId
    }

    @Operation(summary = "기간별 예약 조회")
    @GetMapping("/v1/bookings")
    suspend fun findAllByDateRange(@RequestBody request: BookingFindDateRangeRequest): List<BookingResponse> {
        val team = Team(id = 1L, part = "개발본부", name = "서버팀", color = "#000000")
        val user = User(
            id = 1L,
            email = "example@ex-em.com",
            name = "홍길동",
            password = "",
            team = team,
            accepted = true,
            bookings = mutableListOf()
        )
        val meetingRoom = MeetingRoom(id = 1L, name = "회의실1", floor = 12, bookings = mutableListOf())

        return listOf(
            Booking(id = 1L, title = "회의1", owner = user, meetingRoom = meetingRoom, entries = mutableListOf(MeetingEntry.of(user)), startDateTime = LocalDateTime.now(), endDateTime = LocalDateTime.now().plusDays(1)),
            Booking(id = 2L, title = "회의2", owner = user, meetingRoom = meetingRoom, entries = mutableListOf(MeetingEntry.of(user)), startDateTime = LocalDateTime.now(), endDateTime = LocalDateTime.now().plusDays(1)),
        ).map { BookingResponse.of(it) }
    }
}
