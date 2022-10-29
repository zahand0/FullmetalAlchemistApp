package com.example.fullmetalalchemistapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightCream100 = Color(0xfff9f9f7)
val LightCream300 = Color(0xffefeee8)
val LightCream400 = Color(0xffeae8e0)

val LightGrey = Color(0xFFD8D8D8)
val DarkGrey = Color(0xFF1F1F1F)
val DarkGreyLighter = Color(0xFF2A2A2A)

val ShimmerLightGray = Color(0xFFF1F1F1)
val ShimmerMediumGray = Color(0xFFE3E3E3)
val ShimmerDarkGray = Color(0xFF1D1D1D)

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
