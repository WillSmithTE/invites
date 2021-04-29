package com.willsmithte.invites

data class Rsvp(
    val name: String,
    val attendees: Number,
    val comments: String? = null,
)