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

val Grey900 = Color(0xFF212121)

val LightGrey = Color(0xFFD8D8D8)
val DarkGrey = Color(0xFF1A1A1A)

val Colors.backgroundColorBrush
    @Composable
    get() = if (isLight)
        Brush.verticalGradient(listOf(Purple700, DeepPurple400))
    else
        Brush.verticalGradient(listOf(Grey900, Color.Black))

//val Colors.activeIndicatorColor
//    @Composable
//    get() = this.primary

val Colors.inactiveIndicatorColor
    @Composable
    get() = if (isLight) LightGrey else DarkGrey