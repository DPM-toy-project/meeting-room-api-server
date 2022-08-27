package com.meetingroom.book.service.common.mail

import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage
import org.springframework.stereotype.Service

@Service
class MailSendService(
    val mailSender: MailSender,
) {
    fun sendMail(
        to: String,
        subject: String,
        content: String,
    ) {
        val simpleMailMessage = createSimpleMailMessage(to, subject, content)

        mailSender.send(simpleMailMessage)
    }

    private fun createSimpleMailMessage(
        to: String,
        subject: String,
        content: String,
    ) : SimpleMailMessage {
        val simpleMailMessage = SimpleMailMessage()

        simpleMailMessage.setFrom(FROM_EMAIL)
        simpleMailMessage.setTo(to)
        simpleMailMessage.setSubject(subject)
        simpleMailMessage.setText(content)

        return simpleMailMessage
    }

    companion object {
        const val FROM_EMAIL = "meeting.room"
    }
}