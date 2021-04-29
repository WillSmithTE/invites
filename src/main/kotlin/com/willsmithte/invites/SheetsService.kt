package com.willsmithte.invites

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.SheetsScopes
import com.google.api.services.sheets.v4.model.ValueRange
import org.springframework.stereotype.Service
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential


@Service
class SheetsService {
    private val APPLICATION_NAME = "RSVP Yo"
    private val JSON_FACTORY: JsonFactory = JacksonFactory.getDefaultInstance()

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */

    private val SCOPES = listOf(SheetsScopes.SPREADSHEETS)
    //    private val CREDENTIALS_FILE_PATH = "/credentials.json"
    private val CREDENTIALS_FILE_PATH = "/rsvp-6eec7ad17d92.json"
    private val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()
    private val valueInputOption = "RAW"

    fun addRow(sheetId: String, rsvp: Rsvp) {
        val insertDataOption = "INSERT_ROWS"
        val toSave = listOf<List<Any>>(
            listOf(
                rsvp.name,
                rsvp.attendees.toString(),
                rsvp.comments ?: "",
            )
        )
        val valueRange = ValueRange().setValues(toSave)
        val range = "A2:C2"
        val service = Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials())
            .setApplicationName(APPLICATION_NAME)
            .build()
        val response = service.spreadsheets().values().append(sheetId, range, valueRange)
            .setValueInputOption(valueInputOption)
            .setInsertDataOption(insertDataOption)
            .execute()
        println(response.values)
    }

    private fun getCredentials(): GoogleCredential? {
        val input = SheetsService::class.java.getResourceAsStream(CREDENTIALS_FILE_PATH)

        return GoogleCredential
            .fromStream(input)
            .createScoped(SCOPES)
    }
}
