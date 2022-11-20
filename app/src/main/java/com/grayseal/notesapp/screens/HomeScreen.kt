package com.grayseal.notesapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Delete
import androidx.compose.material.icons.sharp.Eco
import androidx.compose.material.icons.sharp.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.grayseal.notesapp.model.Note
import com.grayseal.notesapp.navigation.NoteScreens
import com.grayseal.notesapp.ui.theme.sonoFamily

@Composable
fun HomeScreen(navController: NavController, noteViewModel: NoteViewModel) {
    Scaffold(
        floatingActionButton = { FloatingAddNoteButton(navController = navController) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
            ) {
                Avatar()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, start = 20.dp, bottom = 10.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Saved Notes",
                        style = (TextStyle(color = Color(0xFFdaaac0), fontSize = 30.sp)),
                        fontFamily = sonoFamily,
                        fontWeight = FontWeight.Bold
                    )
                }
                HomeContent(noteViewModel = noteViewModel)
            }
        },
    )
}


@Composable
fun HomeContent(noteViewModel: NoteViewModel) {
    /*get all Notes*/
    val notesList = noteViewModel.noteList.collectAsState().value
    Column(modifier = Modifier.padding(20.dp)) {
        LazyColumn {
            items(notesList) {
                NoteCard(note = it, onRemoveNote = { noteViewModel.deleteNote(it) })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(note: Note, onRemoveNote: (Note) -> Unit) {
    OutlinedCard(
        onClick = {
            /*noteViewModel.removeNote(note)*/
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 20.dp)
            .clip(RoundedCornerShape(10.dp)),
        colors = CardDefaults.outlinedCardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(0.2.dp, color = Color(0xFFefcd95)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                note.title,
                fontSize = 18.sp,
                color = Color.DarkGray,
                fontFamily = sonoFamily,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(15.dp))
            Text(
                note.note,
                fontSize = 14.sp,
                color = Color(0xFF92a4a2),
                fontFamily = sonoFamily,
                fontWeight = FontWeight.Normal
            )
            Spacer(Modifier.height(15.dp))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(Modifier.height(15.dp))
            Text(note.entry_date.toString(), fontSize = 12.sp, color = Color.LightGray, fontFamily = sonoFamily)
            Spacer(Modifier.weight(2f))
            Icon(
                modifier = Modifier.clickable {
                    onRemoveNote(note)
                },
                imageVector = Icons.Sharp.Delete,
                contentDescription = "Delete",
                tint = Color.Red.copy(alpha = .4f)
            )
        }
    }
}

@Composable
fun FloatingAddNoteButton(navController: NavController) {
    FloatingActionButton(
        modifier = Modifier.padding(bottom = 30.dp),
        onClick = { navController.navigate(route = NoteScreens.NoteScreen.name) },
        containerColor = Color(0xFFdaaac0)
    )

    {
        Icon(
            imageVector = Icons.Sharp.Edit,
            contentDescription = "Add Note",
            tint = Color.White
        )
    }
}

@Composable
fun Avatar() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                modifier = Modifier.size(50.dp),
                imageVector = Icons.Sharp.Eco,
                contentDescription = "Avatar",
                tint = Color(0xFFefcd95).copy(alpha = 0.2f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            /*Text("Lynne", fontSize = 20.sp, fontFamily = sonoFamily, fontWeight = FontWeight.ExtraLight)*/
        }

    }
}
