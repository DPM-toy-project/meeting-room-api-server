package com.meetingroom.book.controller.team.response

import com.meetingroom.book.domain.Team
import io.swagger.v3.oas.annotations.media.Schema

data class TeamResponse(
    @Schema(title = "팀 id", example = "1")
    val id: Long,
    @Schema(title = "부서 이름", example = "개발본부")
    val part: String,
    @Schema(title = "팀 이름", example = "서버팀")
    val name: String,
    @Schema(title = "팀 배경색", example = "#000000")
    val color: String
) {
    companion object {
        fun of(team: Team) = with(team) {
            TeamResponse(
                id = id!!,
                part = part,
                name = name,
                color = color
            )
        }
    }
}
