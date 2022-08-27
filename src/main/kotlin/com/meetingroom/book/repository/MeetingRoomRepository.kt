package com.meetingroom.book.repository

import com.meetingroom.book.domain.MeetingRoom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MeetingRoomRepository : JpaRepository<MeetingRoom, Long>