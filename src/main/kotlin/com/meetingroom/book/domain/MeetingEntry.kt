package com.meetingroom.book.domain

import com.meetingroom.book.constant.EntryStatus
import javax.persistence.*

@Entity
data class MeetingEntry(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(targetEntity = User::class, fetch = FetchType.LAZY)
    val user: User,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    var status: EntryStatus = EntryStatus.READY,
) {
    companion object {
        fun of(user: User) = MeetingEntry(user = user)
    }
}
