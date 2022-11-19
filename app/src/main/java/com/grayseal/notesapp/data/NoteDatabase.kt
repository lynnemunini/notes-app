package com.grayseal.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.grayseal.notesapp.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    // Function to give DAO
    abstract fun noteDao(): NoteDatabaseDao
}