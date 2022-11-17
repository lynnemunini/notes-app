package com.grayseal.notesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EmojiNature
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.grayseal.notesapp.navigation.NoteScreens
import com.grayseal.notesapp.ui.theme.sonoFamily

@Composable
fun WelcomeScreen(navController: NavController) {
    Name(navController = navController)
}

@Composable
fun Name(navController: NavController) {
    var name by remember {
        mutableStateOf("")
    }

    WelcomeContent(navController = navController, name = name, onNameChange = { name = it })
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun WelcomeContent(navController: NavController, name: String, onNameChange: (String) -> Unit) {
    val imageModifier = Modifier
        .size(250.dp)
    val keyboardController = LocalSoftwareKeyboardController.current
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
        Text(
            "This notes book belongs to",
            style = (TextStyle(fontSize = 18.sp, color = Color.Black)),
            fontFamily = sonoFamily,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            modifier = Modifier.padding(start = 15.dp),
            value = name,
            onValueChange = onNameChange,
            placeholder = {
                Text(
                    text = "What's your name?",
                    fontSize = 18.sp,
                    fontFamily = sonoFamily,
                    fontWeight = FontWeight.Light
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(end = 12.dp),
                    imageVector = Icons.Outlined.EmojiNature,
                    contentDescription = "Nature Icon",
                )
            },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 18.sp,
                color = MaterialTheme.colors.onBackground,
                fontFamily = sonoFamily,
                fontWeight = FontWeight.Normal
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions {
                keyboardController?.hide()
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.LightGray,
                focusedBorderColor = Color(0xFFdaaac0),
                unfocusedBorderColor = Color(0xFF4c6569),
                leadingIconColor = Color(0xFFdaaac0),
                cursorColor = Color(0xFF4c6569),
                placeholderColor = Color.LightGray
            )
        )
        Spacer(modifier = Modifier.height(80.dp))
        StartButton(navController = navController)
    }
}


@Composable
fun StartButton(navController: NavController) {
    ElevatedButton(
        modifier = Modifier
            .width(130.dp)
            .height(50.dp),
        onClick = { navController.navigate(route = NoteScreens.HomeScreen.name) },
        enabled = true,
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(5.dp),
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = Color(
                0xFFdaaac0
            )
        )
    ) {
        Text(
            "Start",
            style = (TextStyle(fontSize = 20.sp, color = Color.White)),
            fontFamily = sonoFamily,
            fontWeight = FontWeight.Normal
        )
    }
}