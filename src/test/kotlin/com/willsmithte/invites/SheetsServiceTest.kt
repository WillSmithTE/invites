package com.willsmithte.invites

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class SheetsServiceTest {

    @InjectMocks
    private lateinit var sheetsService: SheetsService

    @Test
    fun `should add a row to a spreadsheet`() {
        val sheetId = "1Be7ybK-gRQibfvnRoaqm56bZuSJaUXI_mdiZjiDqCwg"
        val rsvp = Rsvp("John Wallace", 4, "whole fam coming")
        sheetsService.addRow(sheetId, rsvp)
    }
}