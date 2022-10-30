package com.example.fullmetalalchemistapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple500,
    secondary = Teal200,
    background = DarkGrey,
    surface = DarkGreyLighter,
    onSurface = LightGrey
//    onBackground = LightGrey,
//    onSurface = LightGrey,
//    onPrimary = LightGrey
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = LightCream300,
    surface = LightCream400,
    onSurface = DarkGrey
//    onBackground = DarkGrey,
//    onPrimary = Color.White,
//    onSurface = Color.White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun FullmetalAlchemistAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    DisposableEffect(key1 = true) {
        systemUiController.setStatusBarColor(
            color = colors.background,
            darkIcons = !darkTheme
        )
        onDispose {}
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
