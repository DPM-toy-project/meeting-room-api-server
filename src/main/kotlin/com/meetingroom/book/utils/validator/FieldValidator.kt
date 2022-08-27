package com.meetingroom.book.utils.validator

interface FieldValidator<T> {
    fun validate(field: T)
}