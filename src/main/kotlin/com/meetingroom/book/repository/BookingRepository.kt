package com.meetingroom.book.repository

import com.meetingroom.book.domain.Booking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingRepository : JpaRepository<Booking, Long>