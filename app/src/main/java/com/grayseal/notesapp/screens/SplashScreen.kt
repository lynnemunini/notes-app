package com.grayseal.notesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.grayseal.notesapp.R
import com.grayseal.notesapp.navigation.NoteScreens
import com.grayseal.notesapp.ui.theme.*

@Composable
fun SplashScreen(navController: NavController) {
    SplashContent(navController = navController)
}


@Composable
fun SplashContent(navController: NavController) {
    val imageModifier = Modifier
        .size(400.dp)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.splash),
            contentDescription = "Splash Screen Image",
            modifier = imageModifier )
        Spacer(modifier = Modifier.height(20.dp))
        Text("Don't use paper again.", style = (TextStyle(color = Color(0xFFdaaac0), fontSize = 25.sp)), fontFamily = sonoFamily, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Text("Organize your notes beautifully", style = (TextStyle(fontSize = 18.sp, color = Color.Black)), fontFamily = sonoFamily, fontWeight = FontWeight.Normal)
        Spacer(Modifier.height(40.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(end = 40.dp), horizontalArrangement = Arrangement.End) {
            NextIconButton(onClick = {navController.navigate(route = NoteScreens.WelcomeScreen.name)})
        }
    }
}

@Composable
private fun NextIconButton(
    onClick: () -> Unit
) {
    FilledTonalIconButton(modifier = Modifier.size(60.dp), onClick = onClick, colors = IconButtonDefaults.filledTonalIconButtonColors(containerColor = Color(0xFFdaaac0)),) {
        Icon(imageVector = Icons.Outlined.Fingerprint,
            modifier = Modifier.size(50.dp),
            contentDescription = "Next",
            tint = Color.White)
    }
}