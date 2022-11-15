package com.grayseal.notesapp.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.grayseal.notesapp.model.Note
import com.grayseal.notesapp.model.notes

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp, modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(text = "Lynne")
            }
        }
    }) {
        HomeContent(navController = navController)
    }
}

@Composable
fun HomeContent(navController: NavController) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(notes){
                NoteCard(note = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(note: Note){
    Card(onClick = { /* Do something */ },
        modifier = Modifier.size(width = 180.dp, height = 100.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(note.title)
        }
    }
}
