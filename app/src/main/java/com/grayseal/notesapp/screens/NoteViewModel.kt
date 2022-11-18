package com.grayseal.notesapp.screens

import androidx.lifecycle.ViewModel
import com.grayseal.notesapp.model.Note
import com.grayseal.notesapp.model.NoteUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class NoteViewModel(
) : ViewModel() {

    /*private var noteList = mutableListOf<Note>()*/

    private val _uiState = MutableStateFlow(NoteUiState())
    private val uiState: StateFlow<NoteUiState> = _uiState.asStateFlow()

    init {
        uiState.value.notes
    }


    /*Business Logic*/
    fun addNote(note: Note) {
        /*noteList.add(note)*/
        _uiState.update {currentState ->
            currentState.copy(
                notes = listOf(note)
            )
        }
    }

    fun getAllNotes(): List<Note> {
        return uiState.value.notes
    }
}