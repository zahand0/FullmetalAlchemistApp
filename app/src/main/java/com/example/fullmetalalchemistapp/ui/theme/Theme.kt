package com.example.fullmetalalchemistapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Purple700,
    primaryVariant = Purple500,
    secondary = Teal200,
    background = Grey900,
    surface = DarkGrey,
    onBackground = LightGrey,
    onSurface = LightGrey,
    onPrimary = LightGrey
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.White,
    surface = Purple700,
    onBackground = DarkGrey,
    onPrimary = Color.White,
    onSurface = Color.White

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
    val statusBarColor = colors.surface
    val navigationBarColor = Color.Black
    DisposableEffect(systemUiController) {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = false
        )
        systemUiController.setNavigationBarColor(
            color = navigationBarColor,
            darkIcons = false
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