package com.grayseal.notesapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.grayseal.notesapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val montserratFamily = FontFamily(
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_extralight, FontWeight.ExtraLight),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    )

val notoSansFamily = FontFamily(
    Font(R.font.notosans_bold, FontWeight.Bold),
    Font(R.font.notosans_regular, FontWeight.Normal),
    Font(R.font.notosans_extralight, FontWeight.ExtraLight),
    Font(R.font.notosans_light, FontWeight.Light)
)

val sonoFamily = FontFamily(
    Font(R.font.sono_bold, FontWeight.Bold),
    Font(R.font.sono_regular, FontWeight.Normal),
    Font(R.font.sono_extralight, FontWeight.ExtraLight),
    Font(R.font.sono_light, FontWeight.Light)
)