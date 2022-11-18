package com.grayseal.notesapp.model

data class NoteUiState(
    val notes: List<Note> = mutableListOf(
        Note(
            title = "Mobile Applications Assignment",
            note = "Remember to complete mobile applications development assignment before 26th November"
        ),
    )
)
