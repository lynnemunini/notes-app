package com.grayseal.notesapp.model

import com.grayseal.notesapp.screens.getCurrentDate
import java.util.*

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String = "",
    val date: String = getCurrentDate(),
    val note: String = ""
)
