package com.example.fullmetalalchemistapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)

val Teal200 = Color(0xFF03DAC5)

val Pink50 = Color(0xFFFCE4EC)

val DeepPurple200 = Color(0xFFb39ddb)
val DeepPurple400 = Color(0xFF7e57c2)
val DeepPurple700 = Color(0xFF7b1fa2)

val Indigo50 = Color(0xFFe8eaf6)
val Indigo100 = Color(0xFFc5cae9)

val LightBlue50 = Color(0xFFe1f5fe)
val LightBlue100 = Color(0xFFb3e5fc)

val Grey800 = Color(0xFF323232)
val Grey900 = Color(0xFF212121)
val Grey950 = Color(0xFF202020)
val Grey990 = Color(0xFF1B1B1B)

val LightCream100 = Color(0xfff9f9f7)
val LightCream300 = Color(0xffefeee8)
val LightCream400 = Color(0xffeae8e0)

val LightGrey = Color(0xFFD8D8D8)
val DarkGrey = Color(0xFF1F1F1F)
val DarkGreyLighter = Color(0xFF2A2A2A)

val Colors.backgroundColorBrush
    @Composable
    get() = Brush.verticalGradient(
        if (isLight) {
            listOf(LightCream300, LightCream100)
        } else {
            listOf(DarkGrey, Color.Black)
        }
    )

val Colors.logoColor
    @Composable
    get() = if (isLight) {
        Color.Black
    } else {
        Color.White
    }

val inactiveIndicatorColor = LightGrey

val Amber300 = Color(0xFFffd54f)
