package com.meetingroom.book.utils.validator

object RgbValidator: FieldValidator<String> {
    private val RGB_REGEX = "^#[A-F\\d]{6}".toRegex()

    override fun validate(field: String) {
        if (!field.matches(RGB_REGEX)) {
            throw IllegalArgumentException("rgb 의 형식이 올바르지 않습니다. ($field)")
        }
    }
}