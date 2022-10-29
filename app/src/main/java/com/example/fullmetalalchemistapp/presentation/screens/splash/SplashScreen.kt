package com.example.fullmetalalchemistapp.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.fullmetalalchemistapp.R
import com.example.fullmetalalchemistapp.navigation.Screen
import com.example.fullmetalalchemistapp.ui.theme.FullmetalAlchemistAppTheme
import com.example.fullmetalalchemistapp.ui.theme.backgroundColorBrush
import com.example.fullmetalalchemistapp.ui.theme.logoColor

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()

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
        navController.popBackStack()
        if (onBoardingCompleted) {
            navController.navigate(Screen.Home.route)
        } else {
            navController.navigate(Screen.Welcome.route)
        }
    }

    Splash(degrees = degrees.value)

}

@Composable
fun Splash(degrees: Float) {
    Box(
        modifier = Modifier
            .background(
                MaterialTheme.colors.backgroundColorBrush
            )
            .fillMaxSize()
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.app_logo),
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
                .rotate(degrees)
                .offset(y = (-40).dp),
            tint = MaterialTheme.colors.logoColor
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