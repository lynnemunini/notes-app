package com.grayseal.notesapp.screens


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.grayseal.notesapp.model.Note
import com.grayseal.notesapp.model.notes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoteViewModel(
) : ViewModel() {

    private var noteList = mutableListOf<Note>()

    /*init {
        noteList.addAll(notes)
    }*/

    /* Note's State */
    private val _uistate = MutableStateFlow(Note())
    val uiState: StateFlow<Note> = _uistate.asStateFlow()

    /* Set the title of the note*/

    /*Business Logic*/
    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note> {
        return noteList
    }
}