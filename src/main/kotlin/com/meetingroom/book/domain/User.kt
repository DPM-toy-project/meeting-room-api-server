package com.meetingroom.book.domain

import javax.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, length = 64)
    var email: String,
    @Column(nullable = false, length = 8)
    var name: String,
    @Column(nullable = false, length = 32)
    var password: String,
    @ManyToOne(targetEntity = Team::class, fetch = FetchType.LAZY)
    var team: Team,
    @Column(nullable = false)
    var accepted: Boolean = false,
    @OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = [CascadeType.ALL])
    var bookings: MutableList<Booking> = mutableListOf()
) : AuditBase() {
    fun accept() {
        accepted = true
    }
}
