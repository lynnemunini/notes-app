package com.grayseal.notesapp.model

import com.grayseal.notesapp.screens.getCurrentDate
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String = "",
    val date: String = getCurrentDate(),
    val note: String = ""
)

/*val notes = listOf(
        Note(
            title = "Mobile Applications Assignment",
            note = "Remember to complete mobile applications development assignment before 26th November"
        ),
)*/