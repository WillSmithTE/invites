package com.willsmithte.invites

import org.springframework.stereotype.Service

@Service
class RsvpService(val sheetsService: SheetsService) {

    private val sheetId = "1Be7ybK-gRQibfvnRoaqm56bZuSJaUXI_mdiZjiDqCwg"

    fun addRsvp(rsvp: Rsvp) {
        sheetsService.addRow(sheetId, rsvp)
    }
}