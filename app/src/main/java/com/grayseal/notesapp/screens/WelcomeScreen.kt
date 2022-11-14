package com.grayseal.notesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EmojiNature
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.grayseal.notesapp.ui.theme.sonoFamily

@Composable
fun WelcomeScreen(navController: NavController) {
    Name()

}

@Composable
fun Name() {
    var name by remember{
        mutableStateOf("")
    }
    WelcomeContent(name = name, onNameChange = {name = it})
}

@Composable
fun WelcomeContent(name: String, onNameChange: (String) -> Unit) {
    val imageModifier = Modifier
        .size(250.dp)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = com.grayseal.notesapp.R.drawable.welcome),
            contentDescription = "Splash Screen Image",
            modifier = imageModifier
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text("This notes book belongs to", style = (TextStyle(fontSize = 18.sp, color = Color.Black)), fontFamily = sonoFamily, fontWeight = FontWeight.Normal)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.padding(start = 40.dp),
            value = name,
            onValueChange = onNameChange,
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(60.dp),
                    imageVector = Icons.Outlined.EmojiNature,
                    contentDescription = "Nature Icon",
                )
            },
            singleLine = true,
            textStyle = TextStyle(textIndent = TextIndent(12.sp), fontSize = 18.sp, color = MaterialTheme.colors.onBackground, fontFamily = sonoFamily, fontWeight = FontWeight.Normal),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions.Default,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.LightGray,
                focusedBorderColor = Color(0xFFdaaac0),
                unfocusedBorderColor = Color(0xFF4c6569),
                leadingIconColor = Color(0xFFdaaac0),
                cursorColor = Color(0xFF4c6569),
            )

        )
    }
}