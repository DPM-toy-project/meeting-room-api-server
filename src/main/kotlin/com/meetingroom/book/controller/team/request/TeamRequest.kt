package com.meetingroom.book.controller.team.request

import com.meetingroom.book.domain.Team
import io.swagger.v3.oas.annotations.media.Schema

data class TeamRequest(
    @Schema(title = "부서 이름", example = "개발본부", required = true)
    val part: String,
    @Schema(title = "팀 이름", example = "서버팀", required = true)
    val name: String,
    @Schema(title = "팀 배경색", example = "#000000", required = true)
    val color: String
) {
    fun toTeam() = Team(
        part = part,
        name = name,
        color = color,
    )
}
