package com.meetingroom.book.utils.jwt.payload

import java.time.LocalDateTime

data class UserInfoPayload(
    val email: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) : JwtPayload