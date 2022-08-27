package com.meetingroom.book.controller.meetingroom

import com.meetingroom.book.controller.meetingroom.reqeust.MeetingRoomRequest
import com.meetingroom.book.controller.meetingroom.response.MeetingRoomResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "회의실 관리 API")
@RestController
class MeetingRoomController {
    @Operation(summary = "회의실 등록")
    @PostMapping("/v1/meetingrooms")
    suspend fun create(@RequestBody request: MeetingRoomRequest): Long {
        return 1L
    }

    @Operation(summary = "회의실 수정")
    @PutMapping("/v1/meetingrooms")
    suspend fun modify(@RequestBody request: MeetingRoomRequest): Long {
        return 1L
    }

    @Operation(summary = "회의실 삭제")
    @DeleteMapping("/v1/meetingrooms/{meetingroomId}")
    suspend fun delete(@PathVariable meetingroomId: Long): Long {
        return meetingroomId
    }

    @Operation(summary = "회의실 전체 조회")
    @GetMapping("/v1/meetingrooms")
    suspend fun findAll(): List<MeetingRoomResponse> {
        return listOf(
            MeetingRoomResponse(id = 1L, name = "회의실1", floor = 12),
            MeetingRoomResponse(id = 2L, name = "회의실2", floor = 13),
        )
    }

    @Operation(summary = "회의실 층별 조회")
    @GetMapping("/v1/meetingrooms/{floor}")
    suspend fun findAllByFloor(@PathVariable floor: Int): List<MeetingRoomResponse> {
        return listOf(
            MeetingRoomResponse(id = 1L, name = "회의실1", floor = floor),
            MeetingRoomResponse(id = 2L, name = "회의실2", floor = floor),
        )
    }
}
