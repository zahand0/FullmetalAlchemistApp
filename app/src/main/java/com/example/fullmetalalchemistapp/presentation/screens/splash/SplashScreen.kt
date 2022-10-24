package com.example.fullmetalalchemistapp.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.fullmetalalchemistapp.R
import com.example.fullmetalalchemistapp.ui.theme.*

@Composable
fun SplashScreen(
    navController: NavHostController
) {

    val degrees = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
    }

    Splash(degrees = degrees.value)
}

@Composable
fun Splash(degrees: Float) {
    var backgroundColor by remember {
        mutableStateOf(Brush.verticalGradient(
            listOf(
                Purple700,
                DeepPurple400
            )
        ))
    }

    if (isSystemInDarkTheme()) {
        backgroundColor = Brush.verticalGradient(listOf(Color.Black, Grey900))
    }
    Box(
        modifier = Modifier
            .background(
                backgroundColor
            )
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.app_logo),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
                .rotate(degrees)
                .offset(y = (-40).dp)
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenDarkPreview() {
    FullmetalAlchemistAppTheme {
        Splash(degrees = 0f)
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    FullmetalAlchemistAppTheme {
        Splash(degrees = 0f)
    }
}