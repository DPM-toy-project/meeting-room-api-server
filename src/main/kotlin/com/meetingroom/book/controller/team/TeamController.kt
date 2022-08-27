package com.meetingroom.book.controller.team

import com.meetingroom.book.controller.team.request.TeamRequest
import com.meetingroom.book.controller.team.response.TeamResponse
import com.meetingroom.book.service.team.TeamService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "팀 관리 API")
@RestController
class TeamController(
    val teamService: TeamService,
) {
    @Operation(summary = "팀 등록")
    @PostMapping("/v1/teams")
    fun create(@RequestBody request: TeamRequest): Long {
        return teamService.create(request)
    }

    @Operation(summary = "팀 정보 수정")
    @PutMapping("/v1/teams")
    suspend fun modify(@RequestBody request: TeamRequest): Long {
        return 1L
    }

    @Operation(summary = "팀 삭제")
    @DeleteMapping("/v1/teams/{teamId}")
    suspend fun delete(@PathVariable teamId: Long): Long {
        return teamId
    }

    @Operation(summary = "팀 전체 조회")
    @GetMapping("/v1/teams")
    suspend fun findAll(): List<TeamResponse> {
        return listOf(
            TeamResponse(id = 1L, part = "개발본부1", name = "서버팀", color = "#8B0000"),
            TeamResponse(id = 2L, part = "개발본부2", name = "프론트팀", color = "#A52A2A"),
        )
    }

    @Operation(summary = "팀 부서 별 조회")
    @GetMapping("/v1/teams/{part}")
    suspend fun findAllByPart(@PathVariable part: String): List<TeamResponse> {
        return listOf(
            TeamResponse(id = 1L, part = "개발본부", name = "서버팀", color = "#8B0000"),
            TeamResponse(id = 2L, part = "개발본부", name = "프론트팀", color = "#A52A2A"),
        )
    }
}
