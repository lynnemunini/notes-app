package com.grayseal.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.grayseal.notesapp.model.Note

@Dao
interface NoteDatabaseDao {

    /*Return list of notes from database*/
    @Query("SELECT * from notes")
    fun getNotes(): List<Note>

    /*Return note with a specific id*/
    @Query("SELECT * from notes where id =:id")
    fun getNoteById(id: String): Note

    /*Insert a note to database. If there's any conflict or errors it's replaced with new one*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    /*Update*/
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    /*Delete All*/
    @Query("DELETE from notes")
    fun deleteAll()

    /*Delete a note*/
    @Delete
    fun deleteNote(note: Note)

}
