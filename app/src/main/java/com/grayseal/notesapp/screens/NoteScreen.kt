package com.grayseal.notesapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LeadingIconTab
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.grayseal.notesapp.ui.theme.sonoFamily
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun NoteScreen(navController: NavController) {
    NoteContent()
}

@Composable
fun NoteContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp), horizontalArrangement = Arrangement.Center) {
                LeadingIconTab(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(modifier = Modifier.size(50.dp), imageVector = Icons.Outlined.Add, contentDescription = "Notes", tint = Color(0xFFdaaac0))
                    },
                    text = {
                        Text("Notes", style = (TextStyle(fontSize = 25.sp, fontFamily = sonoFamily, fontWeight = FontWeight.Bold)))
                    })
            }
            Row(modifier = Modifier.fillMaxWidth().padding(top = 40.dp, bottom = 40.dp, end = 40.dp), horizontalArrangement = Arrangement.End) {
                Text(getCurrentDate(), style = (TextStyle(fontSize = 18.sp, color = Color.Black)), fontFamily = sonoFamily, fontWeight = FontWeight.Normal)
            }
        }
    }
}

fun getCurrentDate(): String {
    // Get Current Date time in localized style
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
    return current.format(formatter)
}