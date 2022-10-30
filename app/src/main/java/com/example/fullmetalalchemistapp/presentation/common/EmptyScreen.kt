package com.example.fullmetalalchemistapp.presentation.common

import android.content.Context
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import com.example.fullmetalalchemistapp.R
import com.example.fullmetalalchemistapp.ui.theme.FullmetalAlchemistAppTheme
import com.example.fullmetalalchemistapp.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import com.example.fullmetalalchemistapp.ui.theme.SMALL_PADDING
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(
    error: LoadState.Error? = null
) {
    val context = LocalContext.current
    var message by remember {
        mutableStateOf(
            context.getString(R.string.find_your_hero)
        )
    }
    var icon by remember {
        mutableStateOf(R.drawable.ic_search_document)
    }

    if (error != null) {
        message = parseErrorMessage(
            error = error,
            context = context
        )
        icon = R.drawable.ic_network_error
    }

    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation)
            ContentAlpha.disabled else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

    EmptyContent(
        message = message,
        icon = icon,
        alphaAnim = alphaAnim
    )
}

@Composable
fun EmptyContent(
    message: String,
    @DrawableRes icon: Int,
    alphaAnim: Float
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(NETWORK_ERROR_ICON_HEIGHT)
                .alpha(alphaAnim),
            painter = painterResource(id = icon),
            contentDescription = stringResource(R.string.network_error_icon),
            tint = MaterialTheme.colors.onSurface
        )
        Text(
            modifier = Modifier
                .padding(top = SMALL_PADDING)
                .alpha(alphaAnim),
            text = message,
            color = MaterialTheme.colors.onSurface,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )
    }
}

private fun parseErrorMessage(
    error: LoadState.Error,
    context: Context
): String {
    return when (error.error) {
        is SocketTimeoutException -> {
            context.getString(R.string.server_unavailable)
        }
        is ConnectException -> {
            context.getString(R.string.internet_unavailable)
        }
        else -> {
            context.getString(R.string.unknown_error)
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun EmptyScreenPreview() {
    FullmetalAlchemistAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            EmptyContent(
                message = "Internet Unavailable.",
                icon = R.drawable.ic_network_error,
                alphaAnim = ContentAlpha.disabled
            )
        }
    }
}
