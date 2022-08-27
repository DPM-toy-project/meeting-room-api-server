package com.meetingroom.book.controller.user.request

import com.meetingroom.book.domain.Team
import com.meetingroom.book.domain.User
import io.swagger.v3.oas.annotations.media.Schema

data class UserRequest(
    @Schema(title = "사용자 이메일", example = "example@ex-em.com", required = true)
    val email: String,
    @Schema(title = "사용자 이름", example = "홍길동", required = true)
    val name: String,
    @Schema(title = "비밀번호", example = "*******", required = true)
    val password: String,
    @Schema(title = "사용자가 속한 팀 id", example = "1", required = true)
    val teamId: Long
) {
    fun toUser(team: Team) = User(
        email = email,
        name = name,
        password = password,
        team = team,
    )
}
