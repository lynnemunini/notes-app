package com.grayseal.notesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.grayseal.notesapp.screens.getCurrentDate
import java.time.Instant
import java.util.*

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title: String = "",

    @ColumnInfo(name = "note_entry_date")
    val date: Date = Date.from(Instant.now()),

    @ColumnInfo(name = "note_description")
    val note: String = ""
)
