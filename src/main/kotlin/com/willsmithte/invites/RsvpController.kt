package com.willsmithte.invites

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/rsvp")
@RestController
class RsvpController(val rsvpService: RsvpService) {
    @CrossOrigin("*")
    @PostMapping
    fun addRsvp(@RequestBody rsvp: Rsvp) = rsvpService.addRsvp(rsvp)
}