package com.willsmithte.invites

import org.springframework.stereotype.Service

@Service
class RsvpService {

    fun addRsvp(rsvp: Rsvp) {
        println(rsvp)
    }
}