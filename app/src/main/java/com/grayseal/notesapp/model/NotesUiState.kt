package com.grayseal.notesapp.model

data class NotesUiState(
    val notes: List<Note> = mutableListOf()
)
