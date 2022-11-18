package com.grayseal.notesapp.screens

import androidx.lifecycle.ViewModel
import com.grayseal.notesapp.model.Note
import com.grayseal.notesapp.model.NotesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class NoteViewModel : ViewModel() {

    private var noteList = mutableListOf<Note>()

    private val _uiState = MutableStateFlow(NotesUiState())
    private val uiState: StateFlow<NotesUiState> = _uiState.asStateFlow()

    fun addNote(note: Note) {
        noteList.add(note)
        _uiState.update { currentState ->
            currentState.copy(
                notes = noteList
            )
        }
    }

    fun getAllNotes(): List<Note> {
        return uiState.value.notes
    }
}