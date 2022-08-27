package com.meetingroom.book.controller.user

import com.meetingroom.book.controller.team.response.TeamResponse
import com.meetingroom.book.controller.user.request.UserRequest
import com.meetingroom.book.controller.user.response.UserResponse
import com.meetingroom.book.domain.Team
import com.meetingroom.book.service.user.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "유저 관리 API")
@RestController
class UserController(
    val userService: UserService
) {
    @Operation(summary = "유저 등록", description = "해당 인증정보로 보낸 인증 메일의 검증에 성공해야 등록이 완료된다")
    @PostMapping("/v1/users")
    fun create(@RequestBody request: UserRequest): Long {
        return userService.create(request)
    }

    @Operation(summary = "유저 정보 수정")
    @PutMapping("/v1/users/{userId}")
    suspend fun modify(
        @PathVariable userId: Long,
        @RequestBody request: UserRequest
    ): Long {
        return userId
    }

    @Operation(summary = "유저 삭제")
    @DeleteMapping("/v1/users/{userId}")
    suspend fun delete(@PathVariable userId: Long): Long {
        return userId
    }

    @Operation(summary = "전체 유저 정보 조회")
    @GetMapping("/v1/users")
    suspend fun findAll(): List<UserResponse> {
        return listOf(
            UserResponse(id = 1L, email = "example1@ex-em.com", name = "테스트1", team = TeamResponse.of(Team(id = 1L, part = "개발본부", name = "서버팀", color = "#000000"))),
            UserResponse(id = 2L, email = "example2@ex-em.com", name = "테스트2", team = TeamResponse.of(Team(id = 1L, part = "개발본부", name = "서버팀", color = "#000000"))),
        )
    }

    @Operation(summary = "특정 유저 정보 조회")
    @GetMapping("/v1/users/{userId}")
    suspend fun findAll(@PathVariable userId: Long): UserResponse {
        return UserResponse(id = 1L, email = "example1@ex-em.com", name = "테스트1", team = TeamResponse.of(Team(id = 1L, part = "개발본부", name = "서버팀", color = "#000000")))
    }
}
