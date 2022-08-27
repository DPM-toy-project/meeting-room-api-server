package com.meetingroom.book.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Booking(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, length = 64)
    var title: String,
    @ManyToOne(targetEntity = User::class, fetch = FetchType.LAZY)
    var owner: User,
    @ManyToOne(targetEntity = MeetingRoom::class, fetch = FetchType.LAZY)
    var meetingRoom: MeetingRoom,
    @ManyToMany
    var entries: MutableList<MeetingEntry> = mutableListOf(),
    @Column(nullable = false)
    var startDateTime: LocalDateTime,
    @Column(nullable = false)
    var endDateTime: LocalDateTime,
    @Column(length = 256)
    var description: String = "",
    var notify: Boolean = false,
) : AuditBase()
