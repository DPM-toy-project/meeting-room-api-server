package com.meetingroom.book.domain

import javax.persistence.*

@Entity
data class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, length = 32)
    var part: String,
    @Column(nullable = false, length = 32)
    var name: String,
    @Column(nullable = false, length = 32)
    var color: String
)
