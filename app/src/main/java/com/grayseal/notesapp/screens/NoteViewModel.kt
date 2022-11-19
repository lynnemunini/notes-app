package com.grayseal.notesapp.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.grayseal.notesapp.model.Note


class NoteViewModel : ViewModel() {

    /*======================================*/
                /*Option 1*/
    /*======================================*/


    /* private var noteList = mutableListOf<Note>()

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

    fun deleteNote(note: Note){
        noteList.remove(note)
        _uiState.update { currentState ->
            currentState.copy(
                notes = noteList
            ) }
    }

    fun getAllNotes(): List<Note> {
        return uiState.value.notes
    } */



    /*======================================*/
                /*Option 2*/
    /*======================================*/


    private var noteList = mutableStateListOf<Note>()

    fun addNote(note: Note){
        noteList.add(note)
    }

    fun deleteNote(note: Note){
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note>{
        return noteList
    }
}