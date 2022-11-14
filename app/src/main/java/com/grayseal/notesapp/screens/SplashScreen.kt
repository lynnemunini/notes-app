package com.grayseal.notesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.grayseal.notesapp.R
import com.grayseal.notesapp.ui.theme.*

@Composable
fun SplashScreen(navController: NavController) {
    Content()
}


@Composable
fun Content() {
    val imageModifier = Modifier.size(400.dp)
        .padding(top = 30.dp)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.splash),
            contentDescription = "Splash Screen Image",
            modifier = imageModifier )
        Spacer(modifier = Modifier.height(20.dp))
        Text("Don't use paper again.", style = (TextStyle(color = Color(0xFF736064), fontSize = 25.sp)), fontFamily = sonoFamily, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Text("Capture life beautifully", style = (TextStyle(fontSize = 18.sp, color = Color.Black)), fontFamily = sonoFamily, fontWeight = FontWeight.ExtraLight)
    }
}