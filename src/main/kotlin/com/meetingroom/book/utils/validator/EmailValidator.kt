package com.meetingroom.book.utils.validator

object EmailValidator: FieldValidator<String> {
    private val EMAIL_REGEX = "^[a-zA-Z\\d+-_.]+@ex-em.com\$".toRegex()

    override fun validate(field: String) {
        if (!field.matches(EMAIL_REGEX)) {
            throw IllegalArgumentException("email 의 형식이 올바르지 않습니다. ($field)")
        }
    }
}