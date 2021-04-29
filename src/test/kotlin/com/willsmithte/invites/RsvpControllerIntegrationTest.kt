package com.willsmithte.invites

import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@WebMvcTest(RsvpController::class)
@ContextConfiguration(classes = [RsvpService::class, SheetsService::class])
internal class RsvpControllerIntegrationTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun `should add an rsvp to the sheet`() {
        mvc.perform(
            post("/api/rsvp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(// language=JSON
                    """ 
                    {
                      "name": "Pip K",
                      "attendees": 2,
                      "comments": "hello"
                    }
                """.trimIndent()
                )
        )
    }
}