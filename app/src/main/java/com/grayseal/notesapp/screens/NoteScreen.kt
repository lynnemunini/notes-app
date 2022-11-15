package com.grayseal.notesapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.LeadingIconTab
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.grayseal.notesapp.navigation.NoteScreens
import com.grayseal.notesapp.ui.theme.sonoFamily
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun NoteScreen(navController: NavController) {
    NoteContent(navController = navController)
}

@Composable
fun NoteContent(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp), horizontalArrangement = Arrangement.Center) {
                LeadingIconTab(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(modifier = Modifier.size(60.dp), imageVector = Icons.Outlined.EmojiNature, contentDescription = "Notes", tint = Color(0xFFefcd95).copy(alpha = 0.9f))
                    },
                    text = {
                        Text("Note", color = Color(0xFFefcd95).copy(alpha = 0.9f), style = (TextStyle(fontSize = 30.sp, fontFamily = sonoFamily, fontWeight = FontWeight.Bold)))
                    })
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp), horizontalArrangement = Arrangement.End) {
                SaveButton(navController = navController)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 10.dp, start = 20.dp, end = 20.dp), horizontalArrangement = Arrangement.Start) {
                Text(getCurrentDate(), style = (TextStyle(fontSize = 18.sp, color = Color.Black)), fontFamily = sonoFamily, fontWeight = FontWeight.Normal)
            }
            NoteArea()
        }
    }
}

@Composable
fun NoteArea(){
    var note by remember {
        mutableStateOf("")
    }
    Note(note = note, onNoteChange = {
        note = it
    })
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Note(note: String, onNoteChange: (String) -> Unit){
    val keyboardController = LocalSoftwareKeyboardController.current
    Row(horizontalArrangement = Arrangement.Start){
        TextField(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            value = note,
            onValueChange = onNoteChange,
            placeholder = {
                Text(text = "Write down something...",color = Color.LightGray, fontSize = 18.sp, fontFamily = sonoFamily, fontWeight = FontWeight.Light)
            },
            singleLine = false,
            textStyle = TextStyle(fontSize = 18.sp, color = colors.onBackground, fontFamily = sonoFamily, fontWeight = FontWeight.Normal),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions {
                keyboardController?.hide()
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFF4c6569),
                backgroundColor = MaterialTheme.colors.background,
            )
        )
    }
}

@Composable
fun SaveButton(navController: NavController) {
    TextButton(
        onClick = {navController.navigate(route = NoteScreens.HomeScreen.name)},
        enabled = true,
        contentPadding = PaddingValues(5.dp),
        colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFFdaaac0))
    ) {
        Text("Save", style = (TextStyle(color = Color(0xFFdaaac0), fontSize = 30.sp)), fontFamily = sonoFamily, fontWeight = FontWeight.Bold)
    }
}

fun getCurrentDate(): String {
    // Get Current Date time in localized style
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
    return current.format(formatter)
}