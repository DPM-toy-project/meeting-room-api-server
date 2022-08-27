package com.meetingroom.book.domain

import javax.persistence.*

@Entity
data class MeetingRoom(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, length = 32)
    var name: String,
    @Column(nullable = false)
    var floor: Int,
    @OneToMany(mappedBy = "meetingRoom", orphanRemoval = true, cascade = [CascadeType.ALL])
    var bookings: MutableList<Booking> = mutableListOf()
)
