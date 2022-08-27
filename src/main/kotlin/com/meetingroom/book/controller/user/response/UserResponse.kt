package com.meetingroom.book.controller.user.response

import com.meetingroom.book.controller.team.response.TeamResponse
import com.meetingroom.book.domain.User
import io.swagger.v3.oas.annotations.media.Schema

data class UserResponse (
    @Schema(title = "사용자 id", example = "1")
    val id: Long,
    @Schema(title = "사용자 이메일", example = "example@ex-em.com")
    val email: String,
    @Schema(title = "사용자 이름", example = "홍길동")
    val name: String,
    @Schema(title = "사용자가 속한 팀 정보")
    val team: TeamResponse,
) {
    companion object {
        fun of(user: User) = with(user) {
            UserResponse(
                id = id!!,
                email = email,
                name = name,
                team = TeamResponse.of(team)
            )
        }
    }
}
