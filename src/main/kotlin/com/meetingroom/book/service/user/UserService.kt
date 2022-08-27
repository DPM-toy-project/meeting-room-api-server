package com.meetingroom.book.service.user

import com.meetingroom.book.controller.user.request.UserRequest
import com.meetingroom.book.repository.TeamRepository
import com.meetingroom.book.repository.UserRepository
import com.meetingroom.book.service.common.mail.MailSendService
import com.meetingroom.book.utils.jwt.JwtUtils
import com.meetingroom.book.utils.jwt.payload.UserInfoPayload
import com.meetingroom.book.utils.validator.EmailValidator
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val teamRepository: TeamRepository,
    private val mailSendService: MailSendService,
    @Value("\${spring.host.dns}") private val dnsName: String,
) {
    @Transactional
    fun create(request: UserRequest): Long {
//        validate(request)

        val team = teamRepository.findById(request.teamId)
            .orElseThrow { IllegalArgumentException("존재하지 않는 team id 입니다. (id : ${request.teamId})") }

        val savedUser = userRepository.save(request.toUser(team))

//        sendVerificationMail(request.email)
        savedUser.accept()

        return savedUser.id!!
    }

    private fun validate(request: UserRequest) {
        EmailValidator.validate(request.email)
    }

    private fun sendVerificationMail(email: String) {
        val token = JwtUtils.generate(UserInfoPayload(email))

        val subject = "인증 메일입니다."
        val content = "http://$dnsName/auth/$token"

        mailSendService.sendMail(email, subject, content)
    }
}