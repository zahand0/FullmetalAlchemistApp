package com.example.fullmetalalchemistapp.presentation.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fullmetalalchemistapp.R
import com.example.fullmetalalchemistapp.ui.theme.FullmetalAlchemistAppTheme

@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Explore",
                color = MaterialTheme.colors.onBackground
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon),
                    tint = MaterialTheme.colors.primary
                )
            }
        },
        elevation = 4.dp
    )
}

@Preview
@Composable
fun HomeTopBarPreview() {
    FullmetalAlchemistAppTheme {
        HomeTopBar {}
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeTopBarDarkPreview() {
    FullmetalAlchemistAppTheme {
        HomeTopBar {}
    }
}