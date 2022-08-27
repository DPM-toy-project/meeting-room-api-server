package com.meetingroom.book.service.team

import com.meetingroom.book.controller.team.request.TeamRequest
import com.meetingroom.book.repository.TeamRepository
import com.meetingroom.book.utils.validator.RgbValidator
import org.springframework.stereotype.Service

@Service
class TeamService(
    private val teamRepository: TeamRepository,
) {
    fun create(request: TeamRequest): Long {
        validate(request)

        val savedTeam = teamRepository.save(request.toTeam())

        return savedTeam.id!!
    }

    private fun validate(request: TeamRequest) {
        RgbValidator.validate(request.color)
    }
}